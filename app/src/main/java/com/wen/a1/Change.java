package com.wen.a1;

/**
 * Created by asus1 on 2018/4/29.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Change extends Activity {
    private EditText nameText,edittext1,edittext2,edittext3;
    private Button button;
    private DatebaseHelper databaseHelper;

    private static final String DATABASE_NAME="yunxiaowo.db";  //数据库名称
    private static final int DATABASE_VERSION=1;  //数据库版本号
    private static final String TABLE_NAME="username";//表名

    private SQLiteDatabase db;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.change);

        nameText=(EditText)findViewById(R.id.username);
        edittext1=(EditText)findViewById(R.id.editview1);
        edittext2=(EditText)findViewById(R.id.editview2);
        edittext3=(EditText)findViewById(R.id.editview3);

        button=(Button)findViewById(R.id.chongzhi);
        button.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                String nameString =nameText.getText().toString();
                String oldpassstring= edittext1.getText().toString();
                String newpassstring = edittext2.getText().toString();
                String repassstring=edittext3.getText().toString();
                databaseHelper=new DatebaseHelper(Change.this,DATABASE_NAME,null,DATABASE_VERSION);
                db =  databaseHelper.getReadableDatabase();
                Cursor cursor=db.query(TABLE_NAME, new String[]{"name","password"},"name=?",new String[]{nameString},
                        null,null,"password");
                    while(cursor.moveToNext())
                    {
                        String password=cursor.getString(cursor.getColumnIndex("password"));
                        if(oldpassstring.equals(password)){
                            if(newpassstring.equals(repassstring))
                            {
                                db.execSQL("update username set password = ? ",new String[]{newpassstring});
                                Toast.makeText(Change.this, "修改成功！", Toast.LENGTH_LONG).show();
                                Intent b=new Intent(Change.this,Login.class);
                                startActivity(b);
                            }
                            else
                            {
                                Toast.makeText(Change.this,"两次密码不一致", Toast.LENGTH_LONG).show();
                            }
                        }
                        else
                        {
                            Toast.makeText(Change.this,"原始密码不正确", Toast.LENGTH_LONG).show();
                        }
                    }
            }
        });
    }
}
