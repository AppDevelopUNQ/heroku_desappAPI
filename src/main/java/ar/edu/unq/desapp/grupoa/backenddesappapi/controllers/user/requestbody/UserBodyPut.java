package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.exception.MailValidation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;
import io.swagger.annotations.ApiModelProperty;

public class UserBodyPut {
    @ApiModelProperty(value = "new name of the user", required = true, example = "Lady")
    private String name;
    @ApiModelProperty(value = "new nickname of the user", required = true, example = "CannonAnn")
    private String nickname;
    @ApiModelProperty(value = "email of the user", required = true, example = "Lady@gmail.com")
    private String email;
    @ApiModelProperty(value = "password of the user", required = true, example = "$181Dollars")
    private String password;

    public UserBodyPut(){}

    public UserBodyPut(String name, String nickname, String email, String password) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ApiModelProperty(value = "", required = false, hidden = true)
    public void setValues(User user) throws MailValidation {
        user.setName(this.name);
        user.setNickname(this.nickname);
        user.setEmail(this.email);
        user.setPassword(this.password);
    }
}
