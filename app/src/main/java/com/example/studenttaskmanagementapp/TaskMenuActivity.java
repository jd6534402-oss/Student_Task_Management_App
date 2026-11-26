package com.example.studenttaskmanagementapp;

import android.os.Bundle;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Button;
import android.widget.TextView;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

public class TaskMenuActivity extends AppCompatActivity
{
    Button addtask,viewtask,updatetask,viewinfo;
    @Override
    protected void OnCreate(Bundle savedInstanceState)
    {
       super.onCreate(savedInstanceState);
       setContentView(R.layout.activity_taskmenu);

       addtask = findViewById(R.id.addtask);
       viewtask = findViewById(R.id.viewtask);
       updatetask = findViewById(R.id.updatetask);
       viewinfo = findViewById(R.id.viewinfo);

       addtask.setOnClickListener(v ->
       {
            Intent intent = new Intent(TaskMenuActivity.this,AddActivity.class)
            startActivity(intent);

       });

       viewtask.setOnClickListener(v ->
       {
            Intent intent = new Intent(TaskMenuActivity.this,ViewActivity.class)
            startActivity(intent);
       });

       updatetask.setOnClickListener(v ->
       {
            Intent intent = new Intent(TaskMenuActivity.this,UpdateActivity.class)
            startActivity(intent);
       });

       viewinfo.setOnClickListener(v->
       {
           Intent intent = new Intent(TaskMenuActivity.this,InfoActivity.class)
           startActivity(intent);
       });
    }
}
