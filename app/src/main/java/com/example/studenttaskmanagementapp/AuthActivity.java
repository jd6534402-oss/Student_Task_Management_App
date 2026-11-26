package com.example.studenttaskmanagementapp;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Button;
import android.widget.Toast;
import android.widget.TableLayout;
import android.view.View;
import android.os.Bundle;
import android.content.SharedPreferences;


public class AuthActivity extends AppCompatActivity
{
    EditText editpassword,editcourse,editemail,editname;

    TableRow rowName,rowCourse;

    ImageView viewuser,viewemail,viewcourse,viewpassword;

    TextView textmain,textregister;

    Button submitinfo;

    boolean isRegisterMode;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        editname = findViewById(R.id.StudentName);
        editemail = findViewById(R.id.StudentEmail);
        editcourse = findViewById(R.id.StudentCourse);
        editpassword = findViewById(R.id.StudentPassword);

        rowName = findViewById(R.id.row_name);
        rowCourse = findViewById(R.id.row_course);

        textregister = findViewById(R.id.studentlogin);
        submitinfo = findViewById(R.id.submitinfo);

        isRegisterMode = getIntent().getBooleanExtra("IS_REGISTER",false);

        if(isRegisterMode)
        {
            textregister.setText("Student Registration");
            submitinfo.setText("Register");
            rowName.setVisibility(View.VISIBLE);
            rowCourse.setVisibility(View.VISIBLE);
        }
        else
        {
            textregister.setText("Student Log In");
            submitinfo.setText("Log In");
            rowName.setVisibility(View.GONE);
            rowCourse.setVisibility(View.GONE);
        }

        submitinfo.setOnClickListener(v-> handleFormSubmit());
    }

    private void handleFormSubmit()
    {
        String email = editemail.getText().toString().trim();
        String password = editpassword.getText().toString().trim();

        if (email.isEmpty() || password.isEmpty())
        {
            Toast.makeText(this, "Please enter email and password", Toast.LENGTH_SHORT).show();
            return;
        }

        SharedPreferences prefs = getSharedPreferences("StudentPrefs", MODE_PRIVATE);

        if (isRegisterMode)
        {
            String name = editname.getText().toString().trim();
            String course = editcourse.getText().toString().trim();

            if (name.isEmpty() || course.isEmpty())
            {
                Toast.makeText(this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            prefs.edit()
                    .putString("name", name)
                    .putString("email", email)
                    .putString("course", course)
                    .putString("password", password)
                    .apply();

            Toast.makeText(this, "Registered! Please log in.", Toast.LENGTH_SHORT).show();
            finish(); // Returns to MainActivity
        }
        else
        {
            String savedEmail = prefs.getString("email", "");
            String savedPassword = prefs.getString("password", "");

            if (email.equals(savedEmail) && password.equals(savedPassword))
            {
                Toast.makeText(this, "Welcome, " + prefs.getString("name", "Student") + "!", Toast.LENGTH_SHORT).show();
            }
            else
            {
                Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
            }
        }
    }
}


