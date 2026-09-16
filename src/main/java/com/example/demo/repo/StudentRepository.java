package com.example.demo.repo;


import com.example.demo.Student;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository <Student, Long> {

    List<Student> findByFirstnameContaining(String firstname);

    List<Student> findByCourse(String course);

    Page<Student> findAll(Pageable pageable);
}
