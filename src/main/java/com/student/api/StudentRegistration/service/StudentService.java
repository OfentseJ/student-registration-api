package com.student.api.StudentRegistration.service;


import com.student.api.StudentRegistration.model.Student;
import com.student.api.StudentRegistration.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // Create
    public Student createStudent(Student student){
        return studentRepository.save(student);
    }

    // Read all
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Read one
    public Student getStudentById(Long id){
        return studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID "+ id +" not found"));
    }

    // Update
    public Student updateStudent(Long id, Student updatedStudent){
        Student existing = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student with ID "+id+" not found"));

        existing.setName(updatedStudent.getName());
        existing.setSurname(updatedStudent.getSurname());
        existing.setParentPhone(updatedStudent.getParentPhone());
        existing.setParentEmail(updatedStudent.getParentEmail());

        return studentRepository.save(existing);
    }

    // Delete
    public void deleteStudent(Long id){
        if(!studentRepository.existsById(id)){
            throw new RuntimeException("Student with ID " + id + " not found");
        }
        studentRepository.deleteById(id);
    }

}
