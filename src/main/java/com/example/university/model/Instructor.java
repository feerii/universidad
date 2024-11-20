package com.example.university.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Instructor {

    @Id
    private String id;
    private String firstName;
    private String lastName;

    @ManyToMany(mappedBy = "instructors")
    private List<Subject> subjects;

    // Getters and Setters
}
