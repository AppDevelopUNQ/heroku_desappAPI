package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

public class UserResponseBodyList {

    private Long id;
    private String name;
    private String nickname;
    private String email;

    public UserResponseBodyList(User user) {
        this.id = user.getId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
