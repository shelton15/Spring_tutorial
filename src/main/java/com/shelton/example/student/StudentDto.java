package com.shelton.example.student;

import jakarta.validation.constraints.NotEmpty;

public record StudentDto(

        @NotEmpty(message = "firstname should not be empty")
        String firstName,
        @NotEmpty(message = "lastname should not be empty")
        String lastName,
        String email,
        Integer schoolId
) {

}
