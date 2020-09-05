package com.example.jkhana;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.navigation.ui.AppBarConfiguration;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView.OnNavigationItemSelectedListener;

public class MainActivity extends AppCompatActivity {
    private ImageView dimage;
    private TextView dinner;
    private TextView fastfood;
    private ImageView fimag;
    Fragment fragment = null;
    private ImageView frimag;
    private TextView fruits;
    private ImageView gimag;
    private TextView grocerie;
    private ImageView liimag;
    private ImageView limag;
    private TextView liqueur;
    private TextView lunch;
    private AppBarConfiguration mAppBarConfiguration;
    private OnNavigationItemSelectedListener mOnNavigationItemSelectedListener = new OnNavigationItemSelectedListener() {
        public boolean onNavigationItemSelected(MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home :
                     toolbar.setTitle("PooL");
                     fragment = new HomeFragment();
                    break;
                case R.id.navigation_kart :
                     toolbar.setTitle("Kart");
                     fragment = new KartFragment();
                    break;
                case R.id.navigation_profile /*2131230950*/:
                     toolbar.setTitle("Profile");
                     fragment = new ProfileFragment();
                    break;
                case R.id.navigation_search /*2131230951*/:
                     toolbar.setTitle("Search");
                     fragment = new SearchFragment();
                    break;
            }
             getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, fragment).commit();
            return true;
        }
    };
    private ImageView nimag;
    private TextView nonveg;
    public ActionBar toolbar;


    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((BottomNavigationView) findViewById(R.id.nav_view)).setOnNavigationItemSelectedListener(this.mOnNavigationItemSelectedListener);
        getSupportFragmentManager().beginTransaction().replace(R.id.nav_host_fragment, new HomeFragment()).commit();
        grocerie = (TextView) findViewById(R.id.groceriestext);
        fastfood = (TextView) findViewById(R.id.fastfoodtext);
        lunch = (TextView) findViewById(R.id.lunchtext);
        nonveg = (TextView) findViewById(R.id.nonvegtext);
        dinner = (TextView) findViewById(R.id.dinnertext);
        liqueur = (TextView) findViewById(R.id.liqueurtext);
        fruits = (TextView) findViewById(R.id.fruitstext);
        gimag = (ImageView) findViewById(R.id.groceries);
        fimag = (ImageView) findViewById(R.id.fastfood);
        limag = (ImageView) findViewById(R.id.lunch);
        nimag = (ImageView) findViewById(R.id.nonveg);
        dimage = (ImageView) findViewById(R.id.dinner);
        liimag = (ImageView) findViewById(R.id.liqueur);
        frimag = (ImageView) findViewById(R.id.fruits);
        LinearLayout li = (LinearLayout) findViewById(R.id.linergloc);
        LinearLayout food = (LinearLayout) findViewById(R.id.linearfood);
        LinearLayout lun = (LinearLayout) findViewById(R.id.linearlunch);
        LinearLayout non = (LinearLayout) findViewById(R.id.linearnonveg);
        LinearLayout dinn = (LinearLayout) findViewById(R.id.lineardinner);
        LinearLayout lique = (LinearLayout) findViewById(R.id.linearliqueur);
        LinearLayout frui = (LinearLayout) findViewById(R.id.linearfruits);
        toolbar = getSupportActionBar();
        li.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Groceries.class));
                Toast.makeText(MainActivity.this, "Moving to groceries", Toast.LENGTH_SHORT).show();
            }
        });
        food.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Food.class));
                Toast.makeText(MainActivity.this, "Moving to FastFood", Toast.LENGTH_SHORT).show();
            }
        });
        lun.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Lunch.class));
                Toast.makeText(MainActivity.this, "Moving to Lunch", Toast.LENGTH_SHORT).show();
            }
        });
        non.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Nonveg.class));
                Toast.makeText(MainActivity.this, "Moving to NonVeg", Toast.LENGTH_SHORT).show();
            }
        });
        dinn.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Dinner.class));
                Toast.makeText(MainActivity.this, "Moving to Dinner",Toast.LENGTH_SHORT ).show();

            }
        });
        lique.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Liqueurs.class));
                Toast.makeText(MainActivity.this, "Moving to Liqueurs", Toast.LENGTH_SHORT).show();
            }
        });
        frui.setOnClickListener(new OnClickListener() {
            public void onClick(View v) {
                 startActivity(new Intent(MainActivity.this, Fruits.class));
                Toast.makeText(MainActivity.this, "Moving to Fruits", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
