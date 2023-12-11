package com.example.capston_rb;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //GPS 화면으로 이동하기
        findViewById(R.id.go_gps).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity_gps.class);
                startActivity(intent);
            }
        });

        //고객 센터 화면으로 이동하기
        findViewById(R.id.go_support).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, MainActivity_support.class);
                startActivity(intent);
            }
        });

    }
}