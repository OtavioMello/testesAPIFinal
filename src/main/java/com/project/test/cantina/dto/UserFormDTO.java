package com.project.test.cantina.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserFormDTO {

    private String name;
    private String email;
    private String password;

}
