package com.hackeru.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.hackeru.todolist.pojo.Status;
import com.hackeru.todolist.pojo.Task;

public class AddTaskActivity extends AppCompatActivity {

    EditText newTaskNameEt;
    EditText newTaskDescriptionEt;
    EditText newTaskStatusEt;
    Button addAmdFinishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        newTaskNameEt = findViewById(R.id.new_task_name_et);
        newTaskDescriptionEt = findViewById(R.id.new_task_description);
        addAmdFinishBtn = findViewById(R.id.finish_new_task_btn);
        newTaskStatusEt = findViewById(R.id.new_task_status);

        addAmdFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = newTaskNameEt.getText().toString();
                String taskDescription = newTaskDescriptionEt.getText().toString();
                Status taskStatus = Status.getStatus(newTaskStatusEt.getText().toString());
                Task task = new Task(taskName, taskDescription, taskStatus);
                DataManager.addNewTask(task);

                AlertDialog.Builder alert = new AlertDialog.Builder(AddTaskActivity.this);
                alert.setTitle("Title");
                alert.setMessage("This is a message");
                alert.setCancelable(false);
                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        Toast.makeText(AddTaskActivity.this,"OK Clicked",Toast.LENGTH_SHORT).show();
                    }
                });
                alert.show();

                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
