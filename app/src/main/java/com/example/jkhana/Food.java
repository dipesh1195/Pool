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

public class Food extends AppCompatActivity {
    private ActionBar toolbar;
    FoodAdapter adapter;
    List<FoodData> Foodlist = new ArrayList();
    RecyclerView mrecycler;
    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 300;
    final long PERIOD_MS = 2000;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
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
        supportActionBar.setTitle((CharSequence) "PooL FastFood ");
        mrecycler = (RecyclerView) findViewById(R.id.recyclerG);
        mrecycler.setLayoutManager(new GridLayoutManager(this, 1));
        String str = "Groceries";
        String str2 = "best in categories";
        String str3 = "500";
        FoodData mFoodData = new FoodData(str, str2, str3, R.drawable.grocerie);
        FoodData mFoodData1 = new FoodData(str, str2, str3, R.drawable.img);
        FoodData mFoodData2 = new FoodData(str, str2, str3, R.drawable.fastffood);
        FoodData mFoodData3 = new FoodData(str, str2, str3, R.drawable.streetfood);
        FoodData mFoodData4 = new FoodData(str, str2, str3, R.drawable.vejroll);
        this.Foodlist.add(mFoodData);
        this.Foodlist.add(mFoodData1);
        this.Foodlist.add(mFoodData2);
        this.Foodlist.add(mFoodData3);
        this.Foodlist.add(mFoodData4);
        FoodAdapter foodAdapter = new FoodAdapter(this, this.Foodlist);
        this.adapter = foodAdapter;
        this.mrecycler.setAdapter(foodAdapter);

    }
}
