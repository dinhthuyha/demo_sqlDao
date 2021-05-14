package com.example.demo_sqlitedao;

import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.example.demo_sqlitedao.data.model.Student;
import com.example.demo_sqlitedao.data.source.AppDataBase;
import com.example.demo_sqlitedao.data.source.dao.StudentDao;
import com.example.demo_sqlitedao.data.source.dao.StudentDaoImpl;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    StudentDao studentDao;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
       // insertData();

        updateData();
        getData();
    }

    private void insertData() {
        for (int i=1;i<5;i++){
            String name = "Nguyen Van " + (char) ((int) 'A' + i);
            Student student= new Student(i,name,"Thanh Hoa");
            studentDao.insertStudent(student);
        }
    }

    private void updateData(){
        Student student= new Student(1,"Dinh thuy ha","Cam tu");
        studentDao.updateStudent(student);


    }
    private void DeleteData(){
        studentDao.deleteStudent(1);

    }
    private void getData(){
        List<Student> students= studentDao.getAll();
        for (Student student: students){
            Log.d(TAG, "getData: "+ student.toString()+"\n");
        }
    }

    private void initData() {
        /**
         * init Dao
         */
        AppDataBase appDataBase = AppDataBase.getInstance(this);
        studentDao = new StudentDaoImpl(appDataBase);
    }

    private void initView() {
    }
}