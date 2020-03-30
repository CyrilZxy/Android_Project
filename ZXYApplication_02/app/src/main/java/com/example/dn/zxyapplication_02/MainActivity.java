package com.example.dn.zxyapplication_02;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class
        MainActivity extends AppCompatActivity {

    public MainActivity() {


    }

    private ArrayList<CheckBox> favs;                //定义一个存放爱好中复选框的对象favs
    private EditText NAME;                      // 布局各组件对象
    private EditText PASSWORD;
    private EditText PHONE;
    private Spinner DEPT;
    private RadioGroup SEX;
    private RadioButton MAN;
    private RadioButton WOMAN;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //获取个组件对象
        NAME=(EditText)findViewById(R.id.name);
        PASSWORD=(EditText)findViewById(R.id.password);
        PHONE=(EditText)findViewById(R.id.phone);
        SEX=(RadioGroup)findViewById(R.id.sex);
        DEPT=(Spinner)findViewById(R.id.dept);
        MAN=(RadioButton)findViewById(R.id.man);
        WOMAN=(RadioButton)findViewById(R.id.woman);
        favs=new ArrayList<CheckBox>();
        CheckBox book=(CheckBox) findViewById(R.id.book);
        CheckBox sport=(CheckBox) findViewById(R.id.sport);
        CheckBox music=(CheckBox) findViewById(R.id.music);
        CheckBox movie=(CheckBox) findViewById(R.id.movie);
        favs.add(book);
        favs.add(sport);
        favs.add(music);
        favs.add(movie);

    }



    public String getSex(){
        RadioButton radioButton= (RadioButton)findViewById(SEX.getCheckedRadioButtonId());
        if(radioButton!=null) {
            return radioButton.getText().toString();
        }else {
            return "Not Selected";
        }
    }

    public String getFavorite()
    {
        String favo="";
        for(CheckBox cb:favs){
            if(cb.isChecked()){
                favo+=cb.getText().toString();
                favo+=",";
            }
        }
        if(!"".equals(favo))
            favo=favo.substring(0,favo.length()-1);
        else
            favo="您未选择爱好！";
        return favo;
    }

    public void myclick(View view){
        //if (true){
        StringBuilder sb =new StringBuilder();
        sb.append("用户名: "+NAME.getText().toString()+"\n");
        Log.v("name", "done");
        sb.append("性别: " + getSex() + "\n");
        Log.v("sex", "done");
        sb.append("电话: "+PHONE.getText().toString()+"\n");
        Log.v("tel","done");
        sb.append("部门: "+DEPT.getSelectedItem().toString()+"\n");
        Log.v("part","done");
        sb.append("爱好: "+getFavorite()+"\n");
        Log.v("fav","done");
        Toast.makeText(this, sb.toString(), Toast.LENGTH_LONG).show();
//        Toast.makeText(this, "Test", Toast.LENGTH_LONG).show();

       Intent intent = new Intent();
        intent.setClass(this, ResultActivity.class);
        intent.putExtra("info", sb.toString());
        this.startActivity(intent);
        //}
    }

}


