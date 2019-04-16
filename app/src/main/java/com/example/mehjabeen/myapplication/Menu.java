package com.example.mehjabeen.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    Button cgpaButton, quitButton, routineButton, eventButton, resourceButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        resourceButton = findViewById(R.id.resourcesID);
        resourceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this,Resources.class);
                startActivity(intent);

//                File TEST = new File(Environment.getExternalStorageDirectory(), "TEST");
//                TEST.mkdir(); // make directory may want to check return value
//                String path = TEST.getAbsolutePath();
            }
        });

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
                Intent intent = new Intent(Menu.this, RoutineActivity.class);
                startActivity(intent);
            }
        });

        eventButton = findViewById(R.id.eventID);
        eventButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Menu.this, EventActivity.class);
                startActivity(intent);
            }
        });
    }

//    public static HashSet<String> mkdir() {
//        final HashSet<String> out = new HashSet<String>();
//        String reg = "(?i).*vold.*(vfat|ntfs|exfat|fat32|ext3|ext4).*rw.*";
//        String s = "";
//        try {
//            final Process process = new ProcessBuilder().command("mount")
//                    .redirectErrorStream(true).start();
//            process.waitFor();
//            final InputStream is = process.getInputStream();
//            final byte[] buffer = new byte[1024];
//            while (is.read(buffer) != -1) {
//                s = s + new String(buffer);
//            }
//            is.close();
//        } catch (final Exception e) {
//            e.printStackTrace();
//        }
//
//        // parse output
//        final String[] lines = s.split("\n");
//        for (String line : lines) {
//            if (!line.toLowerCase(Locale.US).contains("asec")) {
//                if (line.matches(reg)) {
//                    String[] parts = line.split(" ");
//                    for (String part : parts) {
//                        if (part.startsWith("/"))
//                            if (!part.toLowerCase(Locale.US).contains("vold"))
//                                out.add(part);
//                    }
//                }
//            }
//        }
//        return out;
//    }
}
