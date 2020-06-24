package com.example.dn.zxyapplication_06;

import android.app.Application;


/**
 * Created by DN on 2020/6/24.
 */

public class MyApplication extends Application {
    private UtilDao dao;

    /**
     * 创建时调用
     * */
    @Override
    public void onCreate() {
        super.onCreate();
        dao = new UtilDao(this);
    }

    /**
     * 后台进程终止，前台程序需要内存时调用此方法，用于释放内存
     * 用于关闭数据库连接
     * */
    @Override
    public void onLowMemory() {
        super.onLowMemory();
        dao.getClose();
    }

    public UtilDao getDao() {
        return dao;
    }
}
