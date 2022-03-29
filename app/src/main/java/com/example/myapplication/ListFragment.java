package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ListFragment extends Fragment {
    private Button blueButton;
    private Button greenButton;
    private Button redButton;
    private Button blackButton;
    private Button yellowButton;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try {
            getController();
        } catch (Exception e) {
            throw new IllegalStateException(
                    "ListFragment можно показывать только " +
                    "в активити имплементирующих интерфейс ColorListController"
            );
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_list, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
        setupListeners();
    }

    private void initViews(View view) {
        blueButton = view.findViewById(R.id.blue_button);
        greenButton = view.findViewById(R.id.green_button);
        redButton = view.findViewById(R.id.red_button);
        blackButton = view.findViewById(R.id.black_button);
        yellowButton = view.findViewById(R.id.yellow_button);
    }

    private void setupListeners() {
        @SuppressLint("NonConstantResourceId") final View.OnClickListener onColorClickListener = view -> {
            int color;
            switch (view.getId()) {
                case R.id.black_button:
                    color = Color.BLACK;
                    break;
                case R.id.blue_button:
                    color = Color.BLUE;
                    break;
                case R.id.green_button:
                    color = Color.GREEN;
                    break;
                case R.id.red_button:
                    color = Color.RED;
                    break;
                case R.id.yellow_button:
                    color = Color.YELLOW;
                    break;
                default:
                    color = 0;
            }
            openColorScreen(color);
        };

        blueButton.setOnClickListener(onColorClickListener);
        greenButton.setOnClickListener(onColorClickListener);
        redButton.setOnClickListener(onColorClickListener);
        blackButton.setOnClickListener(onColorClickListener);
        yellowButton.setOnClickListener(onColorClickListener);
    }

    private void openColorScreen(int color) {
        getController().openColorScreen(color);
    }

    private ColorListController getController() {
        return (ColorListController) getActivity();
    }

    interface ColorListController {
        void openColorScreen(int color);
    }
}