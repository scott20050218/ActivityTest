package com.example.test.activitytest;

import android.content.Intent;
import android.media.Rating;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.Toast;

public class FiveActivity extends AppCompatActivity {

    private ProgressBar pb;
    private Button firstButtone;
    private Button secondButton;
    private RatingBar rb;
    private Button getValueButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.five_layout);

        pb=(ProgressBar) findViewById(R.id.progressBar);

        rb=(RatingBar) findViewById(R.id.ratingBar);

        pb.setMax(50);

        firstButtone=(Button) findViewById(R.id.plus10Button);
        secondButton=(Button) findViewById(R.id.pluss10Button);
        getValueButton=(Button) findViewById(R.id.starButton);

        firstButtone.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                pb.incrementProgressBy(10);
            }
        });

        secondButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                pb.incrementSecondaryProgressBy(15);
            }
        });

        getValueButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Toast.makeText(FiveActivity.this,"v is "+rb.getRating(),Toast.LENGTH_SHORT).show();
            }
        });

    }
}
