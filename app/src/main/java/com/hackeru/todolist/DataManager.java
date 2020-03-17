package com.hackeru.todolist;

import com.hackeru.todolist.pojo.Task;

import java.util.ArrayList;

public class DataManager {
    static ArrayList<Task> taskList = new ArrayList<>();

    public static ArrayList<Task> getTaskList() {
        return taskList;
    }

    public static void setTaskList(ArrayList<Task> taskList) {
        DataManager.taskList = taskList;
    }

    public static void addNewTask(Task task){
        taskList.add(task);
    }

}


