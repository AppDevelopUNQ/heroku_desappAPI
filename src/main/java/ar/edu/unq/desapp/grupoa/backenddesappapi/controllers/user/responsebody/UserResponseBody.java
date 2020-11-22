package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.user.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBodyUser;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.user.User;

import java.util.List;
import java.util.stream.Collectors;


public class UserResponseBody {
    private Long userId;
    private String name;
    private String nickname;
    private String email;
    private String password;
    private List<DonationResponseBodyUser> donations;
    private Double points;
    private Boolean isAdmin;

    public UserResponseBody(){}

    public UserResponseBody(User user) {
        this.userId = user.getId();
        this.name = user.getName();
        this.nickname = user.getNickname();
        this.email = user.getEmail();
        this.password = user.getPassword();
        this.donations = this.mapDonations(user.getDonations());
        this.points = user.getWallet().getPoints();
        this.isAdmin = user.getIsAdmin();
    }

    public List<DonationResponseBodyUser> mapDonations(List<Donation> donations) {
        return donations.stream().map(DonationResponseBodyUser::new).collect(Collectors.toList());
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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

    public List<DonationResponseBodyUser> getDonations() {
        return donations;
    }

    public void setDonations(List<DonationResponseBodyUser> donations) {
        this.donations = donations;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }

    public Boolean getAdmin() {
        return isAdmin;
    }

    public void setAdmin(Boolean admin) {
        isAdmin = admin;
    }
}
