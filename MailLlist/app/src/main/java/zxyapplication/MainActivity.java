package com.example.dn.zxyapplication_06;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    public MainActivity() {


    }

    private EditText NAME;                              //布局各组件对象
    private EditText PASSWORD;
    private ArrayList<CheckBox> chose;                  //定义一个存放爱好中复选框的对象chose

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        NAME=(EditText)findViewById(R.id.name);                     //获取个组件对象
        PASSWORD=(EditText)findViewById(R.id.password);


    }

    //登录按钮响应
    public void myclick(View view){
        //if (true){
            //StringBuilder sb = new StringBuilder();
            //sb.append("登录我的通讯录成功!"+"\n");
            //sb.append("用户名：" + NAME.getText().toString()+"      ");
            //sb.append("密码:" + PASSWORD.getText().toString());
            Toast.makeText(this, "正在登录...", Toast.LENGTH_LONG).show();

            if(NAME.getText().toString().equals("zxy") && PASSWORD.getText().toString().equals("123")){
                Intent intent = new Intent();                       //登录到ResultActivity页面
                intent.setClass(this, ResultActivity.class);
                //intent.putExtra("info", sb.toString());
                this.startActivity(intent);

            }else{
                Toast.makeText(this, "账号或密码错误 请重试", Toast.LENGTH_LONG).show();
            }

        //}
    }



}
