package com.wen.a1;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


/**
 * Created by asus1 on 2018/4/28.
 */

public class SDelete extends Activity{
    private static final String DATABASE_NAME="yunxiaowo.db"; //数据库名称
    private static final int DATABASE_VERSION=1;//数据库版本号
    private static final String TABLE_NAME="username";  //表名

    List<User> userList;
    private DatebaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sdelete);

        databaseHelper = new DatebaseHelper(this,DATABASE_NAME,null,DATABASE_VERSION);
        userList = new ArrayList<User>();

        db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            String name = cursor.getString(cursor.getColumnIndex("name"));
            String pass = cursor.getString(cursor.getColumnIndex("password"));
            String sex = cursor.getString(cursor.getColumnIndex("sex"));
            String dep= cursor.getString(cursor.getColumnIndex("department"));
            String maj= cursor.getString(cursor.getColumnIndex("major"));
            int num = cursor.getInt(cursor.getColumnIndex("number"));
            User p = new User(name,pass,sex,dep,maj,num);
            userList.add(p);
        }

        //把数据显示到屏幕
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter ad = new ArrayAdapter<User>(this,android.R.layout.simple_list_item_1,userList);
        lv.setAdapter(ad);


        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int i, long l) {
                new AlertDialog.Builder(SDelete.this).setTitle("提示")
                        .setMessage("确认删除？").setPositiveButton("确定", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                        databaseHelper=new DatebaseHelper(SDelete.this,DATABASE_NAME,null,DATABASE_VERSION);
                        db =  databaseHelper.getReadableDatabase();
                        User info = userList.get(i);
                        String na = info.getName();
                        db.execSQL("delete from username where name = ?",new String[]{na});
                        Toast.makeText(SDelete.this, "删除成功！", Toast.LENGTH_LONG).show();

                    }
                }).show();
                return true;
            }
        });

    }
}
