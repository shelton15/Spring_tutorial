package com.shelton.example.student;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class StudentServiceTest {

    //service we want to start
    @InjectMocks
    private StudentService studentService;

    //declare the dependencies
    @Mock
    private StudentRepository repository;

    @Mock
    private StudentMapper studentMapper;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void should_successfully_save_a_student() {
        //Given
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "john@gmail.com",
                2
        );
        Student student = new Student(
                "John",
                "Doe",
                "john@gmail.com",
                2
        );
        Student savedStudent = new Student(
                "John",
                "Doe",
                "john@gmail.com",
                2
        );
        savedStudent.setId(1);

        //Mock the calls
        when(studentMapper.toStudent(dto))
                .thenReturn(student);

        when(repository.save(student))
                .thenReturn(savedStudent);

        when(studentMapper.toStudentResponseDto(savedStudent))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@gmail.com"
                ));

        //When
        StudentResponseDto responseDto = studentService.saveStudent(dto);

        //Then
        assertEquals(dto.firstName(), responseDto.firstName());
        assertEquals(dto.lastName(), responseDto.lastName());
        assertEquals(dto.email(), responseDto.email());

        verify(studentMapper, times(1))
                .toStudent(dto);
        verify(repository, times(1))
                .save(student);
        verify(studentMapper, times(1))
                .toStudentResponseDto(savedStudent);
    }

    @Test
    public void should_return_all_student() {

        //Given
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "John",
                "Doe",
                "john@gmail.com",
                2
        ));

        //Mock calls
        when(repository.findAll()).thenReturn(students);

        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@gmail.com"
                ));

        List<StudentResponseDto> responseDtos = studentService.findAllStudent();

        //Then
        assertEquals(students.size(), responseDtos.size());
        verify(repository, times(1)).findAll();
    }

    @Test
    public void should_return_student_by_id() {

        //Given
        Integer studentId = 1;
        Student student = new Student(
                "John",
                "Doe",
                "john@gmail.com",
                2
        );

        //Mock the call
        when(repository.findById(studentId))
                .thenReturn(Optional.of(student));
        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@gmail.com"
                ));

        //when
        StudentResponseDto dto = studentService.findStudentById(studentId);

        //Then
        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());

        verify(repository, times(1)).findById(studentId);
    }

    @Test
    public void should_find_student_by_name() {
        //Given
        String studentName = "John";
        List<Student> students = new ArrayList<>();
        students.add(new Student(
                "John",
                "Doe",
                "john@gmail.com",
                2
        ));

        //Mock calls
        when(repository.findAllByFirstNameContaining(studentName))
                .thenReturn(students);

        when(studentMapper.toStudentResponseDto(any(Student.class)))
                .thenReturn(new StudentResponseDto(
                        "John",
                        "Doe",
                        "john@gmail.com"
                ));

        //When
        var responseDto = studentService.findStudentByName(studentName);

        //Then
        assertEquals(students.size(), responseDto.size());
        verify(repository, times(1))
                .findAllByFirstNameContaining(studentName);

    }

    @Test
    public void delete() {
        //Given
        Integer studentId = 1;


    }
}