package com.example.jkhana;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

public class ProfileFragment extends Fragment {
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);
        Toast.makeText(getActivity(), "Please Login to Continue", Toast.LENGTH_SHORT).show();
        return v;
    }
}
