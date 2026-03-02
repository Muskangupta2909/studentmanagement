package com.Project.studentmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StudentResponseDTO {

    private Long id;
    private String name;
    private String email;
    private String course;
}
