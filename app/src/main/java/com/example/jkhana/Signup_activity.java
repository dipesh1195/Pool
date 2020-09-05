package com.example.jkhana;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class Signup_activity extends AppCompatActivity {
    EditText con_password;
    EditText email;
    ImageButton facebook_signup;
    ImageButton google_signup;
    TextView haveaccount;
    TextView login;
    TextView more;
    EditText name;
    EditText password;
    EditText phone;
    ImageView profile_pic;
    Button signup;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int)  R.layout.activity_signup_activity);
        this.signup = (Button) findViewById( R. id.signup);
        this.facebook_signup = (ImageButton) findViewById( R. id.facebook_signup);
        this.google_signup = (ImageButton) findViewById( R. id.google_signup);
        ImageView imageView = (ImageView) findViewById( R. id.profilepic);
        this.profile_pic = imageView;
        imageView.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Signup_activity.this.profile_pic.setImageResource( R.drawable.my_bg);
            }
        });
        this.signup.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Toast.makeText(Signup_activity.this, "SignUp Failed Database not Connected", 0).show();
            }
        });
    }
}
