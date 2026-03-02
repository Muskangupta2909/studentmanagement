package com.Project.studentmanagement.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data

public class StudentRequestDTO {
    @NotBlank(message = "Name is required")
    @Pattern(
            regexp = "^[a-zA-Z ]{3,50}$",
            message = "Name must be between 3 and 50 characters"
    )
    private String name;

    @NotBlank(message = "Email is required")
    @Pattern(
            regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$",
            message = "Invalid email format"
    )
    private String email;

    @NotBlank(message = "Course is required")
    private String course;
}
