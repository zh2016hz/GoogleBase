package com.xiaoniu.finance.googlemark.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.xiaoniu.finance.googlemark.base.LoadDataFragment;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/6/5
 */

public class ALiFragement extends LoadDataFragment {


    @Override
    protected View itemSuccessView() {

        TextView textView = new TextView(getContext());
        textView.setText("ha哈哈哈.我市 埃里");
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            textView.setBackground(new ColorDrawable(Color.GREEN));
        }
        return textView;
    }

    @Override
    public int requestData() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return 4;
    }




}
