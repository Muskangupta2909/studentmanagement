package com.Project.studentmanagement.service;

import com.Project.studentmanagement.dto.StudentRequestDTO;
import com.Project.studentmanagement.dto.StudentResponseDTO;
import org.springframework.data.domain.Page;

import java.util.List;

public interface StudentService { //only for method declaration
    StudentResponseDTO createStudent(StudentRequestDTO dto);
    //Create and save new student in db
    List<StudentResponseDTO> getAllStudents();//fetch student
    StudentResponseDTO getStudentById(Long id);
    void deleteStudent(Long id);

    StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto);

    Page<StudentResponseDTO> getAllStudents(int page, int size); //Pagination
}

