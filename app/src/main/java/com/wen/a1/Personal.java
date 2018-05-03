package com.wen.a1;


import java.util.ArrayList;
import java.util.List;

import android.content.ContentValues;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;


/**
 * Created by asus1 on 2018/4/28.
 */

public class Personal extends Activity{

    private static final String DATABASE_NAME="yunxiaowo.db"; //数据库名称
    private static final int DATABASE_VERSION=1;//数据库版本号
    private static final String TABLE_NAME="username";  //表名

    List<Student> personList;
    private Button button;
    private DatebaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle saveInstanceStates){
        super.onCreate(saveInstanceStates);
        setContentView(R.layout.personal);

        Intent intent = this.getIntent();
        databaseHelper = new DatebaseHelper(this,DATABASE_NAME,null,DATABASE_VERSION);
        personList = new ArrayList<Student>();
        String a = intent.getExtras().getString("name");

        db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,"name = ?",new String[]{a},null,null,null,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            String department = cursor.getString(cursor.getColumnIndex("department"));
            String major = cursor.getString(cursor.getColumnIndex("major"));
            int number = cursor.getInt(cursor.getColumnIndex("number"));
            Student p=new Student( name, sex, department, major, number);
            personList.add(p);
        }
        //把数据显示到屏幕
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter ad = new ArrayAdapter<Student>(this,android.R.layout.simple_list_item_1,personList);
        lv.setAdapter(ad);

        button=(Button)findViewById(R.id.shenqing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent a=new Intent(Personal.this,Dormitory.class);
                startActivity(a);
            }
        });
    }
}
