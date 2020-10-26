package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;

import java.time.LocalDate;

public class DonationResponseBody {

    private Long id;
    private Double amount;
    private LocalDate date;
    private String userNickname;

    public DonationResponseBody(){}

    public DonationResponseBody(Donation donation) {
        this.id = donation.getId();
        this.amount = donation.getAmount();
        this.date = donation.getDate();
        this.userNickname = donation.getNickname();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getUserNickname() {
        return userNickname;
    }

    public void setUserNickname(String userNickname) {
        this.userNickname = userNickname;
    }
}
