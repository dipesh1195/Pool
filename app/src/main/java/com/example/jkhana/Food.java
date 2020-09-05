package com.example.jkhana;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Food extends AppCompatActivity {
    private ActionBar toolbar;
    FoodAdapter adapter;
    List<FoodData> Foodlist = new ArrayList();
    RecyclerView mrecycler;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        ActionBar supportActionBar = getSupportActionBar();
        this.toolbar = supportActionBar;
        supportActionBar.setTitle((CharSequence) "PooL FastFood ");
        mrecycler = (RecyclerView) findViewById(R.id.recyclerG);
        mrecycler.setLayoutManager(new GridLayoutManager(this, 1));
        String str = "Groceries";
        String str2 = "best in categories";
        String str3 = "500";
        FoodData mFoodData = new FoodData(str, str2, str3, R.drawable.grocerie);
        FoodData mFoodData1 = new FoodData(str, str2, str3, R.drawable.liqueurs);
        FoodData mFoodData2 = new FoodData(str, str2, str3, R.drawable.fastffood);
        FoodData mFoodData3 = new FoodData(str, str2, str3, R.drawable.grocerie);
        FoodData mFoodData4 = new FoodData(str, str2, str3, R.drawable.grocerie);
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
