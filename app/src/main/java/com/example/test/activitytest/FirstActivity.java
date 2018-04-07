package com.example.test.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TimePicker;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private RadioGroup radioGroup;
    private RadioButton wButton;
    private RadioButton mButton;

    private TimePicker tp;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"Yout clicked Add",Toast.LENGTH_SHORT).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"Yout clicked Remove",Toast.LENGTH_SHORT).show();
                break;
            default:
        }
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.first_layout);
        Button button1=(Button) findViewById(R.id.button_1);
        for (int counter = 0; counter < 10; counter++) {
            Log.i("FirstActivity","value "+counter);
        }

        Button button_bd=(Button) findViewById(R.id.button_baidu);

        Button button_phone=(Button) findViewById(R.id.button_phone);

        radioGroup = (RadioGroup) findViewById(R.id.radioGroupId);
        wButton=(RadioButton) findViewById(R.id.radioidf);
        mButton=(RadioButton) findViewById(R.id.radioidm);

        RadioGroupListener rg=new RadioGroupListener();
        radioGroup.setOnCheckedChangeListener(rg);

        tp=(TimePicker) findViewById(R.id.timePicker);
        tp.setIs24HourView(true);
        TimePickListener timePickListener=new TimePickListener();
        tp.setOnTimeChangedListener(timePickListener);


//        RadioButtonListener rb=new RadioButtonListener();
//        wButton.setOnCheckedChangeListener(rb);

//        iv1=(ImageView) findViewById(R.id.imageViewId1);
//        iv2=(ImageView) findViewById(R.id.imageViewId2);

//        iv1.setScaleType(ImageView.ScaleType.CENTER);



        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
               int hour = tp.getCurrentHour();
                int minute= tp.getCurrentMinute();
                Toast.makeText(FirstActivity.this,"hout "+hour + " minute "+minute,
                        Toast.LENGTH_SHORT).show();
                // finish();

                Intent intent = new Intent(FirstActivity.this,SecondActivity.class);
                intent.putExtra("extra_data","data");
                startActivityForResult(intent,1);

//                Intent intent =new Intent("com.example.activitytest.ACTION_START");
//                intent.addCategory("com.example.activitytest.MY_CATEGORY");
//                startActivity(intent);

//                Intent intent =new Intent(Intent.ACTION_VIEW);
//                intent.setData(Uri.parse("http://www.baidu.com"));
//                startActivity(intent);
            }
        });

        button_bd.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });

        button_phone.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent =new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:10086"));
                startActivity(intent);
            }
        });
    }

    class RadioGroupListener implements RadioGroup.OnCheckedChangeListener{

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i==wButton.getId()){
                Toast.makeText(FirstActivity.this,"女",Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(FirstActivity.this,"男",Toast.LENGTH_SHORT).show();
            }
        }
    }

//    class RadioButtonListener implements CompoundButton.OnCheckedChangeListener{
//
//        @Override
//        public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
//            Toast.makeText(FirstActivity.this,"女"+b,Toast.LENGTH_SHORT).show();
//        }
//    }

    class TimePickListener implements TimePicker.OnTimeChangedListener{

        @Override
        public void onTimeChanged(TimePicker timePicker, int hour, int minute) {
            Toast.makeText(FirstActivity.this,"hour "+hour+" minute "+minute,Toast.LENGTH_SHORT).show();
        }
    }

    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch(requestCode){
            case 1:
                if (resultCode == RESULT_OK){
                    String returnedData = data.getStringExtra("data_return");
                    Log.d("FirstActivity", returnedData);
                    Toast.makeText(FirstActivity.this,"return "+returnedData,Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }

}
