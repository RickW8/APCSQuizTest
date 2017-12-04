package com.example.ricky.apcsquiz;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity implements View.OnClickListener {
    private QuestionBank mQuestionLibrary = new QuestionBank();

    private TextView mScoreView;
    private TextView mQuestionView;
    private Button mButtonChoice1, mButtonChoice2, mButtonChoice3, mButtonChoice4;

    public MediaPlayer right, wrong;

    private int catNum;
    private String mAnswer;
    private int mScore = 0;
    private int mQuestionNumber = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        final Bundle extras = getIntent().getExtras();

        catNum = extras.getInt("category");

        mScoreView = (TextView) findViewById(R.id.sDisplay);
        mQuestionView = (TextView) findViewById(R.id.question);
        mButtonChoice1 = (Button) findViewById(R.id.choice1);
        mButtonChoice2 = (Button) findViewById(R.id.choice2);
        mButtonChoice3 = (Button) findViewById(R.id.choice3);
        mButtonChoice4 = (Button) findViewById(R.id.choice4);

        mButtonChoice1.setOnClickListener(this);
        mButtonChoice2.setOnClickListener(this);
        mButtonChoice3.setOnClickListener(this);
        mButtonChoice4.setOnClickListener(this);

        right = MediaPlayer.create(this, R.raw.right);
        wrong = MediaPlayer.create(this, R.raw.wrong);

        mQuestionLibrary.initQuestions(getApplicationContext());
        updateQuestion();
        updateScore();
    }

    private void updateQuestion() {
        if (mQuestionNumber < 6) {
            mQuestionView.setText(mQuestionLibrary.getQuestion(catNum + mQuestionNumber));
            mButtonChoice1.setText(mQuestionLibrary.getChoice(catNum + mQuestionNumber, 1));
            mButtonChoice2.setText(mQuestionLibrary.getChoice(catNum + mQuestionNumber, 2));
            mButtonChoice3.setText(mQuestionLibrary.getChoice(catNum + mQuestionNumber, 3));
            mButtonChoice4.setText(mQuestionLibrary.getChoice(catNum + mQuestionNumber, 4));
            mAnswer = mQuestionLibrary.getCorrectAnswer(catNum + mQuestionNumber);
            mQuestionNumber++;
        } else {
            Toast.makeText(QuizActivity.this, "It was the last question", Toast.LENGTH_SHORT);
            Intent intent = new Intent(QuizActivity.this, ScoreDisplay.class);
            intent.putExtra("score", mScore);
            startActivity(intent);
        }
    }

    private void updateScore() {
        mScoreView.setText("" + mScore + "/6");
    }

    @Override
    public void onClick(View view) {

        Button answer = (Button) view;
        if (answer.getText().equals(mAnswer)) {
            right.start();
            mScore = mScore + 1;
            Toast.makeText(QuizActivity.this, "Correct!", Toast.LENGTH_SHORT).show();
        }
        else {
            wrong.start();
            Toast.makeText(QuizActivity.this, "Wrong!", Toast.LENGTH_SHORT).show();
        }
        updateScore();
        updateQuestion();
    }
}


