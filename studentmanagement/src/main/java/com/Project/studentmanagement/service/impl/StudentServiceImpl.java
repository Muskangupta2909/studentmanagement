package com.Project.studentmanagement.service.impl;

import com.Project.studentmanagement.dto.StudentRequestDTO;
import com.Project.studentmanagement.dto.StudentResponseDTO;
import com.Project.studentmanagement.Repository.StudentRepository;
import com.Project.studentmanagement.entity.Student;
import com.Project.studentmanagement.exception.ResourceNotFoundException;
import com.Project.studentmanagement.service.StudentService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
//actual bussiness logic and implements interface
public class StudentServiceImpl implements StudentService {

    private final StudentRepository repository; //repo inject

    @Override
    public StudentResponseDTO createStudent(StudentRequestDTO dto) { //create new data

        // DTO → Entity conversion
        Student student = new Student();
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        Student saved = repository.save(student);

        // Entity → ResponseDTO conversion
        return new StudentResponseDTO(
                saved.getId(),
                saved.getName(),
                saved.getEmail(),
                saved.getCourse()
        );
    }

    @Override
    public List<StudentResponseDTO> getAllStudents() {

        return repository.findAll()
                .stream()
                .map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getCourse()
                ))
                .collect(Collectors.toList());
    }
    @Override
    public StudentResponseDTO getStudentById(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));

        return new StudentResponseDTO(
                student.getId(),
                student.getName(),
                student.getEmail(),
                student.getCourse()
        );
    }
    @Override
    public void deleteStudent(Long id) {

        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));

        repository.delete(student);
    }
    @Override
    public StudentResponseDTO updateStudent(Long id, StudentRequestDTO dto) {

        // Check if student exist
        Student student = repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Student not found with id: " + id));

        // Update
        student.setName(dto.getName());
        student.setEmail(dto.getEmail());
        student.setCourse(dto.getCourse());

        // Save updated
        Student updatedStudent = repository.save(student);

        // Return DTO
        return new StudentResponseDTO(
                updatedStudent.getId(),
                updatedStudent.getName(),
                updatedStudent.getEmail(),
                updatedStudent.getCourse()
        );
    }
    @Override //Pagination
    public Page<StudentResponseDTO> getAllStudents(int page, int size) {

        Page<Student> studentPage = repository.findAll(PageRequest.of(page, size));

        return studentPage.map(student -> new StudentResponseDTO(
                        student.getId(),
                        student.getName(),
                        student.getEmail(),
                        student.getCourse()
                )
        );
    }
}
