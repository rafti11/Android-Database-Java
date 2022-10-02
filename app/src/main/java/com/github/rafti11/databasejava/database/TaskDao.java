package com.github.rafti11.databasejava.database;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.github.rafti11.databasejava.models.Task;

import java.util.ArrayList;
import java.util.List;

@Dao
public interface TaskDao {
    @Query("SELECT * FROM tasks")
    List<Task> loadTasks();

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertTask(Task task);

}
