package com.jb19011763.a189011763_opsc_poe12;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class CamCapture extends AppCompatActivity
{
    //initialize variables
    ImageView Image_view;
    Button btn_open;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cam_capture);

        //Assign variables
        Image_view = findViewById(R.id.Image_view);
        btn_open = findViewById(R.id.btn_open);

        //Request camera permissions
        if (ContextCompat.checkSelfPermission(CamCapture.this,
                Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {
            ActivityCompat.requestPermissions(CamCapture.this,
                    new String[]{
                            Manifest.permission.CAMERA
                    },
                    100);
        }

        btn_open.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Open camera
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,100);
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (requestCode == 100) {
            //Get Capture Image
            Bitmap captureImage = (Bitmap) data.getExtras().get("data");
            //Set Capture Image to ImageView
            Image_view.setImageBitmap(captureImage);

        }
    }
}