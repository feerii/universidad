package com.example.university.service;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

    public Student findById(String id) {
        return studentRepository.findById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteById(String id) {
        studentRepository.deleteById(id);
    }
}
