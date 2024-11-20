package com.example.university.controller;

import com.example.university.model.Subject;
import com.example.university.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/subjects")
public class SubjectController {

    @Autowired
    private SubjectRepository subjectRepository;

    @GetMapping
    public List<Subject> getAllSubjects() {
        return subjectRepository.findAll();
    }

    @GetMapping("/{id}")
    public Subject getSubjectById(@PathVariable String id) {
        return subjectRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Subject createSubject(@RequestBody Subject subject) {
        return subjectRepository.save(subject);
    }

    @PutMapping("/{id}")
    public Subject updateSubject(@PathVariable String id, @RequestBody Subject subjectDetails) {
        Optional<Subject> optionalSubject = subjectRepository.findById(id);
        if (optionalSubject.isPresent()) {
            Subject subject = optionalSubject.get();
            subject.setName(subjectDetails.getName());
            // Ustaw inne pola według potrzeb
            return subjectRepository.save(subject);
        } else {
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteSubject(@PathVariable String id) {
        subjectRepository.deleteById(id);
    }
}
