package com.wen.a1;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RInsert extends Activity {
    private EditText edittext1,edittext2,edittext3,edittext4,edittext5;
    private Button button;
    private DatebaseHelper databaseHelper;
    //数据库名称
    private static final String DATABASE_NAME="yunxiaowo.db";
    //数据库版本号
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="room";
    private SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.rinsert);
        edittext1=(EditText)findViewById(R.id.editview1);
        edittext2=(EditText)findViewById(R.id.editview2);
        edittext3=(EditText)findViewById(R.id.editview3);
        edittext4=(EditText)findViewById(R.id.editview4);
        edittext5=(EditText)findViewById(R.id.editview5);

        button=(Button)findViewById(R.id.tj);
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String string1 = edittext1.getText().toString();
                String string2 = edittext2.getText().toString();
                String string3 = edittext3.getText().toString();
                String string4 = edittext4.getText().toString();
                String string5 = edittext5.getText().toString();

                databaseHelper=new DatebaseHelper(RInsert.this,DATABASE_NAME,null,DATABASE_VERSION);
                db =  databaseHelper.getReadableDatabase();
                db.execSQL("insert into room(number,building,room,beds,orientation) values(?,?,?,?,?)",new String[]{string1,string2,string3,string4,string5});

                Toast.makeText(RInsert.this, "添加成功！", Toast.LENGTH_LONG).show();
                Intent b=new Intent(RInsert.this,Admin.class);
                startActivity(b);

            }

        });
    }


}