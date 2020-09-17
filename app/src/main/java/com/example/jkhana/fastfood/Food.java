package com.example.jkhana.fastfood;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.jkhana.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Food extends AppCompatActivity {
    RecyclerView recyclerView;
    FoodAdapter myAdapter;
    List<FoodData> Foodlist;
    FoodData modelImage;
    LinearLayoutManager linearLayoutManager;
    public String imgurl;
  final String url = "https://poolnepal.000webhostapp.com/fetchffooddata.php";
    /* access modifiers changed from: protected */
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        ImageSlider imgslider = (ImageSlider) findViewById(R.id.sliderfood);
        List<SlideModel> slide = new ArrayList<>();
        slide.add(new SlideModel(R.drawable.grocerie,"Gloceries"));
        slide.add(new SlideModel(R.drawable.vejroll,"VejRoll"));
        slide.add(new SlideModel(R.drawable.img,"Gloceries"));
        slide.add(new SlideModel(R.drawable.streetfood,"StreetFood"));
        imgslider.setImageList(slide,true)  ;


        recyclerView = (RecyclerView) findViewById(R.id.recyclerG);
        linearLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(linearLayoutManager);
        Foodlist = new ArrayList<>();
        myAdapter = new FoodAdapter(this,Foodlist);
        recyclerView.setAdapter(myAdapter);

        fetchImages();


    }

    public void fetchImages(){

        StringRequest request = new StringRequest(Request.Method.POST,url,new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            String succes = jsonObject.getString("success");

                            JSONArray jsonArray = jsonObject.getJSONArray("data");

                            if(succes.equals("1")){
                                for(int i=0;i<jsonArray.length();i++){
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name");
                                    String desc = object.getString("description");
                                    int price = object.getInt("price");
                                    String imageurl= object.getString("picture");
                                    imageurl = imageurl.trim();
                                    String restuname = object.getString("resturant");
                                    imgurl ="https://poolnepal.000webhostapp.com/upload/".concat(imageurl) ;
                                    Toast.makeText(Food.this, imgurl, Toast.LENGTH_SHORT).show();
                                    modelImage = new FoodData(name,desc,price,imgurl,restuname);
                                    Foodlist.add(modelImage);
                                    myAdapter.notifyDataSetChanged();
                                }
                            }



                        } catch (JSONException e) {
                            e.printStackTrace();
                        }


                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(Food.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(request);


    }
}

