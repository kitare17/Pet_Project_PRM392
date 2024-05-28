package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form2 extends AppCompatActivity {
     private TextView textHello;
     private Button buttonBai1;
     private Button buttonBai2;
     private Button buttonBai3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form2);
        textHello = findViewById(R.id.editTextHello);
        buttonBai1= findViewById(R.id.buttonBai1);
        buttonBai2= findViewById(R.id.buttonBai2);
        buttonBai3= findViewById(R.id.buttonBai3);
        if(getIntent()!=null){
            String fullname =getIntent().getStringExtra("fullname");
            textHello.setText("Hello "+fullname);
        }
        buttonBai1.setOnClickListener(v -> {
            Intent intent=new Intent(this, Form3.class);
            startActivity(intent);
        });
        buttonBai2.setOnClickListener(v -> {
            Intent intent=new Intent(this, Form4.class);
            startActivity(intent);
        });
        buttonBai3.setOnClickListener(v -> {
            Intent intent=new Intent(this, Form5.class);
            startActivity(intent);
        });

    }
}