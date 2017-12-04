package com.example.ricky.apcsquiz;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ScoreDisplay extends AppCompatActivity {
    private Button restart;
    private TextView score,response;
    private int sum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_display);

        Bundle extras = getIntent().getExtras();

        sum = extras.getInt("score");

        score = (TextView)findViewById(R.id.score);
        response = (TextView)findViewById(R.id.response);
        score.setText("Score: "+ sum +"/6");
        if(sum==6){
            response.setText("Well done. You're prepared!");
        }
        if(sum==5||sum==4){
            response.setText("Good Job, but there's room for improvement.");
        }
        if(sum==3||sum==2){
            response.setText("You need to study more!");
        }
        if(sum<2){
            response.setText("Did you even study?");
        }


        restart = (Button) findViewById(R.id.restart);
        restart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }
}