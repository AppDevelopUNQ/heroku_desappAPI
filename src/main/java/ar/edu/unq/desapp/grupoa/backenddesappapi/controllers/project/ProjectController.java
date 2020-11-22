package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody.ProjectFilter;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.project.ProjectService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/project")
@CrossOrigin(origins = "*")
public class ProjectController {

    private @Autowired ProjectService projectService;
    private Logger logger = LoggerFactory.getLogger(ProjectController.class);

    public ProjectController(ProjectService projectService) {
        this.projectService = projectService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users", response = ProjectResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listProjects() {
        logger.info("method: GET | route: /project/list | parameters: none | body: none");
        return new ResponseEntity<> (projectService.listAllProjects(), HttpStatus.OK);
    }

    //get_ALL-filter
    @PutMapping(value = "/filter", produces = { "application/json" },consumes = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users", response = ProjectResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> filterProjects(@RequestBody ProjectFilter body) {
        logger.info("method: GET | route: /project/list | parameters: none | body: none");
        return new ResponseEntity<> (projectService.filterProjects(body), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = ProjectResponseBody.class),
    })
    public ResponseEntity<ProjectResponseBody> getProject(@PathVariable Integer id) throws InvalidException {
        logger.info("method: GET | route: /project/{id} | parameters: "+id+" | body: none");
        return new ResponseEntity<>(projectService.getById(id), HttpStatus.OK);
    }

    //update
    @PutMapping(value = "/{userId}/{id}", produces = { "application/json" },consumes = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = ProjectResponseBody.class),
    })
    public  ResponseEntity<ProjectResponseBody> updateProject(@RequestBody ProjectBodyPut project, @PathVariable Long id, @PathVariable Long userId) throws InvalidException, InvalidOrNullFieldException {
        logger.info("method: PUT | route: /project/{id} | parameters: "+id+" | body: "+ project);
        return new ResponseEntity<>(projectService.update(project, id, userId), HttpStatus.OK);
    }

    //closeProject
    @PutMapping(value = "/close/{userId}/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = ProjectResponseBody.class),
    })
    public  ResponseEntity<ProjectResponseBody> closeProject(@PathVariable Long id, @PathVariable Long userId) throws InvalidException, IOException {
        return new ResponseEntity<>(projectService.closeProject(id, userId), HttpStatus.OK);
    }

    //ADD_ONE
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = String.class),
    })
    @PostMapping(value = "/{userId}/", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<Integer> addProject(@PathVariable Long userId, @RequestBody ProjectBodyPost projectBody) throws InvalidOrNullFieldException, InvalidException {
        logger.info("method: POST | route: /project/ | parameters: none | body: "+ projectBody);
        return new ResponseEntity<>(projectService.save(projectBody, userId), HttpStatus.OK);
    }

    //DELETE_ONE
    @DeleteMapping(value = "/{userId}/{id}", produces = { "application/json" })
    public ResponseEntity<String> deleteProject(@PathVariable Integer userId, @PathVariable Integer id) throws InvalidException {
        projectService.delete(id, userId);
        logger.info("method: DELETE | route: /project/{id} | parameters: "+id+" | body: none");
        return new ResponseEntity<>("OK",HttpStatus.OK);
    }
}
