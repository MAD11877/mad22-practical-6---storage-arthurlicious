package com.example.week6practical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Random rand = new Random();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        DBHandler database = new DBHandler(this);
//         commit array list in the database
        ArrayList<User> list = new ArrayList<>();
        int no = 1;
        for(int i = 0; i < 20; i++){
            User user = new User();
            user.id = i + 1;
            user.username = "Name -" + rand.nextInt(999999);
            user.description = "Description -" + rand.nextInt(999999);
            user.followed = rand.nextBoolean();
            list.add(user);
            database.insertUser(user);
        }

        database.close();

        RecyclerView rv = findViewById(R.id.recycler_view);
        ListAdapter la = new ListAdapter(list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rv.setAdapter(la);
        rv.setLayoutManager(layoutManager);

        Button button = findViewById(R.id.Follow);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                list.clear();
                for(int i = 0; i < 20; i++){
                    User user = new User();
                    user.id = i + 1;
                    user.username = "Name -" + rand.nextInt(999999);
                    user.description = "Description -" + rand.nextInt(999999);
                    user.followed = rand.nextBoolean();
                    database.updateUser(user);
                    list.add(user);
                }

                ListAdapter la = new ListAdapter(list);
                rv.setAdapter(la);
                rv.setLayoutManager(layoutManager);
            }
        });


    }
}