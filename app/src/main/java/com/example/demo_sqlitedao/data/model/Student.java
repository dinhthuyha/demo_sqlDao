package com.example.demo_sqlitedao.data.model;

import android.content.ContentValues;
import android.database.Cursor;

public class Student {
    public static final String TABLE = "Sinhvien";
    public static final String ID = "id";
    public static final String NAME = "name";
    public static final String ADDR = "addr";

    public int id;
     String name;
    String addr;

    public Student(int id, String name, String addr) {
        this.id = id;
        this.name = name;
        this.addr = addr;
    }

    public Student(Cursor cursor) {
        this.id = cursor.getInt(cursor.getColumnIndex(ID));
        this.name = cursor.getString(cursor.getColumnIndex(NAME));
        this.addr = cursor.getString(cursor.getColumnIndex(ADDR));

    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }


    public ContentValues getContentValue() {
        ContentValues contentValues = new ContentValues();
        contentValues.put(ID, this.id);
        contentValues.put(NAME, this.name);
        contentValues.put(ADDR, this.addr);
        return contentValues;
    }
}
