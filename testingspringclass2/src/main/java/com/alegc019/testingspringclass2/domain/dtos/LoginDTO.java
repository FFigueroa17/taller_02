package com.alegc019.testingspringclass2.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LoginDTO {

    @NotEmpty
    private String identifier;

    @NotEmpty
    private String password;
}
