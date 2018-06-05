package com.xiaoniu.finance.googlemark;

import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.xiaoniu.finance.googlemark.fragment.ALiFragement;
import com.xiaoniu.finance.googlemark.fragment.BaiDutFragement;
import com.xiaoniu.finance.googlemark.fragment.TecentFragement;

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

    private FragmentPagerAdapter  mFragmentPagerAdapter =  new FragmentPagerAdapter(getSupportFragmentManager()) {

        private Fragment mFragment;

        @Override
        public Fragment getItem(int position) {
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
    };
}
