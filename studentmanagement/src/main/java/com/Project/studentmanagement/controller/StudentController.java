package com.Project.studentmanagement.controller;

import com.Project.studentmanagement.common.ApiResponse;
import com.Project.studentmanagement.dto.StudentRequestDTO;
import com.Project.studentmanagement.dto.StudentResponseDTO;
import com.Project.studentmanagement.entity.Student;
import com.Project.studentmanagement.service.StudentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/students")

public class StudentController {

private final StudentService service;

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponseDTO>> createStudent(
            @Valid @RequestBody StudentRequestDTO dto) {

        StudentResponseDTO saved = service.createStudent(dto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new ApiResponse<>(
                        "SUCCESS",
                        201,
                        "Student created successfully",
                        saved,
                        LocalDateTime.now()
                ));
    }
//    @GetMapping
//    public List<StudentResponseDTO> getAllStudents() {
//        return service.getAllStudents();
//    }
@GetMapping //get all student with page and proper msg
public ResponseEntity<ApiResponse<Page<StudentResponseDTO>>> getAllStudents(
        @RequestParam(defaultValue = "0") int page,
        @RequestParam(defaultValue = "5") int size) {

    Page<StudentResponseDTO> students = service.getAllStudents(page, size); //page

    return ResponseEntity.ok(
            ApiResponse.<Page<StudentResponseDTO>>builder()
                    .status("SUCCESS")
                    .statusCode(200)
                    .message("Students fetched successfully")
                    .data(students)
                    .timestamp(LocalDateTime.now())
                    .build()
    );
}

    @GetMapping("/{id}") //get by id
    public ResponseEntity<ApiResponse<StudentResponseDTO>> getStudentById(
            @PathVariable Long id) {

        StudentResponseDTO student = service.getStudentById(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "SUCCESS",
                        200,
                        "Student fetched successfully",
                        student,
                        LocalDateTime.now()
                ));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<String>> deleteStudent(
            @PathVariable Long id) {

        service.deleteStudent(id);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "SUCCESS",
                        200,
                        "Student deleted successfully",
                        null,
                        LocalDateTime.now()
                ));
    }
    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponseDTO>> updateStudent(
            @PathVariable Long id,
            @Valid @RequestBody StudentRequestDTO dto) {

        StudentResponseDTO updated = service.updateStudent(id, dto);

        return ResponseEntity.ok(
                new ApiResponse<>(
                        "SUCCESS",
                        200,
                        "Student updated successfully",
                        updated,
                        LocalDateTime.now()
                ));
    }

}
