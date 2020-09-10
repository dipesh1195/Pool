package com.example.jkhana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Login_activity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    TextView signup;
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        signup = (TextView) findViewById(R.id.login);
        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login_activity.this,Signup_activity.class);
                startActivity(intent);
            }
        });

    }
}
