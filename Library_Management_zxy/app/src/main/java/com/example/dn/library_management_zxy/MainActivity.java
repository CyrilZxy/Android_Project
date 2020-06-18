package com.example.dn.library_management_zxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建库 同时建表
        Button createDatabase=(Button) findViewById(R.id.button1);
        createDatabase.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                LitePal.getDatabase();
            }
        });



        //添加数据
        Button addData=(Button) findViewById(R.id.button2);
        addData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Book book1=new Book();
                book1.setName("第一行代码Android");
                book1.setAuthor("郭霖");
                book1.setPages(570);
                book1.setPrice(79.00);
                book1.setPress("人民邮电出版社");
                book1.save();

                Book book2=new Book();
                book2.setName("Android开发与应用");
                book2.setAuthor("张荣");
                book2.setPages(275);
                book2.setPrice(45.00);
                book2.setPress("未知");
                book2.save();
            }
        });


        //更新数据
        Button updateData=(Button) findViewById(R.id.button3);
        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                //更新价格和出版社
                Book book=new Book();
                book.setPrice(40.00);
                book.setPress("人民邮电出版社");
                book.updateAll("name=? and author=?","Android开发与应用","张荣");  //类似于where

                /*
                //更新价格—只能对已存储的数据进行更新
                Book book=new Book();
                book.setName("昆虫记");
                book.setAuthor("达尔文");
                book.setPages(314);
                book.setPrice(28.80);
                book.setPress("内蒙古人民出版社");
                book.save();
                book.setPrice(20.00);
                book.save();
                */
            }
        });




        //删除数据
        Button deleteData=(Button) findViewById(R.id.button4);
        deleteData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DataSupport.deleteAll(Book.class,"price < ?","50");
            }
        });


        //查询数据
        Button queryData=(Button) findViewById(R.id.button5);
        queryData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                List<Book> books= DataSupport.findAll(Book.class);
                //查询所有book，并打印信息
                for(Book book:books){
                    Log.d("MainActivity","book name is"+book.getName());
                    Log.d("MainActivity","book author is"+book.getAuthor());
                    Log.d("MainActivity","book pages is"+book.getPages());
                    Log.d("MainActivity","book price is"+book.getPrice());
                    Log.d("MainActivity","book press is"+book.getPress());
                }
            }
        });


    }


}
