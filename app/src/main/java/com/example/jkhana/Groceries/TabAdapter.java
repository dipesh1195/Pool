package com.example.jkhana.Groceries;

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
                Tabg_1 tab1 = new Tabg_1();
                return tab1;
            case 1:
                Tabg_2 tab2 = new Tabg_2();
                return tab2;
            case 2:
                Tabg_3 tab3 = new Tabg_3();
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
