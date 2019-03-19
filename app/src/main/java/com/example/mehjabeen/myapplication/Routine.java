package com.example.mehjabeen.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Routine extends AppCompatActivity {

    private Button updateButton;
   // private String content;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

       // ImageView image = (ImageView) findViewById(R.id.routineImgID);

        updateButton = findViewById(R.id.updateID);
//        updateButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new Thread(new Runnable() {
//                    @Override
//                    public void run() {
//                        ImageView image = (ImageView) findViewById(R.id.routineImgID);
//                        image.setImageResource(R.drawable.routine2);
//                    }
//                }).start();
//            }
//        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            Context context;
            @Override
            public void onClick(View v) {
                ImageView image = (ImageView) findViewById(R.id.routineImgID);
                        writeToFile("text",context);
                        image.setImageResource(R.drawable.routine2);

            }
        });
    }

//    void UpdatedID() {
//
//        String fileName = "Update";
//        String content = "Update";
//        fileName = fileName + "txt";
//
//        File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath(), fileName);
//
//        try {
//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write(content.getBytes());
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }


    private void writeToFile(String data, Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput("config.txt", Context.MODE_PRIVATE));
            outputStreamWriter.write(data);
            outputStreamWriter.close();
        }
        catch (IOException e) {
            Log.e("Exception", "File write failed: " + e.toString());
        }
    }

    private String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput("config.txt");

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            Log.e("login activity", "File not found: " + e.toString());
        } catch (IOException e) {
            Log.e("login activity", "Can not read file: " + e.toString());
        }

        return ret;
    }


}
