package com.wen.a1;

import java.util.ArrayList;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


/**
 * Created by asus1 on 2018/4/28.
 */

public class RDelete  extends Activity{
    private static final String DATABASE_NAME="yunxiaowo.db"; //数据库名称
    private static final int DATABASE_VERSION=1;//数据库版本号
    private static final String TABLE_NAME="room";  //表名

    List<Room> roomList,list;
    private DatebaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.rdelete);

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
            Room r = new Room(number,buil,room,beds,ori);
            list.add(r);
        }

        //把数据显示到屏幕
        ListView lv = (ListView) findViewById(R.id.lv);
        ArrayAdapter ad = new ArrayAdapter<Room>(this,android.R.layout.simple_list_item_1,list);
        lv.setAdapter(ad);

        //长按每个Item
        lv.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, final View view, final int i, long l) {
                new AlertDialog.Builder(RDelete.this).setTitle("提示")
                        .setMessage("确认删除？").setPositiveButton("确定", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub

                        databaseHelper=new DatebaseHelper(RDelete.this,DATABASE_NAME,null,DATABASE_VERSION);
                        db =  databaseHelper.getReadableDatabase();
                        Room info = list.get(i);
                        String n = info.getNumber();
                        db.execSQL("delete from room where number = ?",new String[]{n});
                        Toast.makeText(RDelete.this, "删除成功！", Toast.LENGTH_LONG).show();

                    }
                }).show();
                return true;
            }
        });
        

    }
}
