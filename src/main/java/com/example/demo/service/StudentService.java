package com.example.demo.service;

import com.example.demo.Student;
import com.example.demo.exception.StudentNotFoundException;
import com.example.demo.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student createstudent(Student student){
        if (student.getFirstname() == null ||
                student.getFirstname().isBlank()) {
            throw new IllegalArgumentException(
                    "Firstname is required");
        }
        if (student.getLastname() == null ||
                student.getLastname().isBlank()) {
            throw new IllegalArgumentException(
                    "Lastname is required");
        }
        if (student.getEmail() == null ||
                student.getEmail().isBlank()) {
            throw new IllegalArgumentException(
                    "Email is required");
        }
        student.setCreatedAt(String.valueOf(LocalDateTime.now()));
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        return studentRepository.findAll();
    }

    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() ->
                new StudentNotFoundException(id));
    }

    public Student updateStudent(Long id,Student student){
        Student existing = getStudentById(id);
        existing.setFirstname(student.getFirstname());
        existing.setLastname(student.getLastname());
        existing.setEmail(student.getEmail());
        existing.setPhone(student.getPhone());
        existing.setCourse(student.getCourse());
        return studentRepository.save(existing);
    }

    public void deleteStudent(Long id){
        studentRepository.deleteById(id);
    }
}
