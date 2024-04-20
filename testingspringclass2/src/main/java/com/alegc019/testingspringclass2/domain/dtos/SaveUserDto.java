package com.alegc019.testingspringclass2.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SaveUserDto {

    @NotEmpty(message = "Username must not be empty.")
    @Pattern(regexp = "^[a-z]{4,16}$" , message = "Username must be between 4 and 16 characters and can only contain lowercase letters.")
    private String username;

    @NotEmpty(message = "Password must not be empty.")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[!$#]).{8,32}$", message = "Password must be between 8 and 32 characters, contain at least one lowercase letter, one uppercase letter, and one of the special characters !, $, or #.")
    private String password;

    @NotEmpty(message = "Email must not be empty.")
    @Pattern(regexp = "^[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,4}$", message = "Email must contain only lowercase letters, digits, dots, underscores, percents, pluses, or hyphens. It must include an '@' character, followed by a domain name that contains only lowercase letters, digits, dots, or hyphens, and ends with a '.' followed by a 2 to 4 letter lowercase domain.")
    private String email;
}
