package in.om.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import in.om.utility.CommonUtils;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author Prakash Rathod
 */
@ApiModel(description = "Organization Data Transfer Object")
@Data
public class OrganizationDTO {
    @JsonProperty("name")
    @ApiModelProperty(notes = "name", example = "Onset Matrix")
    private String name;

    @Override
    public String toString() {
        return CommonUtils.objectToJsonString(this);
    }
}
