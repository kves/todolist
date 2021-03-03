package com.example.todolist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ConstraintLayout mLayout;
    private EditText addTaskBox;
    private FloatingActionButton addTaskButton;
    private ListView listView;
    private ArrayAdapter<String> adapter;
    private ArrayList<String> tasksList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addTaskButton = (FloatingActionButton) findViewById(R.id.add_task_button);
        addTaskBox = (EditText) findViewById(R.id.add_task_box);
        mLayout = (ConstraintLayout) findViewById(R.id.constraintLayout);
        listView = (ListView) findViewById(R.id.listView);

        tasksList = new ArrayList<String>();
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, tasksList);
        listView.setAdapter(adapter);
        addTaskButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int idCounter = 1;
                tasksList.add(addTaskBox.getText().toString());
                adapter.notifyDataSetChanged();
                LinearLayout buttonContainer = (LinearLayout) findViewById(R.id.buttonContainer);
                final Button button = new Button(getApplicationContext());
                buttonContainer.addView(button);
                button.setId(idCounter++);
                idCounter++;
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        int id = button.getId();
                        System.out.println(id);
                    }
                });
            }
        });


    }

}