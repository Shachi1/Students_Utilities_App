package com.example.mehjabeen.myapplication;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.provider.MediaStore;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;

public class RoutineActivity extends AppCompatActivity {

    private Button updateButton;
    ImageView ivRoutineImage;
    private static final int PICK_IMAGE = 100;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_routine);

        ivRoutineImage = (ImageView) findViewById(R.id.routineImgID);

        showRoutineFromSharedPref();

        updateButton = findViewById(R.id.updateID);
        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
                startActivityForResult(gallery, PICK_IMAGE);
            }
        });
    }

    void showRoutineFromSharedPref() {
        if (!SharedPreferenceManager.getRoutineImageUri(RoutineActivity.this).equalsIgnoreCase("")) {
            if (isReadStoragePermissionGranted()) {
                Picasso.get().load("file:" + SharedPreferenceManager.getRoutineImageUri(RoutineActivity.this)).into(ivRoutineImage);
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            Uri selectedImageURI = data.getData();

            String[] filePathColumn = {MediaStore.Images.Media.DATA};
            Cursor cursor = getContentResolver().query(
                    selectedImageURI,
                    filePathColumn,
                    null,
                    null,
                    null
            );
            cursor.moveToFirst();

            String selectedImageFilePath = cursor.getString(cursor.getColumnIndex(filePathColumn[0]));
            cursor.close();

            Picasso.get().load(new File(selectedImageFilePath)).into(ivRoutineImage);
            SharedPreferenceManager.saveRoutineImageUri(RoutineActivity.this, selectedImageFilePath);

        }
    }

    final int reqCodeRead = 22;
    final int reqCodeWrite = 33;    //for my understanding

    public boolean isReadStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
//                showRoutineFromSharedPref();
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, reqCodeRead);
                return false;
            }
        } else { //permission is automatically granted on installation
            return true;
        }
    }

    public boolean isWriteStoragePermissionGranted() {
        if (Build.VERSION.SDK_INT >= 23) {
            if (checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED) {
                return true;
            } else {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, reqCodeWrite);
                return false;
            }
        } else { //permission is automatically granted on sdk<23 upon installation
            return true;
        }
    }


    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case reqCodeWrite:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //resume tasks needing this permission
                    showRoutineFromSharedPref();
                } else {
                }
                break;

            case reqCodeRead:
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //resume tasks needing this permission
                    showRoutineFromSharedPref();
                } else {
                    Toast.makeText(this, "Can't access gallery", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}