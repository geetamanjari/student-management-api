package com.example.demo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "Firstname is Required")
    private String firstname;
    @NotBlank(message = "Lastname is Required")
    private String lastname;
    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is Required")
    private String email;
    private String phone;
    private String course;
    private String createdAt;
    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

}
