package com.github.rafti11.databasejava.database;

import android.app.Application;
import android.content.Context;

import com.github.rafti11.databasejava.models.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskRepository {

    private TaskDao taskDao;
    private List<Task> tasks;

    public TaskRepository(Context context){
        TaskDatabase db = TaskDatabase.getDatabase(context);
        taskDao = db.taskDao();
        tasks = taskDao.loadTasks();

    }

    public void setTask(Task task){
        taskDao.insertTask(task);
    }

    public List<Task> getTasks(){
        return taskDao.loadTasks();
    }
}
