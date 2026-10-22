package com.shelton.example;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;
    private final StudentMapper studentMapper;

    public StudentService(StudentRepository repository, StudentMapper studentMapper) {
        this.repository = repository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(StudentDto dto) {

        var  student = studentMapper.toStudent(dto);
        var savedStudent = repository.save(student);

        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<Student> findAllStudent() {
        return repository.findAll();
    }

    public Student findStudentById(Integer id) {
        return repository.findById(id).orElse(new Student());
    }

    public List<Student> findStudentByName(String name) {
        return repository.findAllByFirstNameContaining(name);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
