package ar.edu.unq.desapp.grupoa.backenddesappapi.service.user;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody.DonationRequestBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPost;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserBodyPut;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody.UserLogIn;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody.UserResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.project.ProjectDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.punctuationsystem.PunctuationSystemDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.user.UserDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.dao.wallet.WalletDAO;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.InvalidOrNullFieldException;
import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.punctuationsystem.PunctuationSystem;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.Wallet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

@Service
public class UserServiceImp implements UserService {

    private @Autowired UserDAO userDAO;
    private @Autowired PunctuationSystemDAO systemDAO;
    private @Autowired WalletDAO walletDAO;
    private @Autowired ProjectDAO projectDAO;

    @Override
    public List<UserResponseBodyList> listAllUsers() {
        return ((List<User>) userDAO.findAll()).stream().map(UserResponseBodyList::new).collect(Collectors.toList());
    }

    @Override
    public UserResponseBody getById(Integer id) throws InvalidException {
        Long value = Long.valueOf(id);
        this.validateId(value);
        User userRecovered = userDAO.findById(value).orElse(new User());
        return new UserResponseBody(userRecovered);
    }

    @Override
    public void update(UserBodyPut body, Long id) throws InvalidException, MailValidation, InvalidOrNullFieldException {
        Long value = Long.valueOf(id);
        this.validateId(value);
        this.validateBodyPut(body);
        User recover = userDAO.findById(value).orElse(new User());
        recover.updateUser(body);
    }

    @Override
    public void delete(Integer id) throws InvalidException {
        Long value = Long.valueOf(id);
        this.validateId(value);
        userDAO.deleteById(value);
    }

    @Override
    public int save(UserBodyPost user) throws MailValidation, InvalidOrNullFieldException {
        this.validateName(user.getName());
        this.validateNickName(user.getNickname());
        this.validatePassword(user.getPassword());
        PunctuationSystem system = systemDAO.findAll().iterator().next();
        Wallet newWallet = walletDAO.save(new Wallet(0.0, system));
        User newUser = ((new User()).setUser(user));
        newUser.setWallet(newWallet);
        return userDAO.save(newUser).getId().intValue();
    }

    @Override
    public void donate(Integer id, DonationRequestBody body) throws InvalidException, InvalidOrNullFieldException {
        Long value = Long.valueOf(id);
        this.validateId(value);
        this.validateDonationRequest(body);
        User recoveredUser = userDAO.findById(value).orElse(new User());
        Project recoveredProject = projectDAO.findById(Long.valueOf(body.getProjectId())).orElse(new Project());
        recoveredUser.createDonation(body.getAmount(), recoveredProject);
        userDAO.save(recoveredUser);
        projectDAO.save(recoveredProject);
    }

    @Override
    public UserResponseBody logIn(UserLogIn body) throws InvalidOrNullFieldException, MailValidation, InvalidException {
        this.validateEmail(body.getEmail());
        this.validatePassword(body.getPassword());
        List<User> result = ((List<User>) userDAO.findAll()).stream().filter(user -> user.getEmail().equals(body.getEmail())).collect(Collectors.toList());
        this.validateResult(result, body.getPassword());
        User userRecovered = result.get(0);
        return new UserResponseBody(userRecovered);
    }

    private void validateResult(List<User> result, String password) throws InvalidException {
        if(result.isEmpty() || !result.get(0).getPassword().equals(password)){
            throw new InvalidException("email or password");
        }
    }

    private void validateDonationRequest(DonationRequestBody body) throws InvalidException, InvalidOrNullFieldException {
        this.validateProjectId(body.getProjectId());
        this.validateAmount(body.getAmount());
    }

    private void validateAmount(Double amount) throws InvalidOrNullFieldException {
        if (amount == null || (amount).intValue() <= 0){
            throw new InvalidOrNullFieldException("amount");
        }
    }

    private void validateProjectId(Integer projectId) throws InvalidException {
        Long value = Long.valueOf(projectId);
        if (!projectDAO.existsById(value)){
            throw new InvalidException("id: "+value);
        }
    }

    private void validateBodyPut(UserBodyPut body) throws InvalidOrNullFieldException {
        this.validateName(body.getName());
        this.validateNickName(body.getNickname());
        this.validatePassword(body.getPassword());
    }

    private void validatePassword(String password) throws InvalidOrNullFieldException {
        if (!StringUtils.hasText(password)){
            throw new InvalidOrNullFieldException("password");
        }
    }

    private void validateNickName(String nickname) throws InvalidOrNullFieldException {
        if (!StringUtils.hasText(nickname)){
            throw new InvalidOrNullFieldException("nickname");
        }
    }

    private void validateName(String name) throws InvalidOrNullFieldException {
        if (!StringUtils.hasText(name)){
            throw new InvalidOrNullFieldException("name");
        }
    }

    private void validateEmail(String email) throws MailValidation {
        Pattern VALID_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL.matcher(email);
        if(!matcher.find()) {
            throw new MailValidation();
        }
    }

    private void validateId(Long id) throws InvalidException {
        if (!userDAO.existsById(id)){
            throw new InvalidException("id: "+id);
        }
    }
}

