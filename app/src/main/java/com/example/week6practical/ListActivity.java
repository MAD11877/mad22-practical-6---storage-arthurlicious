package com.example.week6practical;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Button button = findViewById(R.id.btn_main);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // An intent is an abstract description of an operation to be performed.
                Intent i = new Intent(ListActivity.this, MainActivity.class);

                // Information can be tagged with the Intent and send across to the receiver
                // USes key value pair to save data in the intent.
                startActivity(i);
            }
        });


    }
}