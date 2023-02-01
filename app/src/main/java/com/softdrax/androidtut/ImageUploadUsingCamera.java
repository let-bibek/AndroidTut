package com.softdrax.androidtut;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class ImageUploadUsingCamera extends AppCompatActivity {
    ImageView ivImageFromCamera;
    Button btnLoadImageFromCamera;
    private final int REQUEST_CODE = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_upload_using_camera);
        ivImageFromCamera = findViewById(R.id.ivImageFromCamera);
        btnLoadImageFromCamera = findViewById(R.id.btnLoadImageFromCamera);
        btnLoadImageFromCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCamera = new Intent();
                intentCamera.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intentCamera, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode==RESULT_OK){

            if (requestCode==REQUEST_CODE){
                // for camera
                Bitmap bitmapImage=(Bitmap) data.getExtras().get("data");
                ivImageFromCamera.setImageBitmap(bitmapImage);
            }
        }
    }
}