package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Page_Activity extends AppCompatActivity {
    Button btn_image;
    ImageView imageView;
    ImageView imageView2;
    ImageView homeBtn;

    int imageIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page);

        btn_image = findViewById(R.id.btn_image);
        imageView = findViewById(R.id.imageView);
        imageView2 = findViewById(R.id.imageView2);


        btn_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changImg();
            }
        });

        homeBtn = findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent hintent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(hintent);
            }
        });



    }

    private void changImg() {
        if(imageIndex == 0){
            imageView.setVisibility(View.INVISIBLE);
            imageView2.setVisibility(View.VISIBLE);
            imageIndex = 1;
        }
        else if(imageIndex == 1){
            imageView.setVisibility(View.VISIBLE);
            imageView2.setVisibility(View.INVISIBLE);
            imageIndex = 0;
        }

    }
}
