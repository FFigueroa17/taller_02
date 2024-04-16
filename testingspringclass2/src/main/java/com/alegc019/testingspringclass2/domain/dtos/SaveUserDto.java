package com.alegc019.testingspringclass2.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SaveUserDto {
    @NotEmpty
    @Pattern(regexp = "^[a-z]{4,16}$")
    private String username;
    @NotEmpty
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!$#]).{8,32}$")
    private String password;
    @NotEmpty
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$")
    private String email;


}
