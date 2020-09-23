package com.example.jkhana.Groceries;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jkhana.R;
import com.example.jkhana.fastfood.FoodData;
import com.example.jkhana.fastfood.TabAdapter;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

public class Groceries extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<FoodData> Foodlist;
    FoodData modelImage;
    LinearLayoutManager linearLayoutManager;
    public String imgurl;
    final String url = "https://poolnepal.000webhostapp.com/fetchffooddata.php";
    GloceAdapter adapter;
    RecyclerView mrecycler;
    private ActionBar toolbar;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groceries);

        ImageSlider imgslider = (ImageSlider) findViewById(R.id.slidergloceries);
        List<SlideModel> slide1 = new ArrayList<>();
        slide1.add(new SlideModel(R.drawable.grocerie,"Gloceries"));
        slide1.add(new SlideModel(R.drawable.vejroll,"VejRoll"));
        slide1.add(new SlideModel(R.drawable.img,"Gloceries"));
        slide1.add(new SlideModel(R.drawable.streetfood,"StreetFood"));
        imgslider.setImageList(slide1,true)  ;


        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Vegetables", Tabg_1.class)
                .add("Dairy Products", Tabg_2.class)
                .add("Kariyana Products", Tabg_3.class)

                .create());

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Vegetable"));
        tabLayout.addTab(tabLayout.newTab().setText("Dairy Products"));
        tabLayout.addTab(tabLayout.newTab().setText("Kariyana products"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final com.example.jkhana.fastfood.TabAdapter tabadapter = new TabAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
        viewPager.setAdapter(tabadapter);

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());


            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });



    }
}
