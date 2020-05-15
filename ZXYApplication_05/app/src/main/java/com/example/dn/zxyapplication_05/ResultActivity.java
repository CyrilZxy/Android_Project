package com.example.dn.zxyapplication_05;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by DN on 2020/5/14.
 */

public class ResultActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        TextView result = (TextView) findViewById(R.id.result);
        result.setText("\n"+"\n"+"MainActivity传送内容如下:\n\n" +this.getIntent().getStringExtra("info"));

    }

}
