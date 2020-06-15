package com.example.dn.zxyapplication_06;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final MyDatabaseHelper dbHelper=new MyDatabaseHelper(this,"BookStore.db",null,1);

        //建库+建表
        Button createDatabase=(Button) findViewById(R.id.button1);
        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                dbHelper.getWritableDatabase();
            }
        });


        //添加数据
        Button addData=(Button) findViewById(R.id.button2);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                final SQLiteDatabase db=dbHelper.getWritableDatabase();
                ContentValues values=new ContentValues();

                //组合第一条数据
                values.put("name","THEAndroid_1");
                values.put("price","79.00");
                values.put("pages","570");
                values.put("author","GuoLin");
                db.insert("Book",null,values);      //插入第一条数据
                values.clear();

                //组合第二条数据
                values.put("name","THEAndroid_2");
                values.put("price","45.00");
                values.put("pages","275");
                values.put("author","ZR");
                db.insert("Book",null,values);      //插入第二条数据
                //values.clear();

            }
        });
    }








}
