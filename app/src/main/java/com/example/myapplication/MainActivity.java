package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.ColorListController {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    public void openColorScreen(int color) {
        DetailFragment detailFragment = DetailFragment.newInstance(color);

        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.details_fragment_container, detailFragment)
                .addToBackStack(null)
                .commit();
    }

}