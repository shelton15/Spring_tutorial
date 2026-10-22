package com.shelton.example.student;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

class StudentMapperTest {

    private StudentMapper mapper;

    @BeforeEach
    void setUp() {
        mapper = new StudentMapper();
    }

    @Test
    public void shouldMapStudentDtoToStudent() {
        StudentDto dto = new StudentDto(
                "John",
                "Doe",
                "john@gmail.com",
                2
        );

        Student student = mapper.toStudent(dto);

        assertEquals(dto.firstName(), student.getFirstName());
        assertEquals(dto.lastName(), student.getLastName());
        assertEquals(dto.email(), student.getEmail());
        assertNotNull(student.getSchool());
        assertEquals(dto.schoolId(), student.getSchool().getId());
    }

    @Test
    public void should_throw_null_pointer_exception_when_studentDto_is_null() {

        var exp = assertThrows(NullPointerException.class, () -> mapper.toStudent(null));
        assertEquals("The student dto should not be null", exp.getMessage());
    }

    @Test
    public void shouldMapStudentToStudentResponseDto() {
        //given
        Student student = new Student(
                "Jane",
                "Doe",
                "jane@gmail.com",
                25
        );
//when
        StudentResponseDto response = mapper.toStudentResponseDto(student);

        //then
        assertEquals(response.firstName(), student.getFirstName());
        assertEquals(response.lastName(), student.getLastName());
        assertEquals(response.email(), student.getEmail());
//        assertNotNull(student.getSchool());
    }


}