package com.example.springjdbc.service;

import com.example.springjdbc.model.Student;
import com.example.springjdbc.repo.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    private StudentRepo repo;

    public void addStudent(Student s) {
        System.out.println("addStudent");
        repo.save(s);
    }

    public List<Student> getStudents() {
        return repo.findAll();
    }

    public StudentRepo getRepo() {
        return repo;
    }

    @Autowired
    public void setRepo(StudentRepo repo) {
        this.repo = repo;
    }
}
