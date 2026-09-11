package org.example.api.entities.response;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LoginUserResponse {

    @JsonProperty("token")
    private String token;
}
