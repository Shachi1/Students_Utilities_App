package com.example.mehjabeen.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CGPAcalculator extends AppCompatActivity {

    private Button addButton;
    private TextView CGPAoutput;
    private EditText GPA, credithour;
    float sum,CGPA,gpa,Credit;
    float sumofGPA= (float)0.0;
    float sumofCredit= (float)0.0;
    @Override


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpacalculator);
        GPA = findViewById(R.id.gpaID);
        credithour = findViewById(R.id.creditID);
        CGPAoutput = findViewById(R.id.cgpaID);

        addButton = findViewById(R.id.addButtonID);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = GPA.getText().toString();
                gpa = new Float(str).intValue();
                String str2 = GPA.getText().toString();
                Credit = new Float(str2).intValue();
                sumofGPA = sumofGPA+gpa*Credit;
                sumofCredit = sumofCredit+Credit;
                GPA.setText("");
                credithour.setText("");
                CGPA = sumofGPA/sumofCredit;
                CGPAoutput.setText(Float.toString(CGPA));

            }

        });

    }
}
