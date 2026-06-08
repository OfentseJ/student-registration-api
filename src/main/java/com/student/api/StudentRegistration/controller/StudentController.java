package com.student.api.StudentRegistration.controller;


import com.student.api.StudentRegistration.model.Student;
import com.student.api.StudentRegistration.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/students")
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Create
    // POST
    @PostMapping
    public ResponseEntity<Student>  createStudent(@RequestBody Student student){
        Student created = studentService.createStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(created); // 201
    }

    // Read all
    // GET
    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        List<Student> students = studentService.getAllStudents();
        return ResponseEntity.ok(students); // 200
    }

    // Read one
    // Get /id
    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id){
        Student student = studentService.getStudentById(id);
        return ResponseEntity.ok(student); // 200
    }

    // Update
    // PUT /id
    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id,
                                                 @RequestBody Student student){
        Student updated = studentService.updateStudent(id, student);
        return ResponseEntity.ok(updated); // 200
    }

    // Delete
    // DELETE /id
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStudent(@PathVariable Long id){
        studentService.deleteStudent(id);
        return ResponseEntity.noContent().build(); //204
    }

}
