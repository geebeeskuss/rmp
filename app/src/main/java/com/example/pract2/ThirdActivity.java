package com.example.pract2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bundle arguments = getIntent().getExtras();
        String name = arguments.get("answer").toString();
    }
    public void button2Click(View view){
        System.exit(0);
    }
}