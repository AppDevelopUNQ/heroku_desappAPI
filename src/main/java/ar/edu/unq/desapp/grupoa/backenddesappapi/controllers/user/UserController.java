package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBodyUser;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserAuth;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserLogIn;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.service.user.UserService;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    @CrossOrigin
    @GetMapping(value = "/list", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of all users",response = UserResponseBodyList.class, responseContainer = "List"),
    })
    public ResponseEntity<List> listUsers() {
        return new ResponseEntity<> (userService.listAllUsers(), HttpStatus.OK);
    }

    //get_ONE
    @CrossOrigin
    @GetMapping(value = "/{id}", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = UserResponseBody.class),
    })
    public ResponseEntity<UserResponseBody> getUser(@PathVariable(value = "id") Integer id) throws InvalidException {
        return new ResponseEntity<>(userService.getById(id), HttpStatus.OK);
    }

    //get_donations
    @CrossOrigin
    @GetMapping(value = "/{id}/donations", produces = { "application/json" })
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Successful retrieval of a user",response = ArrayList.class),
    })
    public ResponseEntity<List<DonationResponseBodyUser>> getUserDonations(@PathVariable(value = "id") Integer id) throws InvalidException {
        return new ResponseEntity<>(userService.getDonationsOfUser(id), HttpStatus.OK);
    }

    //logIn
    @CrossOrigin
    @PostMapping(value = "/login", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<UserResponseBody> logIn(@RequestBody UserLogIn body) throws MailValidation, InvalidOrNullFieldException, InvalidException {
        return new ResponseEntity<>(userService.logIn(body),HttpStatus.OK);
    }

    //update exception for id and body
    @CrossOrigin
    @PutMapping(value = "/{id}", produces = { "application/json" },consumes = { "application/json" })
    public  ResponseEntity updateUser(@RequestBody UserBodyPut user, @PathVariable(value = "id") Long id) throws MailValidation, InvalidException, InvalidOrNullFieldException {
        userService.update(user, id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    //ADD_ONE exception for body
    @CrossOrigin
    @PostMapping(value = "/register", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<Integer> save(@RequestBody UserBodyPost user) throws MailValidation, InvalidOrNullFieldException {
        return new ResponseEntity<>(userService.save(user), HttpStatus.OK);
    }

    @CrossOrigin
    @PostMapping(value = "/auth", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<UserResponseBody> saveAuth(@RequestBody UserAuth user) throws MailValidation, InvalidOrNullFieldException {
        return new ResponseEntity<>(userService.saveUpdate(user), HttpStatus.OK);
    }

    //DELETE_ONE exception for id
    @CrossOrigin
    @DeleteMapping(value = "/{id}", produces = { "application/json" })
    public ResponseEntity<String> deleteUser(@PathVariable(value = "id") Integer id) throws InvalidException {
        userService.delete(id);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }

    //DONATE exception for id and body
    @CrossOrigin
    @PostMapping(value = "/{id}/donate", produces = { "application/json" },consumes = { "application/json" })
    public ResponseEntity<String> donate(@PathVariable(value = "id") Integer id, @RequestBody DonationRequestBody body) throws InvalidException, InvalidOrNullFieldException {
        userService.donate(id, body);
        return new ResponseEntity<>("OK", HttpStatus.OK);
    }
}
