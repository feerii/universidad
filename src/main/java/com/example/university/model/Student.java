package com.example.university.model;

import jakarta.persistence.*;
import java.util.List;

import lombok.Data;
@Entity
@Data
public class Student {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @ElementCollection
    private List<Integer> grades; // List of grades

    @ManyToMany
    @JoinTable(name = "student_subject",
               joinColumns = @JoinColumn(name = "student_id"),
               inverseJoinColumns = @JoinColumn(name = "subject_id"))
    private List<Subject> subjects;

    public void setId(String id) {
        this.id = id;
    }
    public void setfirstName(String firstName) {
        this.firstName = firstName;
    }
    public void setlastName(String lastName) {
        this.lastName = lastName;
    }
            
}
