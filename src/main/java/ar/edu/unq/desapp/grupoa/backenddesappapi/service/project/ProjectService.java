package ar.edu.unq.desapp.grupoa.backenddesappapi.service.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;

import java.util.List;

public interface ProjectService {
    List<ProjectResponseBodyList> listAllProjects();

    ProjectResponseBody getById(Integer id) throws InvalidIdException;

    Integer save(ProjectBodyPost project) throws InvalidOrNullFieldException, InvalidIdException;

    void delete(Integer id) throws InvalidIdException;

    ProjectResponseBody update(ProjectBodyPut project, Long id) throws InvalidIdException, InvalidOrNullFieldException;
}
