package com.example.jkhana;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
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
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class Login_activity extends AppCompatActivity {
    /* access modifiers changed from: protected */
    TextView signup;
    EditText user,pass;
    String str_email,str_password;
    Button login;
    String url = "http://poolnepal.000webhostapp.com/login.php";
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_activity);
        signup = (TextView) findViewById(R.id.login);
        user = (EditText) findViewById(R.id.email);
        pass = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.sign_in);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(user.getText().toString().equals("")){
                    Toast.makeText(Login_activity.this, "Enter Email", Toast.LENGTH_SHORT).show();
                }
                else if(pass.getText().toString().equals("")){
                    Toast.makeText(Login_activity.this, "Enter Password", Toast.LENGTH_SHORT).show();
                }
                else{


                    final ProgressDialog progressDialog = new ProgressDialog(Login_activity.this);
                    progressDialog.setMessage("Please Wait..");

                    progressDialog.show();

                    str_email = user.getText().toString().trim();
                    str_password = pass.getText().toString().trim();


                    StringRequest request = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            progressDialog.dismiss();
                            if (response.equalsIgnoreCase("logged in successfully")){

                                user.setText("");
                                pass.setText("");
                                startActivity(new Intent(Login_activity.this, MainActivity.class));
                                Toast.makeText(Login_activity.this, response, Toast.LENGTH_SHORT).show();
                            }
                            else{
                                Toast.makeText(Login_activity.this, response, Toast.LENGTH_SHORT).show();
                            }

                        }
                    },new Response.ErrorListener(){

                        @Override
                        public void onErrorResponse(VolleyError error) {
                            progressDialog.dismiss();
                            Toast.makeText(Login_activity.this, "Error "+error.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }

                    ){
                        @Override
                        protected Map<String, String> getParams() throws AuthFailureError {
                            Map<String,String> params = new HashMap<String, String>();
                            params.put("email",str_email);
                            params.put("password",str_password);
                            return params;

                        }
                    };

                    RequestQueue requestQueue = Volley.newRequestQueue(Login_activity.this);
                    requestQueue.add(request);




                }
            }

            public void moveToRegistration(View view) {
                startActivity(new Intent(Login_activity.this,Signup_activity.class));
                finish();
            }

        });
    }
}

