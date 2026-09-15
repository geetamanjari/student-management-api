package com.example.demo.controller;

import com.example.demo.Student;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    @Autowired
    private StudentService studentService;
    @PostMapping
    public ResponseEntity<Student> createStudent(
            @RequestBody Student student){
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(studentService.createstudent(student));
    }
    @GetMapping
    public List<Student> getAllStudents(){
        return studentService.getAllStudents();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(
            @PathVariable Long id){
        return ResponseEntity.ok(studentService.getStudentById(id));
    }
    @PutMapping("/{id}")
    public Student updateStudent(
            @PathVariable Long id,
            @RequestBody Student student) {
        return studentService.updateStudent(id, student);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(
            @PathVariable Long id) {
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build();
    }
    @GetMapping("/search")
    public List<Student> searchStudents(
            @RequestParam String name){
        return studentService.searchByName(name);
    }
    @GetMapping("/filter")
    public List<Student> filterByCourse(
            @RequestParam String course){
        return studentService.filterByCourse(course);
    }


}
