package com.hackeru.todolist.pojo;

public class Task {
    private String taskName;
    private String taskDescription;
    private Date date;
    Status taskStatus; //TODO, INPROGRESS, COMPLETED, UNKNOWN

    public Task(String taskName, String taskDescription, Status taskStatus) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.taskStatus = taskStatus;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return taskName + " Status is: " + taskStatus.name();
    }
}
