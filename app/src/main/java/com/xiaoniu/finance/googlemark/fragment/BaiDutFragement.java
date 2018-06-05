package com.xiaoniu.finance.googlemark.fragment;

import android.view.View;

import com.xiaoniu.finance.googlemark.base.LoadDataFragment;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/6/5
 */

public class BaiDutFragement extends LoadDataFragment {

    @Override
    protected View itemSuccessView() {
        return null;
    }

    @Override
    public int requestData() {
        return 1;
    }


}
