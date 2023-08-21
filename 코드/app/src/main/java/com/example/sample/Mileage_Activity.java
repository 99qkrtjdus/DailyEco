package com.example.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Mileage_Activity extends AppCompatActivity {
    ImageView mtBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mileage);

        mtBtn = findViewById(R.id.mtBtn);
        mtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ecoBtnintent = new Intent(getApplicationContext(), Mypage_Activity.class);
                startActivity(ecoBtnintent);
            }
        });


    }
}
