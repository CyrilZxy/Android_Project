package com.example.dn.zxyapplication_02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.TextView;

/**
 * Created by DN on 2020/3/30.
 */


public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_result);

        TextView result = (TextView) findViewById(R.id.result);

        result.setText("从前一页面传来如下：\n\n" + this.getIntent().getStringExtra("info"));

    }
}
