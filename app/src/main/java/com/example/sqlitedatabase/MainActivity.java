package com.example.sqlitedatabase;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sqlitedatabase.DatabaseClasses.MyDataBaseClass;

public class MainActivity extends AppCompatActivity {

    private MyDataBaseClass ObjMyDataBaseClass;
    EditText userNameET,emailET,phoneET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ObjMyDataBaseClass=new MyDataBaseClass(this);

        userNameET=findViewById(R.id.userNameET);
        emailET=findViewById(R.id.emailET);
        phoneET=findViewById(R.id.phoneET);

    }

    private void createDatabase(View view)
    {
        try
        {
            ObjMyDataBaseClass.getReadableDatabase();
        }
        catch (Exception e)
        {
            Toast.makeText(this, "Exception while creating database", Toast.LENGTH_SHORT).show();
        }
    }

    public void insertIntoDatabase(View view)
    {
        try
        {
            SQLiteDatabase objSQLiteDatbase=ObjMyDataBaseClass.getWritableDatabase();
            if (objSQLiteDatbase!=null)
            {
                if (!userNameET.getText() .toString() .isEmpty() && !emailET.getText() .toString() .isEmpty()
                && phoneET.getText() .toString() .isEmpty())
                {
                    ContentValues objContentValues=new ContentValues();
                    objContentValues.put("Name", userNameET.getText() .toString());

                    objContentValues.put("Email", emailET.getText() .toString());
                    objContentValues.put("Phone", Integer.parseInt(phoneET.getText() .toString()));

                    long checkIfQueryRuns=objSQLiteDatbase.insert("UniStudent", null, objContentValues);
                    if(checkIfQueryRuns!=-1)
                    {
                        Toast.makeText(this, "Values inserted into database", Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
                    }

                }
            }
        }
        catch (Exception e)
        {
            Toast.makeText(this, "insertValueIntoDatabase"+e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }


}
