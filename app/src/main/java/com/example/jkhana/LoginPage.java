package com.example.jkhana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class LoginPage extends AppCompatActivity {
    Button login;
    ImageView logo;
    Button register;
    TextView skip;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);
        login = (Button) findViewById(R.id.login);
        register = (Button) findViewById(R.id.register);
        skip = (TextView) findViewById(R.id.skip);
        logo = (ImageView) findViewById(R.id.logo);
        getSupportActionBar().hide();

        skip.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, MainActivity.class));
            }
        });
        register.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, Signup_activity.class));
            }
        });
        login.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                startActivity(new Intent(LoginPage.this, Login_activity.class));
            }
        });
    }
}
