package com.example.recycleview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form5 extends AppCompatActivity {

    private EditText editNum1;
    private EditText editNum2;
    private EditText editNum3;
    private Button solve5;
    private Button back5;

    private TextView textViewLab5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form5);

        editNum1 = findViewById(R.id.editNum1);
        editNum2 = findViewById(R.id.editNum2);
        editNum3 = findViewById(R.id.editNum3);
        solve5 = findViewById(R.id.solve5);
        textViewLab5 = findViewById(R.id.textViewLab5);


        solve5.setOnClickListener(v -> {
            double a = Double.parseDouble(editNum1.getText().toString());
            double b = Double.parseDouble(editNum2.getText().toString());
            double c = Double.parseDouble(editNum3.getText().toString());

            double delta = b * b - 4 * a * c;

            if (delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                textViewLab5.setText("Phương trình có 2 nghiệm phân biệt:\n" +
                        "x1 = " + x1 + "\n" +
                        "x2 = " + x2 + "\n"
                );

            } else if (delta == 0) {
                double x = -b / (2 * a);
                textViewLab5.setText("Phương trình có nghiệm kép:\n" +
                        "x = " + x);
            } else {
                textViewLab5.setText("Phương trình vô nghiệm");
            }
        });


    }
}