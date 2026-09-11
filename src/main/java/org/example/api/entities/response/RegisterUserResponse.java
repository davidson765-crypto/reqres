package org.example.api.entities.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class RegisterUserResponse {

    @JsonProperty("id")
    private String id;

    @JsonProperty("token")
    private String token;
}
