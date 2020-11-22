package ar.edu.unq.desapp.grupoa.backenddesappapi.service.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectFilter;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.locality.LocalityDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project.ProjectDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.user.UserDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.Requester;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProjectServiceImp implements ProjectService {

    private @Autowired ProjectDAO projectDAO;
    private @Autowired LocalityDAO localityDAO;
    private @Autowired UserDAO userDAO;
    private Requester requester = new Requester();

    @Override
    public List<ProjectResponseBodyList> listAllProjects() {
            return ((List<Project>) projectDAO.findAll())
                    .stream()
                    .map(ProjectResponseBodyList::new)
                    .collect(Collectors.toList());
    }

    @Override
    public List<ProjectResponseBodyList> filterProjects(ProjectFilter body) {
        if(!StringUtils.hasText(body.getDate())) {
            return ((List<Project>) projectDAO.findAll())
                    .stream()
                    .filter(project -> project.getName().contains(body.getWord()))
                    .map(ProjectResponseBodyList::new)
                    .collect(Collectors.toList());
        }
        else{
            return ((List<Project>) projectDAO.findAll())
                    .stream()
                    .filter(project -> project.getDeadline().isAfter(LocalDate.parse(body.getDate())))
                    .filter(project -> project.getName().contains(body.getWord()))
                    .map(ProjectResponseBodyList::new)
                    .collect(Collectors.toList());
        }
    }

    @Override
    public ProjectResponseBody getById(Integer id) throws InvalidException {
        Long value = Long.valueOf(id);
        validateId(value);
        Project recoverProject = projectDAO.findById(value).orElse(new Project());
        return new ProjectResponseBody(recoverProject);
    }

    @Override
    public Integer save(ProjectBodyPost body, Long userId) throws InvalidOrNullFieldException, InvalidException {
        this.validateAdminId(userId);
        this.validateIsAdmin(userId);

        this.validateNewProjectBody(body);
        Locality locality = localityDAO.findById(body.getLocalityId()).orElse(new Locality());
        Project project = new Project();
        return projectDAO.save(project.setBody(body, locality)).getId().intValue();
    }

    @Override
    public void delete(Integer id, Integer userId) throws InvalidException {
        Long value = Long.valueOf(id);
        validateId(value);
        Long adminId = Long.valueOf(userId);
        validateAdminId(adminId);
        validateIsAdmin(adminId);
        projectDAO.deleteById(value);
    }

    @Override
    public ProjectResponseBody update(ProjectBodyPut project, Long id, Long userId) throws InvalidException, InvalidOrNullFieldException {
        this.validateId(id);

        this.validateAdminId(userId);
        this.validateIsAdmin(userId);

        Project recoveredProject = projectDAO.findById(id).orElse(new Project());

        this.validateName(project.getName());
        this.validateFantasyName(project.getFantasyName());
        this.validateDeadline(project.getDeadline(), recoveredProject.getStartDate());
        this.validateMinPercentage(project.getMinimumClosingPercentage());
        this.validateFactor(project.getFactor());

        recoveredProject.updateProject(project);
        projectDAO.save(recoveredProject);

        return new ProjectResponseBody(recoveredProject);
    }

    @Override
    public ProjectResponseBody closeProject(Long id, Long userId) throws InvalidException, IOException {
        validateAdminId(userId);
        validateIsAdmin(userId);
        validateId(id);
        Project recoverProject = projectDAO.findById(id).orElse(new Project());
        recoverProject.closeProject();
        projectDAO.save(recoverProject);
        recoverProject.getDonations().forEach(donation -> {
            try {
                String subject = "the project "+ recoverProject.getName()+ "has been close";
                String message = "this mail is to inform you that the project "+ recoverProject.getName() + " will be close";
                this.requester.requestToNotify(subject, message, donation.getEmail());
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return new ProjectResponseBody(recoverProject);
    }

    private void validateAdminId(Long adminId) throws InvalidException {
        if(!userDAO.existsById(adminId)){
            throw new InvalidException("id: "+adminId);
        }
    }

    private void validateIsAdmin(Long adminId) throws InvalidException {
        User recoveredUser = userDAO.findById(adminId).orElse(new User());
        if(!recoveredUser.getIsAdmin()){
            throw new InvalidException("error: permission denied to id "+adminId);
        }
    }

    private void validateId(Long id) throws InvalidException {
        if (!projectDAO.existsById(id)){
            throw new InvalidException("id: "+id);
        }
    }

    private void validateNewProjectBody(ProjectBodyPost body) throws InvalidOrNullFieldException, InvalidException {
        this.validateName(body.getName());
        this.validateFantasyName(body.getFantasyName());
        this.validateLocality(body.getLocalityId());
        this.validateMinPercentage(body.getMinimumClosingPercentage());
        this.validateFactor(body.getFactor());
        this.validateStartDate(body.getStartDate());
        this.validateDeadline(body.getDeadline(), body.getStartDate());
    }

    private void validateDeadline(LocalDate deadline, LocalDate startDate) throws InvalidOrNullFieldException {
        if ( deadline == null || deadline.isBefore(startDate) && deadline.isBefore(LocalDate.now())){
            throw new InvalidOrNullFieldException("deadline");
        }
    }

    private void validateStartDate(LocalDate startDate) throws InvalidOrNullFieldException {
        if (startDate == null || ! startDate.isAfter(LocalDate.now())){
            throw new InvalidOrNullFieldException("startDate");
        }
    }

    private void validateFactor(Double factor) throws InvalidOrNullFieldException {
        if (factor < 0){
            throw new InvalidOrNullFieldException("factor");
        }
    }

    private void validateMinPercentage(Double minimumClosingPercentage) throws InvalidOrNullFieldException {
        if (minimumClosingPercentage == null || (Double.compare(minimumClosingPercentage, 0.0) < 0)){
            throw new InvalidOrNullFieldException("minimumClosingPercentage");
        }
    }

    private void validateLocality(Long localityId) throws InvalidException {
        if (localityId == null || ! localityDAO.existsById(localityId)){
            throw new InvalidException("id: "+localityId);
        }
    }

    private void validateFantasyName(String fantasyName) throws InvalidOrNullFieldException {
        if (!StringUtils.hasText(fantasyName)){
            throw new InvalidOrNullFieldException("fantasyName");
        }
    }

    private void validateName(String name) throws InvalidOrNullFieldException {
        if (!StringUtils.hasText(name)){
            throw new InvalidOrNullFieldException("name");
        }
    }

}
