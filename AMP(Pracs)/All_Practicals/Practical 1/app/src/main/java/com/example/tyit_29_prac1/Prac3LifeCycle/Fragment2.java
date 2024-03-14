package com.example.tyit_29_prac1.Prac3LifeCycle;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;

import com.example.tyit_29_prac1.R;

public class Fragment2 extends Fragment {

    private static Fragment2 fragment2;

    public Fragment2() {
        // Required empty public constructor
    }

    public static Fragment2 getFrag2Instance() {
        if (fragment2 == null) {
            fragment2 = new Fragment2();
        }
        return fragment2;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false);
    }
}