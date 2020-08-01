package com.example.dn.zxyapplication_06;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;



/**
 * Created by DN on 2020/6/15.
 */

public class DatabaseUtil extends SQLiteOpenHelper{                         //建表


    private static final String DATABASE_NAME = "PhoneBook.db";  //数据库名
    private static final int DATABASE_VERSION = 1;               //数据库版本号

    public DatabaseUtil(Context context){
        super(context,DATABASE_NAME,null,DATABASE_VERSION);
    }

    //创建数据
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        createTable(sqLiteDatabase);
    }

    //建立数据表

    private void createTable(SQLiteDatabase db){
        db.execSQL("create table UserInfo(" +
                "id integer primary key autoincrement," +
                "userName text," +
                "userPhone text)");
    }

    //升级数据库
    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }


}
