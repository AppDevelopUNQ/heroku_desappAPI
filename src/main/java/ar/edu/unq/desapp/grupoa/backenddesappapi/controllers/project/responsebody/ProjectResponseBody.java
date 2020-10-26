package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.responsebody.DonationResponseBody;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Donation;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

public class ProjectResponseBody {

    private Long id;
    private String name;
    private String fantasyName;
    private LocalDate startDate;
    private LocalDate deadline;
    private Double factor;
    private Locality locality;
    private List<DonationResponseBody> donations;
    private Double minimumPercentage;
    private Boolean coverTheMinimumPercentage;

    public ProjectResponseBody(Project recoverProject) {
        this.id = recoverProject.getId();
        this.name = recoverProject.getName();
        this.fantasyName = recoverProject.getFantasyName();
        this.startDate = recoverProject.getStartDate();
        this.deadline = recoverProject.getDeadline();
        this.factor = recoverProject.getFactor();
        this.locality = recoverProject.getLocality();
        this.donations = this.mapDonations(recoverProject.getDonations());
        this.minimumPercentage = recoverProject.getMinimumPercentage();
        this.coverTheMinimumPercentage = recoverProject.isCoverTheMinimumPercentage();
    }

    public ProjectResponseBody() {

    }

    private List<DonationResponseBody> mapDonations(List<Donation> donations) {
        return donations.stream().map(DonationResponseBody::new).collect(Collectors.toList());
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

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public Locality getLocality() {
        return locality;
    }

    public void setLocality(Locality locality) {
        this.locality = locality;
    }

    public List<DonationResponseBody> getDonations() {
        return donations;
    }

    public void setDonations(List<DonationResponseBody> donations) {
        this.donations = donations;
    }

    public Double getMinimumPercentage() {
        return minimumPercentage;
    }

    public void setMinimumPercentage(Double minimumPercentage) {
        this.minimumPercentage = minimumPercentage;
    }

    public Boolean getCoverTheMinimumPercentage() {
        return coverTheMinimumPercentage;
    }

    public void setCoverTheMinimumPercentage(Boolean coverTheMinimumPercentage) {
        this.coverTheMinimumPercentage = coverTheMinimumPercentage;
    }
}
