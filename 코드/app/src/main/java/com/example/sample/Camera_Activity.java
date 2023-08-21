package com.example.sample;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Camera_Activity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCamera;
    private ImageView imageView, maintransBtn;

    private static final int REQUEST_IMAGE_CODE = 101;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.camera);

        // 디자인 정의
        btnCamera = (Button) findViewById(R.id.cBtn);
        imageView = (ImageView) findViewById(R.id.image);
        btnCamera.setOnClickListener(this);

        maintransBtn = findViewById(R.id.maintransBtn);
        maintransBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ecoBtnintent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(ecoBtnintent);
            }
        });
    }

    @Override
    public void onClick(View view)    {
        switch (view.getId()) {
            // 카메라촬영 클릭 이벤트
            case R.id.cBtn:
                // 카메라 기능을 Intent
                Intent i = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(i, REQUEST_IMAGE_CODE);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data)    {
        super.onActivityResult(requestCode, resultCode, data);

        // 카메라 촬영을 하면 이미지뷰에 사진 삽입
        if(requestCode == 0 && resultCode == RESULT_OK) {
            // Bundle로 데이터를 입력
            Bundle extras = data.getExtras();

            // Bitmap으로 컨버전
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            // 이미지뷰에 Bitmap으로 이미지를 입력
            imageView.setImageBitmap(imageBitmap);
        }

    }
}