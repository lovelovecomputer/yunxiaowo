package com.wen.a1;

import android.content.ContentValues;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.AlertDialog;

public class Login extends Activity {

    private static final String DATABASE_NAME="yunxiaowo.db"; //数据库名称
    private static final int DATABASE_VERSION=1;//数据库版本号
    private static final String TABLE_NAME="username";  //表名

    private DatebaseHelper databaseHelper;
    private SQLiteDatabase db;
    private Button button1;
    private EditText nameText,passText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.login);

        databaseHelper=new DatebaseHelper(Login.this,DATABASE_NAME,null,DATABASE_VERSION);
        db =  databaseHelper.getReadableDatabase();
        ContentValues values = new ContentValues();
        ContentValues va = new ContentValues();

        va.put("number","5101");
        va.put("building","5号楼");
        va.put("room","101室");
        va.put("beds","6");
        va.put("orientation","阳");
        db.insert("room",null,va);
        values.clear();

        va.put("number","5102");
        va.put("building","5号楼");
        va.put("room","102室");
        va.put("beds","6");
        va.put("orientation","阴");
        db.insert("room",null,va);

        va.put("number","5103");
        va.put("building","5号楼");
        va.put("room","103室");
        va.put("beds","6");
        va.put("orientation","阳");
        db.insert("room",null,va);

        va.put("number","5104");
        va.put("building","5号楼");
        va.put("room","104室");
        va.put("beds","6");
        va.put("orientation","阴");
        db.insert("room",null,va);

        va.put("number","5105");
        va.put("building","5号楼");
        va.put("room","105室");
        va.put("beds","6");
        va.put("orientation","阳");
        db.insert("room",null,va);

        va.put("number","5106");
        va.put("building","5号楼");
        va.put("room","106室");
        va.put("beds","6");
        va.put("orientation","阴");
        db.insert("room",null,va);

        va.put("number","5107");
        va.put("building","5号楼");
        va.put("room","107室");
        va.put("beds","6");
        va.put("orientation","阳");
        db.insert("room",null,va);

        va.put("number","5108");
        va.put("building","5号楼");
        va.put("room","108室");
        va.put("beds","6");
        va.put("orientation","阴");
        db.insert("room",null,va);

        va.put("number","5109");
        va.put("building","5号楼");
        va.put("room","109室");
        va.put("beds","6");
        va.put("orientation","阳");
        db.insert("room",null,va);

        values.put("name","admin");
        values.put("password","admin");
        db.insert(TABLE_NAME,null,values);
        values.clear();

        values.put("name","赵晓梅");
        values.put("password","123456");
        values.put("sex","女");
        values.put("department","计算机系");
        values.put("major","计算机科学与技术");
        db.insert(TABLE_NAME,null,values);

        values.put("name","宋佳");
        values.put("password","123456");
        values.put("sex","女");
        values.put("department","计算机系");
        values.put("major","计算机科学与技术");
        db.insert(TABLE_NAME,null,values);

        values.put("name","王飞");
        values.put("password","123456");
        values.put("sex","男");
        values.put("department","计算机系");
        values.put("major","计算机科学与技术");
        db.insert(TABLE_NAME,null,values);

        values.put("name","何光");
        values.put("password","123456");
        values.put("sex","男");
        values.put("department","计算机系");
        values.put("major","计算机科学与技术");
        db.insert(TABLE_NAME,null,values);

        values.put("name","唐飞");
        values.put("password","123456");
        values.put("sex","男");
        values.put("department","计算机系");
        values.put("major","计算机科学与技术");
        db.insert(TABLE_NAME,null,values);

        values.put("name","王亚");
        values.put("password","123456");
        values.put("sex","女");
        values.put("department","计算机系");
        values.put("major","物联网工程");
        db.insert(TABLE_NAME,null,values);

        values.put("name","李明");
        values.put("password","123456");
        values.put("sex","男");
        values.put("department","计算机系");
        values.put("major","物联网工程");
        db.insert(TABLE_NAME,null,values);


        nameText=(EditText)findViewById(R.id.username);
        passText=(EditText)findViewById(R.id.pasw);

        button1=(Button)findViewById(R.id.tijiao);
        button1.setOnClickListener(new LoginListener());

        //启动修改信息页面
        TextView textview=(TextView)findViewById(R.id.change);
        textview.setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent a=new Intent(Login.this,Change.class);
                startActivity(a);
            }

        });

        //启动随便看看页面
        TextView textview1=(TextView)findViewById(R.id.look);
        textview1.setOnClickListener(new OnClickListener(){

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent a=new Intent(Login.this,Dormitory.class);
                startActivity(a);
            }

        });
    }


    class LoginListener implements OnClickListener{
        public void onClick(View v){
            String nameString =nameText.getText().toString();
            String passString =passText.getText().toString();
           //将用户名设置为全局变量，方便每个页面使用
            final Context app = (Context)getApplication();
            app.setN(nameString);

            if(nameString.equals("")||passString.equals(""))
            {
                //弹出消息框
                new AlertDialog.Builder(Login.this).setTitle("错误")
                        .setMessage("帐号或密码不能空").setPositiveButton("确定", null)
                        .show();
            }
            else if(nameString.equals("admin")&&passString.equals("admin")){
                        Intent a=new Intent(Login.this,Admin.class);
                        startActivity(a);
            }else {
                isUserinfo(nameString,passString);
            }
        }
    }

    public Boolean isUserinfo(final String name, String pass)
    {
        final String nameString=name;
        String passString=pass;
        databaseHelper=new DatebaseHelper(Login.this,DATABASE_NAME,null,DATABASE_VERSION);
        db =  databaseHelper.getReadableDatabase();
        try{
            Cursor cursor=db.query(TABLE_NAME, new String[]{"name","password"},"name=?",new String[]{nameString},null,null,"password");
            while(cursor.moveToNext())
            {
                String password=cursor.getString(cursor.getColumnIndex("password"));
                if(passString.equals(password))
                {
                    new AlertDialog.Builder(Login.this).setTitle("正确")
                            .setMessage("成功登录").setPositiveButton("确定", new DialogInterface.OnClickListener() {

                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // TODO Auto-generated method stub
                            //点击确定后只显示该用户的信息
                            Intent intent=new Intent(Login.this,Personal.class);
                            intent.putExtra("name",nameString);
                            startActivity(intent);
                        }
                    }).show();

                    break;
                }
                else
                {
                    Toast.makeText(this, "用户名密码不正确",Toast.LENGTH_LONG).show();
                    break;
                }
            }

        }catch(SQLiteException e){
            CreatTable();
        }
        return false;
    }

    private void CreatTable() {
        // TODO Auto-generated method stub
        String sql = "CREATE TABLE IF NOT EXISTS " + TABLE_NAME
                + " (name varchar(30) primary key,password varchar(30)," +
                "sex varchar(30),department varchar(30),major varchar(30),number varchar(30));";
        try{
            db.execSQL(sql);
        }catch(SQLException ex){}
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


}