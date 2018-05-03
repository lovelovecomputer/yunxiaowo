package com.wen.a1;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by asus1 on 2018/4/30.
 */

public class DetailDor extends Activity {

    private static final String DATABASE_NAME="yunxiaowo.db"; //数据库名称
    private static final int DATABASE_VERSION=1;//数据库版本号

    private DatebaseHelper databaseHelper;
    private SQLiteDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detaildor);

        final Context app = (Context)getApplication();
        final String a = app.getN();

        Bundle bundle=getIntent().getExtras();
        TextView tv1=(TextView) findViewById(R.id.num);
        final String num=bundle.getString("number");
        tv1.setText("编号："+num);

        TextView tv2=(TextView) findViewById(R.id.build);
        final String build=bundle.getString("building");
        tv2.setText("楼栋号："+build);

        TextView tv3=(TextView) findViewById(R.id.room);
        final String room=bundle.getString("room");
        tv3.setText("宿舍号："+room);

        TextView tv4=(TextView) findViewById(R.id.beds);
        final String beds=bundle.getString("beds");
        tv4.setText("床位数："+beds);

        TextView tv5=(TextView) findViewById(R.id.ori);
        String ori=bundle.getString("orientation");
        tv5.setText("朝向："+ori);

        Button button = (Button)findViewById(R.id.shenqing);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(DetailDor.this).setTitle("提示")
                        .setMessage("确认选择？").setPositiveButton("确定", new DialogInterface.OnClickListener(){
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // TODO Auto-generated method stub
                        // 点击确定后将表room中beds的值减1（更新）
                            databaseHelper=new DatebaseHelper(DetailDor.this,DATABASE_NAME,null,DATABASE_VERSION);
                            db =  databaseHelper.getReadableDatabase();
                            db.execSQL("update room set beds = beds - 1 where number = ?",new String[]{num});
                            db.execSQL("update username set number = ? where name = ?",new String[]{num,a});
                            Toast.makeText(DetailDor.this, "选房成功！", Toast.LENGTH_LONG).show();

                    }
                }).show();
            }
        });
    }
}
