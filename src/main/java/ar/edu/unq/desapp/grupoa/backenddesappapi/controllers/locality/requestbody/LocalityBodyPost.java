package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.locality.requestbody;

import ar.edu.unq.desapp.grupoa.backenddesappapi.model.proyect.Locality;
import io.swagger.annotations.ApiModelProperty;

public class LocalityBodyPost {
    @ApiModelProperty(value = "name of the Locality to add", required = true, example = "Berazategui")
    private String name;
    @ApiModelProperty(value = "name of the Province of the locality", required = true, example = "Buenos Aires")
    private String province;
    @ApiModelProperty(value = "amount of the population of the locality", required = true, example = "150000")
    private Integer population;
    @ApiModelProperty(value = "state of connection of the locality", required = true, example = "50.0")
    private Double stateOfConnection;

    public LocalityBodyPost(){}

    public LocalityBodyPost(String name, String province, Integer population, Double stateOfConnection) {
        this.name = name;
        this.province = province;
        this.population = population;
        this.stateOfConnection = stateOfConnection;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public Integer getPopulation() {
        return population;
    }

    public void setPopulation(Integer population) {
        this.population = population;
    }

    public Double getStateOfConnection() {
        return stateOfConnection;
    }

    public void setStateOfConnection(Double stateOfConnection) {
        this.stateOfConnection = stateOfConnection;
    }

    @ApiModelProperty(value = "", required = false, hidden = true)
    public Locality setValues(Locality locality) {
        locality.setName(this.name);
        locality.setProvince(this.province);
        locality.setPopulation(this.population);
        locality.setStateOfConnection(this.stateOfConnection);
        return locality;
    }
}
