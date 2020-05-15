package com.example.dn.zxyapplication_05;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
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

        chose=new ArrayList<CheckBox>();                            //获取复选框组件对象
        CheckBox box1=(CheckBox) findViewById(R.id.checkBox1);
        CheckBox box2=(CheckBox) findViewById(R.id.checkBox2);
        CheckBox box3=(CheckBox) findViewById(R.id.checkBox3);
        chose.add(box1);
        chose.add(box2);
        chose.add(box3);

    }

    //登录按钮响应
    public void myclick(View view){
        //if (true){
            StringBuilder sb = new StringBuilder();

            sb.append("登录成功!"+"\n"+"\n"+"\n");
            sb.append("用户名：" + NAME.getText().toString()+"\n"+"\n");
            sb.append("密码:" + PASSWORD.getText().toString()+"\n"+"\n");
            sb.append("登陆选项: "+getCheck()+"\n");

            Toast.makeText(this, "正在登录...", Toast.LENGTH_LONG).show();

            Intent intent = new Intent();                       //登录到ResultActivity页面
            intent.setClass(this, ResultActivity.class);
            intent.putExtra("info", sb.toString());
            this.startActivity(intent);
        //}
    }

    //复选框get内容
    public String getCheck()
    {
        StringBuilder strChoose=new StringBuilder("");
        for(CheckBox cb:chose){
            if(cb.isChecked()){
                strChoose.append(cb.getText().toString()+" ");
            }
        }
        String str=strChoose.toString();
        if(!"".equals(str))
            str=str.substring(0,strChoose.length()-1);
        else
            str="默认登陆";
        return str;
    }




    //忘记密码按钮响应
    public void forgetPass(View view){
        StringBuilder sb = new StringBuilder();
        sb.append("忘记密码！！！");

        Intent intent = new Intent();                               //忘记密码到PassActivity页面
        intent.setClass(this, ForgetPassActivity.class);
        intent.putExtra("info", sb.toString());
        this.startActivity(intent);
    }




    //注册账号按钮响应
    public void register(View view){
        StringBuilder sb = new StringBuilder();
        sb.append("注册账号！！！");

        Intent intent = new Intent();                           //注册到RegisterActivity页面
        intent.setClass(this, RegisterActivity.class);
        intent.putExtra("info", sb.toString());
        this.startActivity(intent);
    }

}
