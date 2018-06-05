package com.xiaoniu.finance.googlemark.weiget;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

import com.xiaoniu.finance.googlemark.R;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/6/5
 */

public abstract class LoadView extends FrameLayout {


    private final Context context;
    private View mError;
    private View mLoad;
    private View mEmpty;
    private  int currentState = 0;
    private View mSuccess;
    private Handler mHandler =  new Handler();
    public LoadView(@NonNull Context context) {
        this(context,null);
    }

    public LoadView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context  =  context;
        init();
    }

    private void init() {
        mError = LayoutInflater.from(context).inflate(R.layout.error_layout, null);
        addView(mError);
        mLoad = LayoutInflater.from(context).inflate(R.layout.loading_layout, null);
        addView(mLoad);
        mEmpty = LayoutInflater.from(context).inflate(R.layout.empty_layout, null);
        addView(mEmpty);
        checkStatus();
    }

    private void checkStatus() {
        mError.setVisibility(currentState == 1 ? VISIBLE:GONE);
        mLoad.setVisibility(currentState == 2 ? VISIBLE:GONE);
        mEmpty.setVisibility(currentState == 3 ? VISIBLE:GONE);

        if(currentState ==4 && mSuccess == null){
            mSuccess= onLoadSuccessView();
            addView(mSuccess);
        }
        if(mSuccess != null){
            mSuccess.setVisibility(currentState == 4 ? VISIBLE:GONE);
        }
    }

    protected abstract View onLoadSuccessView();

    /**
     *  加载数据
     */
    public void loadData() {
        currentState = 2;
        checkStatus();
        new Thread(new Runnable() {
            @Override
            public void run() {
                currentState =getDataDetail();
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        checkStatus();
                    }
                });
            }
        }).start();
    }

    public   abstract  int getDataDetail() ;
}
