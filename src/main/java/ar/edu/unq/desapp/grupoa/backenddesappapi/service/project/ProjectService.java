package ar.edu.unq.desapp.grupoa.backenddesappapi.service.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectFilter;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;

import java.io.IOException;
import java.util.List;

public interface ProjectService {
    List<ProjectResponseBodyList> listAllProjects();

    ProjectResponseBody getById(Integer id) throws InvalidException;

    Integer save(ProjectBodyPost project, Long userId) throws InvalidOrNullFieldException, InvalidException;

    void delete(Integer id, Integer userId) throws InvalidException;

    ProjectResponseBody update(ProjectBodyPut project, Long id, Long userId) throws InvalidException, InvalidOrNullFieldException;

    ProjectResponseBody closeProject(Long id, Long userId) throws InvalidException, IOException;

    List<ProjectResponseBodyList> filterProjects(ProjectFilter body);

    List<ProjectResponseBodyList> topProjects() throws InvalidException, IOException;

    List<Locality> tenLocallities();
}
