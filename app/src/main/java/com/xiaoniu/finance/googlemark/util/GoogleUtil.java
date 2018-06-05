package com.xiaoniu.finance.googlemark.util;

import android.content.Context;
import android.os.Handler;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/6/5
 */

public class GoogleUtil {
    private Context mContext;
    private Handler mHandler;

    public  void init(Context context) {
        mContext = context;
    }

    private Handler getHandler(){
        mHandler = new Handler();
        return mHandler;
    }
}
