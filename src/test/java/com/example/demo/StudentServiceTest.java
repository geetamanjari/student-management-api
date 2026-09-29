package com.example.demo;

import com.example.demo.repo.StudentRepository;
import com.example.demo.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentServiceTest {

    @Mock
    private StudentRepository studentRepository;

    @InjectMocks
    private StudentService studentService;

    @Test
    void testGetAllStudents() {

        Student s1 = new Student();
        s1.setFirstname("Geeta");
        s1.setLastname("Manjari");

        Student s2 = new Student();
        s2.setFirstname("John");
        s2.setLastname("Doe");

        Pageable pageable = PageRequest.of(0, 10);

        Page<Student> page =
                new PageImpl<>(Arrays.asList(s1, s2));

        when(studentRepository.findAll(pageable))
                .thenReturn(page);

        Page<Student> result =
                studentService.getAllStudents(pageable);

        assertEquals(2, result.getContent().size());

        verify(studentRepository, times(1))
                .findAll(pageable);
    }
}