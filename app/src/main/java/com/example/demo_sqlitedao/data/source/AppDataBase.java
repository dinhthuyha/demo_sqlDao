package com.example.demo_sqlitedao.data.source;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import androidx.annotation.Nullable;
import com.example.demo_sqlitedao.data.model.Student;

public class AppDataBase extends SQLiteOpenHelper {

    private static final String SQL_CREATE_TABLE = "CREATE TABLE IF NOT EXISTS " + Student.TABLE + "(" +
            Student.ID + " INTEGER PRIMARY KEY, " +
            Student.NAME + " TEXT, " +
            Student.ADDR + " TEXT)";
    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + Student.TABLE;


    private static AppDataBase instance;
    private static final int VERSION = 1;
    private static final String NAME = "SinhVien.db";

    public AppDataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public static AppDataBase getInstance(Context context) {
        if (instance == null) {
            instance = new AppDataBase(context, NAME, null, VERSION);
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
