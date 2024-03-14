package com.example.tyit_29_prac1.Prac3LifeCycle;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.tyit_29_prac1.R;


public class Fragment1 extends Fragment {


    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public void onAttach(@NonNull Context context) {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnAttach");
        super.onAttach(context);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnCreate");
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnCreateView");
        return inflater.inflate(R.layout.fragment_1, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in ViewCreated");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override
    public void onStart() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnResume");

        super.onResume();
    }

    @Override
    public void onPause() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnStop");
        super.onStop();
    }

    @Override
    public void onDestroyView() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnDestroyView");
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnADestroy");
        super.onDestroy();
    }

    @Override
    public void onDetach() {
        Log.d("PRAC3_FRAG_LIFECYCLE", "in OnDetach");

        super.onDetach();
    }
}