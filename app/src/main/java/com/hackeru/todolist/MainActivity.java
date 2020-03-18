package com.hackeru.todolist;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.getbase.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {

    int REQUESTCODE = 12345;
    FloatingActionButton addNewTaskBtn;
    AddTaskAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addNewTaskBtn = findViewById(R.id.normal_plus);

        RecyclerView taskList = findViewById(R.id.main_container);
        taskList.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        adapter = new AddTaskAdapter(DataManager.taskList);

        taskList.setAdapter(adapter);

        addNewTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AddTaskActivity.class);
                startActivityForResult(intent, REQUESTCODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        adapter.setInfo(DataManager.taskList);
    }
}
