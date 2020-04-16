package com.example.dn.zxyapplication_03;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import android.view.View;
import android.os.Message;
import android.os.Handler;

public class MainActivity extends AppCompatActivity{

    private ImageView imageView;
    private ProgressBar progressBar;
    private TextView pbtext;
    private Handler myHandler;
    private int pvalue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pbtext=(TextView)findViewById(R.id.pbText);
        Button button=(Button) findViewById(R.id.button);
        progressBar=(ProgressBar) findViewById(R.id.pb);
        imageView=(ImageView) findViewById(R.id.image);

        //在自定义Handler类中，重写handleMessage（）方法
        //通过Message的值更新进度和提示信息
        myHandler=new Handler(){
            @Override
            public void handleMessage(Message msg){
                progressBar.setProgress(msg.arg1);                                //将进度条进度更新到msg.arg1的值
                pbtext.setText("正在下载中...("   +msg.arg1+  "%)"  );           //更新提示信息
                if(msg.what==0x222){
                    //msg==100，弹出提示信息“下载完成”
                    Toast.makeText(MainActivity.this,"下载完成", Toast.LENGTH_SHORT).show();
                    //msg==100，将图片设置为显示
                    imageView.setVisibility(View.VISIBLE);
                }
            }
        };



    }




    public void myClick(View view){
        imageView.setVisibility(View.GONE);                 //set初识状态和初始值
        progressBar.setVisibility(View.VISIBLE);
        progressBar.setProgress(0);

        new Thread(new Runnable() {
            @Override
            public void run() {
                pvalue=0;
                while(true){
                    pvalue+=(int)(Math.random()*10);
                    try{
                        Thread.sleep(100);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                    Message mes=new Message();
                    if(pvalue<100){
                        mes.arg1=pvalue;
                        mes.what=0x111;
                        myHandler.sendMessage(mes);
                    }else{
                        mes.arg1=100;
                        mes.what=0x222;
                        myHandler.sendMessage(mes);
                        break;
                    }
                }

            }
        }).start();

    }



}

