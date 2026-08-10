package org.example.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class UsersResponse {

    @JsonProperty("page")
    private String page;

    @JsonProperty("per_page")
    private String per_page;

    @JsonProperty("total")
    private String total;

    @JsonProperty("total_pages")
    private String total_pages;

    @JsonProperty("data")
    private List<UserResponse.UserData> data;
}
