package ar.edu.unq.desapp.grupoa.backenddesappapi.service.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseBodyList> listAllProjects();

    ProjectResponseBody getById(Integer id) throws InvalidException;

    Integer save(ProjectBodyPost project) throws InvalidOrNullFieldException, InvalidException;

    void delete(Integer id) throws InvalidException;

    ProjectResponseBody update(ProjectBodyPut project, Long id) throws InvalidException, InvalidOrNullFieldException;
}
