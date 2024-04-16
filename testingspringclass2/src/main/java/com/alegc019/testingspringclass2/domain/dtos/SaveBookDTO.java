package com.alegc019.testingspringclass2.domain.dtos;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class SaveBookDTO {
    @NotEmpty
    @Pattern(regexp = "^\\d{9}-\\d$")
    private String ISBN;
    @NotEmpty
    private String title;
}
