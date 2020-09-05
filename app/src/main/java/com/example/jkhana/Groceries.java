package com.example.jkhana;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class Groceries extends AppCompatActivity {
    GloceAdapter adapter;
    List<GroceriesData> glocerieList = new ArrayList();
    RecyclerView mrecycler;
    private ActionBar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);
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
