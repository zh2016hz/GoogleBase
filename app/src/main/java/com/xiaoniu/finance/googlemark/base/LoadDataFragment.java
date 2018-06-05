package com.xiaoniu.finance.googlemark.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xiaoniu.finance.googlemark.weiget.LoadView;

/**
 * 文件描述：
 * Created by  xn069392
 * 创建时间    2018/6/5
 */

public  abstract class LoadDataFragment extends BaseFragment {

    private LoadView mLoadView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mLoadView = new LoadView(getContext()) {
            @Override
            protected View onLoadSuccessView() {
                return itemSuccessView();
            }

            @Override
            public int getDataDetail() {

                return requestData();
            }
        };

        return mLoadView;
    }

    protected abstract View itemSuccessView();

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mLoadView.loadData();
    }
    public abstract  int requestData();
}
