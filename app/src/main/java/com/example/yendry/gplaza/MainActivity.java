package com.example.yendry.gplaza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.yendry.gplaza.presentation.view.HomeFragment;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, HomeFragment.newInstance(), "home")
                .addToBackStack("home")
                .commit();

    }
}
