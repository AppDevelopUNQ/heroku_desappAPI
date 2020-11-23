package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.requestbody;

public class UserAuth {
    private String email;
    private Boolean email_verified;
    private String family_name;
    private String given_name;
    private String locale;
    private String name;
    private String nickname;
    private String picture;
    private String sub;
    private String updated_at;

    public UserAuth(){}

    public UserAuth(String email, Boolean email_verified, String family_name, String given_name, String locale,
     String name, String nickname, String picture,  String sub,  String updated_at){
        this.email = email;
        this.email_verified = email_verified;
        this.family_name = family_name;
        this.given_name = given_name;
        this.locale = locale;
        this.name = name;
        this.nickname = nickname;
        this.picture = picture;
        this.sub = sub;
        this.updated_at = updated_at;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getEmail_verified() {
        return email_verified;
    }

    public void setEmail_verified(Boolean email_verified) {
        this.email_verified = email_verified;
    }

    public String getFamily_name() {
        return family_name;
    }

    public void setFamily_name(String family_name) {
        this.family_name = family_name;
    }

    public String getGiven_name() {
        return given_name;
    }

    public void setGiven_name(String given_name) {
        this.given_name = given_name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }

    public String getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(String updated_at) {
        this.updated_at = updated_at;
    }
}
