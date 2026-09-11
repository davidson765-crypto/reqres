package org.example.api.entities.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterLoginRequestBody {

    private String email;
    private String password;
}
