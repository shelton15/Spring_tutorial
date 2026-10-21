package com.shelton.example;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class School {

    @Id
    @GeneratedValue()
    private Integer id;

    private String name;

    @OneToMany(
            mappedBy = "school"
    )
    private List<Student> students;


    public School() {
    }

    public School(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }
}
