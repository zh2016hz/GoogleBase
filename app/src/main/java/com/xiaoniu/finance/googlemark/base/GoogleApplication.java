package com.xiaoniu.finance.googlemark.base;

import android.app.Application;

import com.xiaoniu.finance.googlemark.util.GoogleUtil;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/6/5
 */

public class GoogleApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        GoogleUtil googleUtil = new GoogleUtil();
        googleUtil.init(getApplicationContext());
    }
}
