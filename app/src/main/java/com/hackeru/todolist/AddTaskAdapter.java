package com.hackeru.todolist;

import android.graphics.Color;
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
        holder.taskStatusTv.setText(taskArrayist.get(position).taskStatus.name());

        switch (taskArrayist.get(position).taskStatus){
            case TODO:
                holder.taskStatusTv.setTextColor(Color.RED);
                break;
            case INPROGRESS:
                holder.taskStatusTv.setTextColor(Color.YELLOW);
                break;
            case COMPLETED:
                holder.taskStatusTv.setTextColor(Color.GREEN);
                break;
            case UNKNOWN:
                holder.taskStatusTv.setTextColor(Color.GRAY);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return taskArrayist.size();
    }

    public class TasksViewHolder extends RecyclerView.ViewHolder {

        RecyclerView recyclerView;
        TextView taskNameTv;
        TextView taskDescriptionTv;
        TextView taskStatusTv;


        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            recyclerView = itemView.findViewById(R.id.main_container);
            taskNameTv = itemView.findViewById(R.id.task_name_tv);
            taskDescriptionTv = itemView.findViewById(R.id.task_description_tv);
            taskStatusTv = itemView.findViewById(R.id.task_status);

        }
    }
}
