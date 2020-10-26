package ar.edu.unq.desapp.grupoa.backenddesappapi.controllers.donation.requestbody;

import io.swagger.annotations.ApiModelProperty;

public class DonationRequestBody {

    @ApiModelProperty(value = "id of the target project", required = true, example = "20")
    private Integer projectId;
    @ApiModelProperty(value = "amount donated to the project", required = true, example = "1000")
    private Double amount;

    public DonationRequestBody(){}

    public DonationRequestBody(Integer projectId, Double amount) {
        this.projectId = projectId;
        this.amount = amount;
    }


    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }
}
