package com.example.capston_rb;

public class BoardData {
    private String title;
    private String content;

    public BoardData() {
        // Default constructor required for calls to DataSnapshot.getValue(BoardData.class)
    }

    public BoardData(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }
}

