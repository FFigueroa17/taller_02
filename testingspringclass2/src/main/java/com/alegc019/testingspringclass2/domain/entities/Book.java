package com.alegc019.testingspringclass2.domain.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Book{

    private String ISBN;
    private String title;

}
