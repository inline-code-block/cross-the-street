package com.example.capston_rb;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;

public class MainActivity_support extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_support);

        //신호등 추가 문의 화면으로 이동하기
        findViewById(R.id.button_go_to_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_support.this, MainActivity_support_add.class);
                startActivity(intent);
            }
        });

        //신호등 수정 문의로 이동하기
        findViewById(R.id.button_go_to_modify).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_support.this, MainActivity_support_modify.class);
                startActivity(intent);
            }
        });

        //홈 화면으로 이동하기.
        findViewById(R.id.back_button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                Intent intent = new Intent(MainActivity_support.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}