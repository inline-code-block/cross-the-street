package com.example.capston_rb;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.os.CountDownTimer;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class Traffic_Light_12 extends AppCompatActivity {

    private ImageView imageView;
    private int[] images = { R.drawable.light_12_r, R.drawable.light_12_g};
    private int[] displayTimes = {35000, 23000};
    private int currentIndex = 0;
    private TextView timerTextView;
    private int[] timeArray = {35000, 23000}; // 각 이미지에 대한 타이머 시간 (밀리초 단위)
    private CountDownTimer countDownTimer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.traffic_light_1);
        timerTextView = findViewById(R.id.timerTextView);

        imageView = findViewById(R.id.imageView);
        imageView.setImageResource(images[currentIndex]); // 초기에 첫 번째 이미지 설정

        startTimer(timeArray[currentIndex]); // 첫 번째 이미지에 대한 타이머 시작
    }
    private void startTimer(long millisInFuture) {
        countDownTimer = new CountDownTimer(millisInFuture, 1000) {
            public void onTick(long millisUntilFinished) {
                timerTextView.setText("" + millisUntilFinished / 1000 + " 초");
            }

            public void onFinish() {
                currentIndex = (currentIndex + 1) % images.length;
                imageView.setImageResource(images[currentIndex]); // 다음 이미지로 변경
                startTimer(timeArray[currentIndex]); // 다음 이미지에 대한 타이머 시작
            }
        }.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }
}
