package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.responsebody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;

import java.time.LocalDate;

public class ProjectResponseBodyList {

    private Long id;
    private String name;
    private String fantasyName;
    private LocalDate deadline;
    private Boolean coverTheMinimumPercentage;

    public ProjectResponseBodyList(Project project) {
        this.id = project.getId();
        this.name = project.getName();
        this.fantasyName = project.getFantasyName();
        this.deadline = project.getDeadline();
        this.coverTheMinimumPercentage = project.isCoverTheMinimumPercentage();
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
}
