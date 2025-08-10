package com.exmin.bmi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Ensure you set the correct layout

        EditText hint_ht_In = findViewById(R.id.edtHeightIn);
        EditText hint_ht_Ft = findViewById(R.id.edtHeightFt);
        EditText hint_wt = findViewById(R.id.edtWeight);
        Button myButton = findViewById(R.id.myButton);
        TextView Result = findViewById(R.id.result);

        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt = Integer.parseInt(hint_wt.getText().toString());
                int Ft = Integer.parseInt(hint_ht_Ft.getText().toString());
                int In = Integer.parseInt(hint_ht_In.getText().toString());

                int totalIn = Ft * 12 + In;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;

                double BMI = wt / (totalM * totalM);

                if (BMI > 25) {
                    Result.setText("You are overweight");
                } else if (BMI < 18) {
                    Result.setText("You are underweight");
                } else {
                    Result.setText("You are healthy");
                }
            }
        });
    }
}
