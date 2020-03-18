package com.hackeru.todolist.pojo;

public enum Status {
    TODO, INPROGRESS, COMPLETED, UNKNOWN;

    public static Status getStatus(String input){
        Status status;

        switch (input){
            case "todo":
                status = TODO;
                break;

            case "inprogress":
                status = INPROGRESS;
                break;

            case "completed":
                status = COMPLETED;
                break;

            default:
                status = UNKNOWN;
                break;
        }
        return status;
    }
}
