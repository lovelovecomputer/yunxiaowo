package com.wen.a1;

/**
 * Created by asus1 on 2018/5/3.
 */

public class MemoryUtil {
    public boolean isRefreshMain = false;
    private static MemoryUtil mMs ;
    public static MemoryUtil Ms = MemoryUtil.getIntance();

    private static MemoryUtil getIntance(){
        if(mMs ==null)  mMs = new MemoryUtil();
        return mMs;
    }

    public static void clearMomery(){
        mMs = null;
    }
}
