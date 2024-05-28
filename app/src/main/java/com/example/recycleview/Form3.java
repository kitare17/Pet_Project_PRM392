package com.example.recycleview;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Form3 extends AppCompatActivity {


    private EditText editStart;
    private EditText editEnd;

    private Button checkPrime;

    private TextView textViewResult;

    private Button backView3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_form3);

        editStart = findViewById(R.id.editStart);
        editEnd = findViewById(R.id.editEnd);
        checkPrime = findViewById(R.id.checkPrime);
        textViewResult = findViewById(R.id.textViewResult);
        backView3 = findViewById(R.id.backView3);
        backView3.setOnClickListener(v->{
            finish();
        });

        checkPrime.setOnClickListener(v -> {

            String result = "Result: ";
            if (editStart.getText().toString().equals("") || editEnd.getText().toString().equals("")) {
                Toast.makeText(this, "Fill all field", Toast.LENGTH_SHORT).show();
            } else {
                int num1 = Integer.parseInt(editStart.getText().toString());
                int num2 = Integer.parseInt(editEnd.getText().toString());

                if (num1 > num2) {
                    Toast.makeText(this, "Num 1 must be less than num 2 ", Toast.LENGTH_SHORT).show();
                } else {
                    if (num1<2) num1=2;
                    for (int i = num1; i <= num2; i++) {
                        if (!checkPrime(i)) result = result + i + ", ";
                    }
                    textViewResult.setText(result);
                }
            }
        });
    }

    private boolean checkPrime(int num) {
        boolean flag = false;
        for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                flag = true;
                break;
            }
        }
        return flag;
    }
}