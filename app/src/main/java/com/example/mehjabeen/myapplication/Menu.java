package com.example.mehjabeen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button cgpaButton, quitButton, routineButton, eventButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        cgpaButton = findViewById(R.id.cgpaID);
        cgpaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,CGPAcalculator.class);
                startActivity(intent);
            }
        });

        quitButton = findViewById(R.id.quitID);
        quitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        routineButton = findViewById(R.id.routineID);
        routineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Routine.class);
                startActivity(intent);
            }
        });

        eventButton = findViewById(R.id.eventID);
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Event.class);
                startActivity(intent);
            }
        });
    }
}
