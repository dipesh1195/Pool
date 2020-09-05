package com.example.jkhana;

import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Groceries extends AppCompatActivity {
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 300;
    final long PERIOD_MS = 2000;
    GloceAdapter adapter;
    List<GroceriesData> glocerieList = new ArrayList();
    RecyclerView mrecycler;
    private ActionBar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
        final ViewPager mViewPager = (ViewPager) findViewById(R.id.viewPage);
        ImageAdapter adapterView = new ImageAdapter(this);
        mViewPager.setAdapter(adapterView);
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == adapter.getItemCount()-1) {
                    currentPage = 0;
                }
                mViewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer.schedule(new TimerTask() { // task to be scheduled
            @Override
            public void run() {
                handler.post(Update);
            }
        }, DELAY_MS, PERIOD_MS);

        ActionBar supportActionBar = getSupportActionBar();
        this.toolbar = supportActionBar;
        supportActionBar.setTitle((CharSequence) "PooL groceries");
        mrecycler = (RecyclerView) findViewById(R.id.recyclerG);
        mrecycler.setLayoutManager(new GridLayoutManager(this, 1));
        String str = "Groceries";
        String str2 = "best in categories";
        String str3 = "500";
        GroceriesData mGroceriesData = new GroceriesData(str, str2, str3, R.drawable.grocerie);
        GroceriesData mGroceriesData1 = new GroceriesData(str, str2, str3, R.drawable.liqueurs);
        GroceriesData mGroceriesData2 = new GroceriesData(str, str2, str3, R.drawable.fastffood);
        GroceriesData mGroceriesData3 = new GroceriesData(str, str2, str3, R.drawable.grocerie);
        GroceriesData mGroceriesData4 = new GroceriesData(str, str2, str3, R.drawable.grocerie);
        this.glocerieList.add(mGroceriesData);
        this.glocerieList.add(mGroceriesData1);
        this.glocerieList.add(mGroceriesData2);
        this.glocerieList.add(mGroceriesData3);
        this.glocerieList.add(mGroceriesData4);
        GloceAdapter gloceAdapter = new GloceAdapter(this, this.glocerieList);
        this.adapter = gloceAdapter;
        this.mrecycler.setAdapter(gloceAdapter);
    }
}
