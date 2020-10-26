package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class ProjectBodyPost {
    @ApiModelProperty(value = "name of the project", required = true, example = "Berazategui_56%->60%_2020")
    private String name;
    @ApiModelProperty(value = "minimum closing percentage of the project", required = true, example = "60.0")
    private Double minimumClosingPercentage;
    @ApiModelProperty(value = "the fantasy name of the project", required = true, example = "Bera_2020_60%")
    private String fantasyName;
    @ApiModelProperty(value = "date when starts(format YYYY-MM-DD)", required = true, example = "2020-12-27")
    private LocalDate startDate;
    @ApiModelProperty(value = "date when ends(format YYYY-MM-DD)", required = true, example = "2022-12-27")
    private LocalDate deadline;
    @ApiModelProperty(value = "amount for person in the locality", example = "1000")
    private Double factor;
    @ApiModelProperty(value = "the locality id", required = true,example = "3")
    private Long localityId;

    public ProjectBodyPost(){}

    public ProjectBodyPost(String name, Double minimumClosingPercentage, String fantasyName, LocalDate startDate, LocalDate deadline, Double factor, Long localityId) {
        this.name = name;
        this.minimumClosingPercentage = minimumClosingPercentage;
        this.fantasyName = fantasyName;
        this.startDate = startDate;
        this.deadline = deadline;
        this.factor = factor;
        this.localityId = localityId;
    }

    public Long getLocalityId() {
        return localityId;
    }

    public void setLocalityId(Long localityId) {
        this.localityId = localityId;
    }

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public String getFantasyName() {
        return fantasyName;
    }

    public void setFantasyName(String fantasyName) {
        this.fantasyName = fantasyName;
    }

    public Double getMinimumClosingPercentage() {
        return minimumClosingPercentage;
    }

    public void setMinimumClosingPercentage(Double minimumClosingPercentage) {
        this.minimumClosingPercentage = minimumClosingPercentage;
    }

    @ApiModelProperty(value = "", required = false, hidden = true)
    public Project setValues(Project project) {
        project.setName(this.name);
        project.setMinimumPercentage(this.minimumClosingPercentage);
        project.setFantasyName(this.fantasyName);
        project.setStartDate(this.startDate);
        project.setDeadline(this.deadline);
        project.setFactor(this.factor);
        return project;
    }
}