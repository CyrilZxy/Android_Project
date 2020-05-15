package com.example.dn.zxyapplication_05;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by DN on 2020/5/14.
 */

public class RegisterActivity extends MainActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        TextView register = (TextView) findViewById(R.id.register);
        register.setText("\n"+"\n"+"MainActivity传送内容如下:\n\n" +this.getIntent().getStringExtra("info"));

    }



    public void registerclick(View view){
        Intent intent = new Intent();                   //注册账号到MainActivity页面
        intent.setClass(this, MainActivity.class);
        this.startActivityForResult(intent, 0x111);
    }



}
