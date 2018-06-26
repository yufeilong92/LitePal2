package com.xuechuan.refiterxjava.LitePalApplication;

import android.app.Application;

import org.litepal.LitePal;

/**
 * @version V 1.0 xxxxxxxx
 * @Title: RefiteRxjava
 * @Package com.xuechuan.refiterxjava.LitePalApplication
 * @Description: todo
 * @author: L-BackPacker
 * @date: 2018/6/26 14:49
 * @verdescript 版本号 修改时间  修改人 修改的概要说明
 * @Copyright: 2018
 */
public class LitePalApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        LitePal.initialize(this);
    }
}
