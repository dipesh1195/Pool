package com.example.jkhana.dinner;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
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

public class Dinner extends AppCompatActivity {
    private ActionBar toolbar;
    ArrayList<FoodData> Foodlist;
    FoodData modelImage;
    LinearLayoutManager linearLayoutManager;
    TabLayout tabLayout;
    ViewPager viewPager;
    public String imgurl;
    final String url = "https://poolnepal.000webhostapp.com/fetchffooddata.php";


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dinner);
        FragmentPagerItemAdapter adapter = new FragmentPagerItemAdapter(
                getSupportFragmentManager(), FragmentPagerItems.with(this)
                .add("Dinner", Tabd_1.class)
                .add("second Tab", Tabd_2.class)
                .add("Thirt tab", Tabd_3.class)

                .create());

        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        tabLayout.addTab(tabLayout.newTab().setText("Dinner"));
        tabLayout.addTab(tabLayout.newTab().setText("tab2"));
        tabLayout.addTab(tabLayout.newTab().setText("tab3"));
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
        ImageSlider imgslider = (ImageSlider) findViewById(R.id.sliderfood);
        List<SlideModel> slide = new ArrayList<>();
        slide.add(new SlideModel(R.drawable.grocerie,"Gloceries"));
        slide.add(new SlideModel(R.drawable.vejroll,"VejRoll"));
        slide.add(new SlideModel(R.drawable.img,"Gloceries"));
        slide.add(new SlideModel(R.drawable.streetfood,"StreetFood"));
        imgslider.setImageList(slide,true)  ;
    }
}
