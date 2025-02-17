package com.example.jkhana.dinner;

import android.content.Context;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;


public class TabAdapter extends FragmentPagerAdapter {

    private Context myContext;
    int totalTabs;

    public TabAdapter(Context context, FragmentManager fm, int totalTabs) {
        super(fm);
        myContext = context;
        this.totalTabs = totalTabs;
    }

    // this is for fragment tabs
    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                Tabd_1 tab1 = new Tabd_1();
                return tab1;
            case 1:
                Tabd_2 tabg2 = new Tabd_2();
                return tabg2;
            case 2:
                Tabd_3 tab3 = new Tabd_3();
                return tab3;
            default:
                return null;
        }
    }
    // this counts total number of tabs
    @Override
    public int getCount() {

        return totalTabs;
    }
}
