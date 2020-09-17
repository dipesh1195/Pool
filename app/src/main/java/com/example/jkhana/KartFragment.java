package com.example.jkhana;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import org.w3c.dom.Text;

public class KartFragment extends Fragment {
    TextView cart,cart1;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_kart, container, false);

//       cart.setOnClickListener(this);
//implements View.OnClickListener
        return v;
    }

//    @Override
//    public void onClick(View view) {
//        switch (view.getId()) {
//            case R.id.emptycart:
//            case R.id.cart:
//                Intent intent = new Intent(getActivity().getApplication(),MainActivity.class);
//                startActivity(intent);
//                break;
//            default:
//                break;
//        }


}
