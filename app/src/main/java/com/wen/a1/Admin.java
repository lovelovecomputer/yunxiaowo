package com.wen.a1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by asus1 on 2018/5/2.
 */

public class Admin extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin);

        Button button1,button2,button3,button4;

        button1=(Button)findViewById(R.id.SInsert);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Admin.this,SInsert.class);
                startActivity(a);
            }
        });

        button2=(Button)findViewById(R.id.RInsert);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Admin.this,RInsert.class);
                startActivity(a);
            }
        });

        button3=(Button)findViewById(R.id.SDelete);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Admin.this,SDelete.class);
                startActivity(a);
            }
        });

        button4=(Button)findViewById(R.id.RDelete);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Admin.this,RDelete.class);
                startActivity(a);
            }
        });

        button4=(Button)findViewById(R.id.back);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Admin.this,Login.class);
                startActivity(a);
            }
        });

    }
}
