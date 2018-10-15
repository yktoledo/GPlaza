package com.example.yendry.gplaza;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.yendry.gplaza.presentation.view.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleView;
    private ImageButton btn_add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.tool_bar);
        titleView = findViewById(R.id.title);
        btn_add = findViewById(R.id.add_btn);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddFragment();
            }
        });
        setSupportActionBar(toolbar);
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, HomeFragment.newInstance(), "home")
                .addToBackStack("home")
                .commit();


    }

    private void openAddFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, HomeFragment.newInstance(), "home")
                .addToBackStack("home")
                .commit();
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount()==1){
            finish();
        }else if (getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-2).getName().equalsIgnoreCase("home")){


            super.onBackPressed();
        }else {
            super.onBackPressed();
        }


    }
}
