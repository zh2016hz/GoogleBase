package com.xiaoniu.finance.googlemark;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.WindowManager;

import com.xiaoniu.finance.googlemark.base.BaseFragment;
import com.xiaoniu.finance.googlemark.fragment.ALiFragement;
import com.xiaoniu.finance.googlemark.fragment.BaiDutFragement;
import com.xiaoniu.finance.googlemark.fragment.TecentFragement;
import com.xiaoniu.finance.googlemark.manager.FragmentManager;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager;
    private TabLayout mTabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        }

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mViewPager = findViewById(R.id.viewPager);
        mTabLayout = findViewById(R.id.tabLayout);

        mViewPager.setAdapter(mFragmentPagerAdapter);
    }

    /**
     * 第二种方案：使用FragmentPagerStateAdapter  这个适合页面较多，系统默认不做缓存，然后，自己做缓存
     */
    private FragmentStatePagerAdapter mFragmentPagerAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager()) {
        public static final String TAG = "getItem";
        private BaseFragment mFragment;

        @Override
        public Fragment getItem(int position) {
            Log.e(TAG, "getItem: " + position);

            BaseFragment fragment = FragmentManager.getFragment(position);
            if (fragment != null) {
                Log.e(TAG, "getItem: 获取缓存   fragment" );
                mFragment = fragment;
            } else {
                switch (position) {
                    case 0:
                        mFragment = new TecentFragement();
                        break;
                    case 1:
                        mFragment = new BaiDutFragement();
                        break;
                    case 2:
                        mFragment = new ALiFragement();
                        break;
                }
                Log.e(TAG, "getItem: 创建新的fragment" );
                FragmentManager.addFragment(position, mFragment);
            }
            return mFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    };




    /*private FragmentPagerAdapter  mFragmentPagerAdapter =  new FragmentPagerAdapter(getSupportFragmentManager()) {

        public static final String TAG = "getItem" ;
        private Fragment mFragment;

        @Override
        public Fragment getItem(int position) {
            Log.e(TAG, "getItem: " + position );
            switch (position){
                case 0:
                    mFragment = new TecentFragement();
                    break;
                case 1:
                    mFragment = new BaiDutFragement();
                    break;
                case 2:
                    mFragment = new ALiFragement();
                break;
            }
            return mFragment;
        }

        @Override
        public int getCount() {
            return 3;
        }
    };*/
}
