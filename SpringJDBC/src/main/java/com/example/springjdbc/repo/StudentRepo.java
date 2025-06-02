package com.example.springjdbc.repo;

import com.example.springjdbc.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentRepo {

    private JdbcTemplate jdbc;

    public void save(Student s) {
        System.out.println("Student added in save()");
        String sql = "insert into student (rollno, name, marks) values (?, ?, ?)";
        int rows = jdbc.update(sql, s.getRollNo(), s.getName(), s.getMarks());
        System.out.println("Rows (" + rows + ") affected");
    }

    public List<Student> findAll() {
        String sql = "select * from student";

//       ========== No Lambda ==========
//        RowMapper<Student> mapper = new RowMapper<Student>() {
//            @Override
//            public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
//
//                Student s = new Student();
//                s.setRollNo(rs.getInt("rollno"));
//                s.setName(rs.getString("name"));
//                s.setMarks(rs.getInt("marks"));
//
//                return s;
//            }
//        };

//       ========== With Lambda ==========
//        RowMapper<Student> mapper = (rs, rowNum) -> {
//
//            Student s = new Student();
//            s.setRollNo(rs.getInt("rollno"));
//            s.setName(rs.getString("name"));
//            s.setMarks(rs.getInt("marks"));
//
//            return s;
//        };
//
//        return jdbc.query(sql, mapper);

//       ========== With Lambda Even Shorter ==========
//       In this case 'mapper' because the lambda expression itself
        return jdbc.query(sql, (rs, rowNum) -> {

            Student s = new Student();
            s.setRollNo(rs.getInt("rollno"));
            s.setName(rs.getString("name"));
            s.setMarks(rs.getInt("marks"));

            return s;
        });
    }

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }
}
