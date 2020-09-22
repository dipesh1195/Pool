package com.example.jkhana.fastfood;

import android.graphics.Color;
import android.os.Bundle;
import android.view.animation.Animation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.viewpager.widget.ViewPager;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jkhana.R;
import com.example.jkhana.dinner.Tabg_1;
import com.example.jkhana.dinner.Tabg_2;
import com.example.jkhana.dinner.Tabg_3;
import com.google.android.material.tabs.TabLayout;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItemAdapter;
import com.ogaclejapan.smarttablayout.utils.v4.FragmentPagerItems;

import java.util.ArrayList;
import java.util.List;

public class Food extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    ArrayList<FoodData> Foodlist;
    FoodData modelImage;
    LinearLayoutManager linearLayoutManager;
    public String imgurl;
  final String url = "https://poolnepal.000webhostapp.com/fetchffooddata.php";
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("FastFood", Tabg_1.class)
                .add("second Tab", Tabg_2.class)
                .add("Thirt tab", Tabg_3.class)

                .create());

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("FastFood"));
        tabLayout.addTab(tabLayout.newTab().setText("tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("tab3"));
        tabLayout.setTabGravity(TabLayout.GRAVITY_FILL);

        final TabAdapter tabadapter = new TabAdapter(this, getSupportFragmentManager(), tabLayout.getTabCount());
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
    
        ImageSlider imgslider = (ImageSlider) findViewById(R.id.sliderfood);
        List<SlideModel> slide = new ArrayList<>();
        slide.add(new SlideModel(R.drawable.grocerie,"Gloceries"));
        slide.add(new SlideModel(R.drawable.vejroll,"VejRoll"));
        slide.add(new SlideModel(R.drawable.img,"Gloceries"));
        slide.add(new SlideModel(R.drawable.streetfood,"StreetFood"));
        imgslider.setImageList(slide,true)  ;
    }



}

