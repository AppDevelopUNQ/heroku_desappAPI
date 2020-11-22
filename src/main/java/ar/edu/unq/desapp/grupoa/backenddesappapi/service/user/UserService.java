package ar.edu.unq.desapp.grupoa.backenddesappapi.service.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBodyUser;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserLogIn;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;

import java.util.ArrayList;
import java.util.List;

public interface UserService {
    List<UserResponseBodyList> listAllUsers();

    UserResponseBody getById(Integer id) throws InvalidException;

    void update(UserBodyPut body, Long id) throws InvalidException, MailValidation, InvalidOrNullFieldException;

    void delete(Integer id) throws InvalidException;

    int save(UserBodyPost user) throws MailValidation, InvalidOrNullFieldException;

    void donate(Integer id, DonationRequestBody body) throws InvalidException, InvalidOrNullFieldException;

    UserResponseBody logIn(UserLogIn body) throws InvalidOrNullFieldException, MailValidation, InvalidException, InvalidException;

    List<DonationResponseBodyUser> getDonationsOfUser(Integer id) throws InvalidException;
}
