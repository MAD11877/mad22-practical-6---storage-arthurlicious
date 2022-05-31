package com.example.week6practical;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.lang.reflect.GenericArrayType;
import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {
    private DatabaseReference database;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        final EditText username = findViewById(R.id.txt_username);
        final EditText password = findViewById(R.id.txt_password);
        FirebaseDatabase database = FirebaseDatabase.getInstance();

        // the entry point for accessing a firebase database
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        // pass in our UserLogin class
        DatabaseReference databaseReference = db.getReference("/Users/mad/");

//        FirebaseDatabase database = FirebaseDatabase.getInstance();
//        DatabaseReference myRef = database.getReference().child("Users").child("mad");
        Button button = findViewById(R.id.login_btn);

        Map<String, String> map_userLogin = new HashMap<String, String>();
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                databaseReference.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot snapshot) {
                        UserLogin uL = new UserLogin();
//                        uL = snapshot.getValue(UserLogin.class);
//                        Toast.makeText(LoginActivity.this, uL., Toast.LENGTH_SHORT).show();
//                        Toast.makeText(LoginActivity.this, "test", Toast.LENGTH_SHORT).show();
                        uL = snapshot.getValue(UserLogin.class);
//                        Toast.makeText(LoginActivity.this, uL.password, Toast.LENGTH_SHORT).show();
//                        Toast.makeText(LoginActivity.this, uL.username, Toast.LENGTH_SHORT).show();
                        map_userLogin.put(uL.username, uL.password);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError error) {

                    }
                });

                for (Map.Entry<String,String> entry : map_userLogin.entrySet()) {
                    Log.i("What", entry.getKey());
                    Log.i("What", entry.getValue());
                    if (username.getText().toString().equals(entry.getKey()) && password.getText().toString().equals(entry.getValue())) {
                        Intent i = new Intent(LoginActivity.this, ListActivity.class);
                        Log.i("What", username.getText().toString());
                        Log.i("What", password.getText().toString());

                        // Information can be tagged with the Intent and send across to the receiver
                        // USes key value pair to save data in the intent.
                        startActivity(i);
                    }
                }
            }



        });

//        DataAccessUserLogin dataAccessUserLogin = new DataAccessUserLogin();
//        Button button = findViewById(R.id.login_btn);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                dataAccessUserLogin.read("User", username.getText().toString());
//                /*HashMap<String, Object> hashMap = new HashMap<>();
//                for (Map.Entry<String, Object> entry : hashMap.entrySet()){
//                    Toast.makeText(LoginActivity.this, (entry.getKey()).toString(), Toast.LENGTH_SHORT).show();
//                }*/
//
//
//
//
//            }
//        });
    }
}