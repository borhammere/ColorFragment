package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class DetailFragment extends Fragment {
    private static final String COLOR_ARG_KEY = "COLOR_ARG_KEY";

    public DetailFragment() {
    }

    public static DetailFragment newInstance(int color) {
        DetailFragment fragment = new DetailFragment();
        Bundle args = new Bundle();
        args.putInt(COLOR_ARG_KEY, color);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_detail, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        if (getArguments() != null) {
            int color = getArguments().getInt(COLOR_ARG_KEY);
            view.setBackgroundColor(color);
        }
    }
}