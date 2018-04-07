package com.example.test.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity {

    private CheckBox eat;
    private CheckBox sleep;
    private CheckBox dota;
    private CheckBox all;
    private CheckBox allnot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second_layout);
        Intent intent =getIntent();
        String data = intent.getStringExtra("extra_data");
        Log.d("SecondActivity",data);
       // Toast.makeText(SecondActivity.this,data,
        //        Toast.LENGTH_SHORT).show();

        Button button2=(Button) findViewById(R.id.button_2);

        Button button_next=(Button) findViewById(R.id.button_next);

        CheckBox2Linsener cc=new CheckBox2Linsener();
        all=(CheckBox)findViewById(R.id.allid);
        allnot=(CheckBox)findViewById(R.id.allnotid);
        eat=(CheckBox)findViewById(R.id.eatid);
        sleep=(CheckBox)findViewById(R.id.sleepid);
        dota=(CheckBox)findViewById(R.id.dotaid);
        all.setOnCheckedChangeListener(cc);
        allnot.setOnCheckedChangeListener(cc);



        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent();
                intent.putExtra("data_return","Hello FirstActivity");
                setResult(RESULT_OK,intent);
                finish();
            }
        });

        button_next.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent("com.example.activitytest.ACTION_START");
                intent.addCategory("com.example.activitytest.MY_CATEGORY");
                startActivity(intent);
            }
        });
    }

    class CheckBox2Linsener implements CompoundButton.OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
          if (compoundButton.getId()==R.id.allid){
                if (b){
                    eat.setChecked(true);
                    sleep.setChecked(true);
                    dota.setChecked(true);
                    all.setText("全不选");
                }else{
                    eat.setChecked(false);
                    sleep.setChecked(false);
                    dota.setChecked(false);
                    all.setText("全选");
                }
            }else if (compoundButton.getId()==R.id.allnotid){
                if (b){
                    eat.setChecked(false);
                    sleep.setChecked(false);
                    dota.setChecked(false);
                }else{
                    eat.setChecked(true);
                    sleep.setChecked(true);
                    dota.setChecked(true);
                }
            }

            if (b){
                System.out.println("CheckBox is checked");
            }else{
                System.out.println("CheckBox is not checked");
            }
        }
    }

    @Override
    public void onBackPressed(){
        Intent intent =new Intent();
        intent.putExtra("data_return","Hello firstActivity");
        setResult(RESULT_OK,intent);
        finish();
    }
}
