package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.project.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Project;
import io.swagger.annotations.ApiModelProperty;

import java.time.LocalDate;

public class ProjectBodyPut {
    @ApiModelProperty(value = "new name of the project", required = true,
            example = "Berazategui_56%->70%_2020")
    private String name;
    @ApiModelProperty(value = "new minimum closing percentage", required = true, example = "70.0")
    private Double minimumClosingPercentage;
    @ApiModelProperty(value = "new fantasy name of the project", required = true, example = "Bera_70%_2020")
    private String fantasyName;
    @ApiModelProperty(value = "new deadline of the project(format YYYY-MM-DD)", required = true, example = "2120-12-27")
    private LocalDate deadline;
    @ApiModelProperty(value = "new amount per person in the locality", required = true, example = "30000")
    private Double factor;

    public ProjectBodyPut(){}

    public ProjectBodyPut(String name, Double minimumClosingPercentage, String fantasyName, LocalDate deadline, Double factor) {
        this.name = name;
        this.minimumClosingPercentage = minimumClosingPercentage;
        this.fantasyName = fantasyName;
        this.deadline = deadline;
        this.factor = factor;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getMinimumClosingPercentage() {
        return minimumClosingPercentage;
    }

    public void setMinimumClosingPercentage(Double minimumClosingPercentage) {
        this.minimumClosingPercentage = minimumClosingPercentage;
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

    public Double getFactor() {
        return factor;
    }

    public void setFactor(Double factor) {
        this.factor = factor;
    }

    @ApiModelProperty(value = "", required = false, hidden = true)
    public void setValues(Project project) {
        project.setName(this.name);
        project.setFantasyName(this.fantasyName);
        project.setMinimumPercentage(this.minimumClosingPercentage);
        project.setDeadline(this.deadline);
        project.setFactor(this.factor);
    }
}
