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

public class SInsert extends Activity {
    private EditText edittext1,edittext2,edittext3,edittext4,edittext5,edittext6;
    private Button button;
    private DatebaseHelper databaseHelper;
    //数据库名称
    private static final String DATABASE_NAME="yunxiaowo.db";
    //数据库版本号
    private static final int DATABASE_VERSION=1;

    private static final String TABLE_NAME="username";
    private SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.sinsert);
        edittext1=(EditText)findViewById(R.id.editview1);
        edittext2=(EditText)findViewById(R.id.editview2);
        edittext3=(EditText)findViewById(R.id.editview3);
        edittext4=(EditText)findViewById(R.id.editview4);
        edittext5=(EditText)findViewById(R.id.editview5);
        edittext6=(EditText)findViewById(R.id.editview6);


        button=(Button)findViewById(R.id.tijiao);
        button.setOnClickListener(new OnClickListener(){


            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String namestring = edittext1.getText().toString();
                String passstring = edittext2.getText().toString();
                String repassstring =edittext3.getText().toString();
                String sexstring = edittext4.getText().toString();
                String depstring = edittext5.getText().toString();
                String majstring = edittext6.getText().toString();

                if(passstring.equals(repassstring))
                {
                    databaseHelper=new DatebaseHelper(SInsert.this,DATABASE_NAME,null,DATABASE_VERSION);
                    db =  databaseHelper.getReadableDatabase();
                    db.execSQL("insert into username (name,password,sex,department,major) values(?,?,?,?,?)",new String[]{namestring,passstring,sexstring,depstring,majstring});

                    Toast.makeText(SInsert.this, "添加成功！", Toast.LENGTH_LONG).show();
                    Intent b=new Intent(SInsert.this,Admin.class);
                    startActivity(b);
                }
                else
                {
                    Toast.makeText(SInsert.this,"两次密码不一致", Toast.LENGTH_LONG).show();
                }
            }

        });
    }


}