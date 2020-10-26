package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody;

import io.swagger.annotations.ApiModelProperty;

public class UserLogIn {
    @ApiModelProperty(value = "name of the user", required = true, example = "a@email.com")
    private String email;
    @ApiModelProperty(value = "name of the user", required = true, example = "password")
    private String password;

    public UserLogIn(String email, String password){
        this.email = email;
        this.password = password;
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
}
