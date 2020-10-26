package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.project.ProjectService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private @Autowired ProjectService projectService;

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users", response = ProjectResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listProjects() {
        return new ResponseEntity<> (projectService.listAllProjects(), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = ProjectResponseBody.class),
    })
    public ResponseEntity<ProjectResponseBody> getProject(@PathVariable Integer id) throws InvalidIdException {
        return new ResponseEntity<>(projectService.getById(id), HttpStatus.OK);
    }

    //update
    @PutMapping(value = "/{id}", produces = { "application/json" },consumes = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = ProjectResponseBody.class),
    })
    public  ResponseEntity<ProjectResponseBody> updateProject(@RequestBody ProjectBodyPut project, @PathVariable Long id) throws InvalidIdException, InvalidOrNullFieldException {
        return new ResponseEntity<>(projectService.update(project, id), HttpStatus.OK);
    }

    //ADD_ONE
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<Integer> addProject(@RequestBody ProjectBodyPost projectBody) throws InvalidOrNullFieldException, InvalidIdException {
        return new ResponseEntity<>(projectService.save(projectBody), HttpStatus.OK);
    }

    //DELETE_ONE
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<String> deleteProject(@PathVariable Integer id) throws InvalidIdException {
        projectService.delete(id);
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
}
