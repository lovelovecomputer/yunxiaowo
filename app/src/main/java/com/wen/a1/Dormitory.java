package com.wen.a1;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;


/**
 * Created by asus1 on 2018/4/28.
 */

public class Dormitory  extends Activity{
    private static final String DATABASE_NAME="yunxiaowo.db"; //数据库名称
    private static final int DATABASE_VERSION=1;//数据库版本号
    private static final String TABLE_NAME="room";  //表名

    List<Room> roomList,list;
    private DatebaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dormitory);

        databaseHelper = new DatebaseHelper(this,DATABASE_NAME,null,DATABASE_VERSION);
        roomList = new ArrayList<Room>();
        list = new ArrayList<Room>();

        db = databaseHelper.getWritableDatabase();
        Cursor cursor = db.query(TABLE_NAME,null,null,null,null,null,null);
        while (cursor.moveToNext()) {
            String number = cursor.getString(cursor.getColumnIndex("number"));
            String buil = cursor.getString(cursor.getColumnIndex("building"));
            String room = cursor.getString(cursor.getColumnIndex("room"));
            String beds= cursor.getString(cursor.getColumnIndex("beds"));
            String ori = cursor.getString(cursor.getColumnIndex("orientation"));
            Room p = new Room(number, beds);
            roomList.add(p);
            Room r = new Room(number,buil,room,beds,ori);
            list.add(r);
        }

        //把数据显示到屏幕
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter ad = new ArrayAdapter<Room>(this,android.R.layout.simple_list_item_1,roomList);
        lv.setAdapter(ad);

        //点击每一个Item
        lv.setOnItemClickListener( new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
                Bundle bundle = new Bundle();
                Room info = list.get(arg2);
                bundle.putString("number",info.getNumber());
                bundle.putString("building",info.getBuilding());
                bundle.putString("room",info.getRoom());
                bundle.putString("beds",info.getBeds());
                bundle.putString("orientation",info.getOrientation());
                Intent intent = new Intent();
                intent.putExtras(bundle);//将之前的bundle参数传进去
                intent.setClass(Dormitory.this, DetailDor.class);
                startActivity(intent);
            }
        });


    }
}
