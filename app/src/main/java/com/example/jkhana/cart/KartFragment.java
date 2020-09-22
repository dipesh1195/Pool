package com.example.jkhana.cart;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jkhana.R;
import com.example.jkhana.fastfood.FoodAdapter;
import com.example.jkhana.fastfood.FoodData;
import com.example.jkhana.fastfood.abd;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class KartFragment extends Fragment {
    RecyclerView recyclerView;
    CartAdapter myAdapter;
    ArrayList<FoodData> cartlist;
    LinearLayoutManager linearLayoutManager;
    TextView total;
    Button checkout;
    int totalc= 0;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kart, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclercart);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        total = (TextView) v.findViewById(R.id.totalcost);
        recyclerView.setLayoutManager(linearLayoutManager);


        if (abd.getlist().isEmpty()){
            Toast.makeText(getActivity(), "Cart Empty", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(getActivity(),CartNotEmpty.class);
        }else{
        cartlist = new ArrayList<>();
        int n = abd.getlist().size();
        for (int i = 0; i < n; i++) {
            cartlist.add(abd.getlist().get(i));

        }
        myAdapter = new CartAdapter(getActivity(),cartlist);
        recyclerView.setAdapter(myAdapter);}



    return v;
}

}
