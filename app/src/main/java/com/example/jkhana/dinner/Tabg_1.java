package com.example.jkhana.dinner;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.jkhana.R;
import com.example.jkhana.fastfood.FoodAdapter;
import com.example.jkhana.fastfood.FoodData;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Tabg_1 extends Fragment {
    RecyclerView recyclerView;
    FoodAdapter myAdapter;
    TabLayout tabLayout;
    ProgressDialog progressDialog;
    ViewPager viewPager;
    ArrayList<FoodData> Foodlist;
    FoodData modelImage;
    LinearLayoutManager linearLayoutManager;
    public String imgurl;
    final String url = "https://poolnepal.000webhostapp.com/fetchffooddata.php";

    public Tabg_1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.tablayout_home, container, false);

        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerG);
        linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);
        Foodlist = new ArrayList<>();
        myAdapter = new FoodAdapter(getContext(),Foodlist);
        recyclerView.setAdapter(myAdapter);


        fetchImages();

        return v;
    }
    public void fetchImages(){
        progressDialog = new ProgressDialog(getActivity());
        progressDialog.setMessage("" +
                "Please Wait!! Getting Menu For U");
        progressDialog.show();
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
                            modelImage = new FoodData(name,desc,price,imgurl,restuname);
                            Foodlist.add(modelImage);
                            myAdapter.notifyDataSetChanged();
                            progressDialog.dismiss();

                        }
                    }



                } catch (JSONException e) {

                    e.printStackTrace();

                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                progressDialog.dismiss();
                Toast.makeText(getActivity(), "Something went Wrong", Toast.LENGTH_SHORT).show();
            }
        });

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        requestQueue.add(request);


    }
}
