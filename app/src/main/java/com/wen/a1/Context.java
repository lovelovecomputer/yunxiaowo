package com.wen.a1;

import android.app.Application;

/**
 * Created by asus1 on 2018/5/2.
 */

public class Context extends Application {
    private String n;

    public void onCreate(){
        //初始化字符串
        n = "name";
    }

    public String getN() {
        return n;
    }

    public void setN(String n) {
        this.n = n;
    }
}
