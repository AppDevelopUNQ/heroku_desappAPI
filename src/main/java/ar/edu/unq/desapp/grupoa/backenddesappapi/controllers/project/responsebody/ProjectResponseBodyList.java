package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;

import java.time.LocalDate;

public class ProjectResponseBodyList {

    private Long id;
    private String name;
    private String fantasyName;
    private LocalDate deadline;
    private Boolean coverTheMinimumPercentage;
    private Double missingAmount;
    private Double missingPercentage;
    private Boolean open;

    public ProjectResponseBodyList(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.fantasyName = project.getFantasyName();
        this.deadline = project.getDeadline();
        this.coverTheMinimumPercentage = project.isCoverTheMinimumPercentage();
        this.missingAmount = project.missingAmount();
        this.missingPercentage = project.missingPercentage();
        this.open = project.isOpen();
    }

    public ProjectResponseBodyList() {

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

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public Boolean getCoverTheMinimumPercentage() {
        return coverTheMinimumPercentage;
    }

    public void setCoverTheMinimumPercentage(Boolean coverTheMinimumPercentage) {
        this.coverTheMinimumPercentage = coverTheMinimumPercentage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getMissingPercentage() {
        return missingPercentage;
    }

    public void setMissingPercentage(Double missingPercentage) {
        this.missingPercentage = missingPercentage;
    }

    public Double getMissingAmount() {
        return missingAmount;
    }

    public void setMissingAmount(Double missingAmount) {
        this.missingAmount = missingAmount;
    }

    public Boolean getOpen() {
        return open;
    }

    public void setOpen(Boolean open) {
        this.open = open;
    }
}
