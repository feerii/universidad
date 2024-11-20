package com.example.university.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Subject {

    @Id
    private String id;
    private String name;

    @ManyToMany(mappedBy = "subjects")
    private List<Student> students;

    @ManyToMany
    @JoinTable(name = "subject_instructor",
               joinColumns = @JoinColumn(name = "subject_id"),
               inverseJoinColumns = @JoinColumn(name = "instructor_id"))
    private List<Instructor> instructors;

    // Getters and Setters
}
