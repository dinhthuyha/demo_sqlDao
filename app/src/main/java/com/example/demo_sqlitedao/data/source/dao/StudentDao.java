package com.example.demo_sqlitedao.data.source.dao;

import com.example.demo_sqlitedao.data.model.Student;

import java.util.List;

public interface StudentDao {
    List<Student> getAll();
    void insertStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(int id);
}
