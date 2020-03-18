package com.hackeru.todolist;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.hackeru.todolist.pojo.Task;

public class AddTaskActivity extends AppCompatActivity {

    EditText newTaskNameEt;
    EditText newTaskDescriptionEt;
    Button addAmdFinishBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        newTaskNameEt = findViewById(R.id.new_task_name_et);
        newTaskDescriptionEt = findViewById(R.id.new_task_description);
        addAmdFinishBtn = findViewById(R.id.finish_new_task_btn);

        addAmdFinishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taskName = newTaskNameEt.getText().toString();
                String taskDescription = newTaskDescriptionEt.getText().toString();
                Task task = new Task(taskName, taskDescription);
                DataManager.addNewTask(task);

                setResult(Activity.RESULT_OK);
                finish();
            }
        });
    }
}
