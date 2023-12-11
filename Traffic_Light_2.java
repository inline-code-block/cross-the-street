package com.example.capston_rb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Traffic_Light_2 extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_light_1); // 여기서 activity_main은 XML 파일의 이름입니다.

        ImageView imageView = findViewById(R.id.imageView); // XML 파일에서 ImageView를 찾습니다.
        imageView.setImageResource(R.drawable.light_2_o); // 이미지를 설정합니다. (your_image는 여러분의 이미지 파일명입니다.)
    }
}