package com.example.test.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

public class ThirdActivity extends AppCompatActivity {
    private DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.third_layout);
        Button button3=(Button) findViewById(R.id.button_3);
        Button button33=(Button) findViewById(R.id.button_33);

        dp=(DatePicker)findViewById(R.id.firstDatePicker);

        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                finish();
            }
        });

        button33.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                int y=dp.getYear();
                int m=dp.getMonth();
                int d=dp.getDayOfMonth();

                Toast.makeText(ThirdActivity.this,"year "+y + " month "+m+ " day "+d,
                        Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(ThirdActivity.this,FourthActivity.class);
                startActivity(intent);
            }
        });

    }
}
