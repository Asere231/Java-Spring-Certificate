package com.example.springdatajpa;

import com.example.springdatajpa.model.Student;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class SpringDataJpaApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SpringDataJpaApplication.class, args);

        StudentRepo repo = context.getBean(StudentRepo.class);

//        Student s1 = context.getBean(Student.class);
//        Student s2 = context.getBean(Student.class);
        Student s3 = context.getBean(Student.class);
//
//        s1.setRollNo(101);
//        s1.setName("Navin");
//        s1.setMarks(75);
//
//        s2.setRollNo(102);
//        s2.setName("Juan");
//        s2.setMarks(80);
//
        s3.setRollNo(103);
        s3.setName("Ceph");
        s3.setMarks(60);
//
//        repo.save(s1);
//        repo.save(s2);

//        Save can be also used to update
        repo.save(s3);

        List<Student> students = repo.findAll();

        Student st1 = repo.findById(101)
                .orElse(new Student());

        List<Student> st2 = repo.findByName("Navin");
        List<Student> st3 = repo.findByMarks(80);
        List<Student> st4 = repo.findByMarksGreaterThan(72);


        System.out.println("List of Student:");
        System.out.println(students);
        System.out.println("Student by ID:");
        System.out.println(st1);
        System.out.println("Student by Name:");
        st2.forEach(s -> System.out.println(s));
        System.out.println("Student by Marks:");
        st3.forEach(s -> System.out.println(s));
        System.out.println("Student with Marks Greater Than 72:");
        st4.forEach(s -> System.out.println(s));

        repo.delete(s3);
        List<Student> students1 = repo.findAll();
        System.out.println("List of Student After Deleting:");
        System.out.println(students1);

    }

}
