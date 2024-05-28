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

public class Form4 extends AppCompatActivity {

    private EditText editText4;
    private Button buttonCheck4;
    private Button buttonBack4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form4);
        editText4 = findViewById(R.id.editText4);
        buttonCheck4 = findViewById(R.id.buttonCheck4);
        buttonBack4 = findViewById(R.id.buttonBack4);

        buttonCheck4.setOnClickListener(v -> {
            if (!editText4.getText().toString().equals("")) {
                int numberCheck = Integer.parseInt(editText4.getText().toString());
                if (numberCheck % 2 == 0)
                    Toast.makeText(this, "Even number", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "Odd number", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "Please fill number", Toast.LENGTH_SHORT).show();
            }
        });

        buttonBack4.setOnClickListener(v->{
           finish();
        });
    }
}