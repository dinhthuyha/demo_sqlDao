package com.example.demo_sqlitedao.data.source.dao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.example.demo_sqlitedao.data.model.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao{

    SQLiteDatabase writeDb;
    SQLiteDatabase readDb;

    public StudentDaoImpl(SQLiteOpenHelper database) {
        this.writeDb = database.getWritableDatabase();
        this.readDb = database.getReadableDatabase();
    }

    @Override
    public List<Student> getAll() {
        List<Student> students= new ArrayList<>();
        Cursor cursor=readDb.query(Student.TABLE, null, null, null, null, null, null);
        cursor.moveToFirst();
        while (!cursor.isAfterLast()){
            Student student= new Student(cursor);
            students.add(student);
            cursor.moveToNext();
        }
        cursor.close();
        return students;
    }

    @Override
    public void insertStudent(Student student) {
        writeDb.insert(Student.TABLE, null, student.getContentValue());

    }

    @Override
    public void updateStudent(Student student) {
        writeDb.update(Student.TABLE,student.getContentValue(), Student.ID+" =?",new String[] {String.valueOf(student.id)});

    }

    @Override
    public void deleteStudent(int id) {
        writeDb.delete(Student.TABLE, Student.ID + " =?", new String[]{String.valueOf(id)});

    }
}
