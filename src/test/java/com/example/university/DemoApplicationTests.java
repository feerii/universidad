package com.example.university.service;

import com.example.university.model.Student;
import com.example.university.repository.StudentRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import java.util.List;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StudentServiceTest {

    private final StudentRepository repository = Mockito.mock(StudentRepository.class);
    private final StudentService service = new StudentService(repository);

    @Test
    void shouldReturnAllStudents() {
        Mockito.when(repository.findAll()).thenReturn(List.of(new Student("1", "John", "Doe", null)));
        List<Student> students = service.findAll();
        assertEquals(1, students.size());
    }
}
