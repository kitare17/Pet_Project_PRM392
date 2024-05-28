package com.example.recycleview;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form1 extends AppCompatActivity {

    private EditText editTextName;
    private Button buttonSubmitName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form1);
        editTextName = findViewById(R.id.editTextName);
        buttonSubmitName = findViewById(R.id.buttonSubmitName);
        buttonSubmitName.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            if (!name.equals("")) {
                Toast.makeText(this, name, Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, Form2.class);
                intent.putExtra("fullname", name);
                startActivity(intent);
            } else
            {
                Toast.makeText(this, "Please input fullname", Toast.LENGTH_SHORT).show();
            }
        });
    }
}