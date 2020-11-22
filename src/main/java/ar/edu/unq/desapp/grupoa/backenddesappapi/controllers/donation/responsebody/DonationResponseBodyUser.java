package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody.ProjectResponseBodyList;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;

import java.time.LocalDate;

public class DonationResponseBodyUser {
    private Long id;
    private Double amount;
    private ProjectResponseBodyList project;
    private LocalDate date;
    private Double points;

    public DonationResponseBodyUser(Donation donation) {
        this.id = donation.getId();
        this.amount = donation.getAmount();
        this.date = donation.getDate();
        this.project = new ProjectResponseBodyList(donation.getProject());
        this.points = donation.getPoints();
    }

    public DonationResponseBodyUser() { }

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

    public ProjectResponseBodyList getProject() {
        return project;
    }

    public void setProject(ProjectResponseBodyList project) {
        this.project = project;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getPoints() {
        return points;
    }

    public void setPoints(Double points) {
        this.points = points;
    }
}

