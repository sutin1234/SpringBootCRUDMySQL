package com.example.crud.services;

import com.example.crud.repository.StudentRepository;
import com.example.crud.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class ServiceStudent {

    @Autowired
    StudentRepository studentRepository;

    // getAllStudent
    public List<Student> getStudents(){
        return (List<Student>) studentRepository.findAll();
    }
    
    // Get Student ById
    public Student getStudent(final Integer id) {
        return studentRepository.getOne(id);
    }

    // Save / Update
    public Student saveStudent(final Student std) {
        return studentRepository.save(std);
    }

    // delete
    public void deleteStudent(final Integer id) {
        studentRepository.deleteById(id);
    }
    
}