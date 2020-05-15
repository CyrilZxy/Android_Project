package com.example.dn.zxyapplication_05;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DN on 2020/5/14.
 */

public class ForgetPassActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);

        TextView forget = (TextView) findViewById(R.id.forget);
        forget.setText("\n"+"\n"+"MainActivity传送内容如下:\n\n" +this.getIntent().getStringExtra("info"));

    }

    public void forgetclick(View view){
        Intent intent = new Intent();   //忘记密码到MainActivity页面
        intent.setClass(this, MainActivity.class);
        this.startActivityForResult(intent, 0x111);
    }




}
