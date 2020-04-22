package com.example.sqlitedatabase.DatabaseClasses;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MyDataBaseClass extends SQLiteOpenHelper {

    private static final String DATABASE_NAME="UniStudentInformation.db";
    private static final int DATABASE_VERSION=1;

    private String queryToCreateDatabase="create table UniStudent (ID INTEGER PRIMARY KEY AUTOINCREMENT" +
            ",Name VARCHAR(255), Email VARCHAR(255), Phone INTEGER)";
    Context context;


    public MyDataBaseClass(Context context){
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try
        {
            db.execSQL(queryToCreateDatabase);
            Toast.makeText(context, "Table is created Successfully", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e)
        {
            Toast.makeText(context, "Error while creating table", Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
