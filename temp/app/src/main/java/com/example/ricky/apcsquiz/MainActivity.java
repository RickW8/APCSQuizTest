package com.example.ricky.apcsquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button start1,start2,start3,start4,start5;
    private int num;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        start1 = (Button) findViewById(R.id.start1);
        start2 = (Button) findViewById(R.id.start2);
        start3 = (Button) findViewById(R.id.start3);
        start4 = (Button) findViewById(R.id.start4);
        start5 = (Button) findViewById(R.id.start5);
        start1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=0;
                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                i.putExtra("category",num);
                startActivity(i);
            }
        });
        start2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=6;
                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                i.putExtra("category",num);
                startActivity(i);
            }
        });
        start3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=12;
                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                i.putExtra("category",num);
                startActivity(i);
            }
        });
        start4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=18;
                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                i.putExtra("category",num);
                startActivity(i);
            }
        });
        start5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num=24;
                Intent i = new Intent(getApplicationContext(),QuizActivity.class);
                i.putExtra("category",num);
                startActivity(i);
            }
        });
    }
}

