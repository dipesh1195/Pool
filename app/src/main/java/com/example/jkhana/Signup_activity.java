package com.example.jkhana;

import android.media.Image;
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
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.Response.ErrorListener;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.w3c.dom.Text;

import java.util.HashMap;
import java.util.Map;

public class Signup_activity extends AppCompatActivity {
    EditText email,con_password,name,password,phone,address;
    ImageButton facebook_signup,google_signup;
    TextView login,more,haveaccount;
    ImageView profile_pic;
    Button signup;
    String url = "http://poolnepal.000webhostapp.com/register.php";
    String str_name,str_email,str_password,str_cpassword,str_phone,str_address;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView((int)  R.layout.activity_signup_activity);
        email = (EditText) findViewById(R.id.email);
        name = (EditText) findViewById(R.id.fullname);
        password = (EditText) findViewById(R.id.password);
        con_password = (EditText) findViewById(R.id.confirm_password);
        phone = (EditText) findViewById(R.id.number);
        address = (EditText) findViewById(R.id.address);
        facebook_signup = (ImageButton) findViewById(R.id.facebook_signup);
        google_signup = (ImageButton) findViewById(R.id.google_signup);
        login = (TextView) findViewById(R.id.login);
        haveaccount = (TextView) findViewById(R.id.account);
        more = (TextView) findViewById(R.id.more);
        profile_pic = (ImageView) findViewById(R.id.profilepic);
        signup = (Button) findViewById(R.id.signup);

        signup.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {

                final ProgressDialog progressDialog = new ProgressDialog(Signup_activity.this);
                progressDialog.setMessage("Please Wait..");


                if(name.getText().toString().equals("")){
                    Toast.makeText(Signup_activity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                }
                else if(email.getText().toString().equals("")){
                    Toast.makeText(Signup_activity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if(password.getText().toString().equals("")){
                    Toast.makeText(Signup_activity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else if(con_password.getText().toString().equals("")){
                    Toast.makeText(Signup_activity.this, "Enter confirm Password", Toast.LENGTH_SHORT).show();

              if(!password.equals(con_password)) {
                  Toast.makeText(Signup_activity.this, "Password and Confirm Password Don't Match", Toast.LENGTH_SHORT).show();
              }
                }
                else if(phone.getText().toString().equals("")){
                    Toast.makeText(Signup_activity.this, "Enter Phone Number", Toast.LENGTH_SHORT).show();
                }
                else if(address.getText().toString().equals("")){
                    Toast.makeText(Signup_activity.this, "Enter Address", Toast.LENGTH_SHORT).show();
                }
                else{

                    progressDialog.show();
                    str_name = name.getText().toString().trim();
                     str_email = email.getText().toString().trim();
                    str_password = password.getText().toString().trim();
                     str_phone = phone.getText().toString().trim();
                     str_address = address.getText().toString().trim();


                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            name.setText("");
                            email.setText("");
                            password.setText("");
                            con_password.setText("");
                            phone.setText("");
                            address.setText("");
                            startActivity(new Intent(Signup_activity.this, Login_activity.class));
                            Toast.makeText(Signup_activity.this, response, Toast.LENGTH_SHORT).show();
                        }
                    },new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(Signup_activity.this,"Error" + error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    }

                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();

                            params.put("name",str_name);
                            params.put("email",str_email);
                            params.put("phone",str_phone);
                            params.put("password",str_password);
                            params.put("address",str_address);
                            return params;

                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(Signup_activity.this);
                    requestQueue.add(request);


                }





            }
        });



    }
}
