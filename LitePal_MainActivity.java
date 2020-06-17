package com.example.dn.library_management_zxy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;

import org.litepal.LitePal;
import org.litepal.crud.DataSupport;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //建库 建表
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
                Book book=new Book();
                book.setName("第一行代码Android");
                book.setAuthor("郭霖");
                book.setPages(570);
                book.setPrice(79.00);
                book.setPress("人民邮电出版社");
                book.save();
            }
        });


        //更新数据
        Button updateData=(Button) findViewById(R.id.button3);
        updateData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){

                /*
                //更新价格—已存储的数据
                Book book=new Book();
                book.setName("Android开发与应用");
                book.setAuthor("张荣");
                book.setPages(275);
                book.setPrice(45.00);
                book.setPress("未知");
                book.save();
                book.setPrice(40.00);
                book.save();
                */

                //更新价格和出版社
                Book book=new Book();
                book.setPrice(35.00);
                book.setPress("人民邮电出版社");
                book.updateAll("name=? and author=?","Android开发与应用","张荣");
            }
        });




        //删除数据
        Button delectData=(Button) findViewById(R.id.button4);
        delectData.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DataSupport.deleteAll(Book.class,"price < ?","40");
            }
        });


    }


}
