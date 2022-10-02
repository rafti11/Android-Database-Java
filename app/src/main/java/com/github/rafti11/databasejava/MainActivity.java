package com.github.rafti11.databasejava;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import com.github.rafti11.databasejava.database.TaskRepository;
import com.github.rafti11.databasejava.models.Task;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private Button bt_insert;
    private Button bt_get;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_insert = findViewById(R.id.bt_insert_task);
        bt_get = findViewById(R.id.bt_get);
        et_name = findViewById(R.id.ed_task);

        TaskRepository repository = new TaskRepository(getApplicationContext());

        bt_insert.setOnClickListener(v ->{

            System.out.println("pulsado");

            Task insert = new Task();
            insert.name = et_name.getText().toString();
            repository.setTask(insert);



        });

        bt_get.setOnClickListener(v -> {

            List<Task> tasks = repository.getTasks();
            System.out.println("size: " + tasks.size());

            for (int i = 0; i < tasks.size(); i++){

                Task task = tasks.get(i);
                System.out.println("task: " + task.name);
            }

        });
    }
}