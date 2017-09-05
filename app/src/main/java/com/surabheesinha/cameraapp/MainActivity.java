package com.surabheesinha.cameraapp;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {
    final int Request_Code = 1;
    //int REQUEST_IMAGE_CAPTURE = 1;
    Bitmap bitmap;
    ImageView imgvw;
    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        imgvw = (ImageView) findViewById(R.id.result);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if (i.resolveActivity(getPackageManager()) != null) {
                    startActivityForResult(i, Request_Code);
                }
            }

        });


    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if(requestCode == Request_Code)
        {
            if(resultCode == RESULT_OK){
            Bundle bundle = new Bundle();
            bundle= data.getExtras();
            bitmap = (Bitmap) bundle.get("data");
            imgvw.setImageBitmap(bitmap);
        }}


    }
}


