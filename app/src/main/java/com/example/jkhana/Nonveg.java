package com.example.jkhana;

import android.os.Bundle;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class Nonveg extends AppCompatActivity {
    private ActionBar toolbar;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nonveg);
        ActionBar supportActionBar = getSupportActionBar();
        this.toolbar = supportActionBar;
        supportActionBar.setTitle((CharSequence) "PooL NonVeg ");
    }
}
