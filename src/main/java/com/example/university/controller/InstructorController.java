package com.example.university.controller;

import com.example.university.model.Instructor;
import com.example.university.repository.InstructorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Instructors")
public class InstructorController {

    @Autowired
    private InstructorRepository InstructorRepository;

    @GetMapping
    public List<Instructor> getAllInstructors() {
        return InstructorRepository.findAll();
    }

    @GetMapping("/{id}")
    public Instructor getInstructorById(@PathVariable String id) {
        return InstructorRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Instructor createInstructor(@RequestBody Instructor Instructor) {
        return InstructorRepository.save(Instructor);
    }

    @PutMapping("/{id}")
    public Instructor updateInstructor(@PathVariable String id, @RequestBody Instructor InstructorDetails) {
        Optional<Instructor> optionalInstructor = InstructorRepository.findById(id);
        if (optionalInstructor.isPresent()) {
            Instructor Instructor = optionalInstructor.get();
            Instructor.setFirstName(InstructorDetails.getFirstName());
            Instructor.setLastName(InstructorDetails.getLastName());
            // Ustaw inne pola według potrzeb
            return InstructorRepository.save(Instructor);
        }
::contentReference[oaicite:0]{index=0}
 
