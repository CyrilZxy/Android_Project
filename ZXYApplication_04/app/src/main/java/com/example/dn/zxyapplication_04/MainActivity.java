package com.example.dn.zxyapplication_04;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private CharSequence[] items={"Hope-xxxTENTACION","派大星-PO8",
            "bad guy-Billie Eilish", "陷阱历险记-Lil Jet","again-timmies"};

    public void myclick(View view){
        boolean[] itemsChecked=new boolean[items.length];
        AlertDialog.Builder builder=new AlertDialog.Builder(MainActivity.this);
        builder.setIcon(R.drawable.music);
        builder.setTitle("多选对话框");

        builder.setMultiChoiceItems(items,itemsChecked,
                new DialogInterface.OnMultiChoiceClickListener(){

                @Override
                public void onClick(DialogInterface dialog,int which,boolean isChecked){
                    Toast.makeText(getApplicationContext(),items[which]+"被选中了！",
                                    Toast.LENGTH_LONG).show();
                }
        });


        builder.setPositiveButton("确定",null);
        builder.setNegativeButton("取消",null);
        builder.create().show();


    }
}
