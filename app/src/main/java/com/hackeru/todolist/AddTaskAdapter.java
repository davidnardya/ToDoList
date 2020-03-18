package com.hackeru.todolist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.hackeru.todolist.pojo.Task;

import java.util.ArrayList;

public class AddTaskAdapter extends RecyclerView.Adapter<AddTaskAdapter.TasksViewHolder> {

    ArrayList<Task> taskArrayist;

    public void setInfo(ArrayList<Task> list){
        taskArrayist = list;
        notifyDataSetChanged();
    }

    public AddTaskAdapter(ArrayList<Task> taskArrayist) {
        this.taskArrayist = taskArrayist;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.single_task_layout, parent, false);

        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        Task item = taskArrayist.get(position);
        holder.taskNameTv.setText(item.getTaskName());
        holder.taskDescriptionTv.setText(item.getTaskDescription());
    }

    @Override
    public int getItemCount() {
        return taskArrayist.size();
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView taskNameTv;
        TextView taskDescriptionTv;


        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.main_container);
            taskNameTv = itemView.findViewById(R.id.task_name_tv);
            taskDescriptionTv = itemView.findViewById(R.id.task_description_tv);

        }
    }
}
