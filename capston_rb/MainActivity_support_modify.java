package com.example.capston_rb;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import androidx.appcompat.app.AppCompatActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import android.content.Intent;


public class MainActivity_support_modify extends AppCompatActivity {

    private EditText editTextTitle, editTextContent;
    private Button btnPost;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_support_modify);

        editTextTitle = findViewById(R.id.editTextTitle);
        editTextContent = findViewById(R.id.editTextContent);
        btnPost = findViewById(R.id.btnPost);

        // Firebase 초기화
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("수정 문의"); //저장될 데이터의 경로

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 게시글을 Firebase에 저장
                postToFirebase();
            }
        });

        findViewById(R.id.go_home).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity_support_modify.this, MainActivity_support.class);
                startActivity(intent);
            }
        });
    }
    private void postToFirebase() {
        Log.d("FirebaseDebug", "postToFirebase: Called"); // 디버그 메시지 추가

        String title = editTextTitle.getText().toString();
        String content = editTextContent.getText().toString();

        // 새로운 데이터를 생성하고 Firebase에 저장
        String key = databaseReference.push().getKey();
        BoardData boardData = new BoardData(title, content);
        databaseReference.child(key).setValue(boardData);

        // 게시판 페이지 닫기 (원하는 동작을 수행)
        finish();
    }
}