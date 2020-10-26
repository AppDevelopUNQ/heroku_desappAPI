package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserLogIn;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidIdException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidLogInException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.user.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    private @Autowired UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //get_ALL
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = UserResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listUsers() {
        return new ResponseEntity<> (userService.listAllUsers(), HttpStatus.OK);
    }

    //get_ONE
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = UserResponseBody.class),
    })
    public ResponseEntity<UserResponseBody> getUser(@PathVariable Integer id) throws InvalidIdException {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    //logIn
    @PutMapping(value = "/login", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<UserResponseBody> logIn(@RequestBody UserLogIn body) throws MailValidation, InvalidOrNullFieldException, InvalidLogInException {
        return new ResponseEntity<>(userService.logIn(body),HttpStatus.OK);
    }

    //update exception for id and body
    @PutMapping(value = "/{id}", produces = { "application/json" },consumes = { "application/json" })
    public  ResponseEntity updateUser(@RequestBody UserBodyPut user, @PathVariable Long id) throws MailValidation, InvalidIdException, InvalidOrNullFieldException {
        userService.update(user, id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    //ADD_ONE exception for body
    @PostMapping(value = "/register", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<Integer> save(@RequestBody UserBodyPost user) throws MailValidation, InvalidOrNullFieldException {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    //DELETE_ONE exception for id
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<String> deleteUser(@PathVariable Integer id) throws InvalidIdException {
        userService.delete(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    //DONATE exception for id and body
    @PostMapping(value = "/{id}/donate", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<String> donate(@PathVariable Integer id, @RequestBody DonationRequestBody body) throws InvalidIdException, InvalidOrNullFieldException {
        userService.donate(id, body);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
