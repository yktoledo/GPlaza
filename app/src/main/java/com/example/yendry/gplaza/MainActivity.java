package com.example.yendry.gplaza;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.yendry.gplaza.presentation.view.AddUserFragment;
import com.example.yendry.gplaza.presentation.view.HomeFragment;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private TextView titleView;
    private ImageButton btn_add;
    RelativeLayout progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        progress = findViewById(R.id.progress_bar);
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
        setTile("Users");
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, HomeFragment.newInstance(), "home")
                .addToBackStack("home")
                .commit();


    }

    private void openAddFragment() {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, AddUserFragment.newInstance(), "add")
                .addToBackStack("add")
                .commit();
        btn_add.setVisibility(View.GONE);
        setTile("Add new User");
    }

    @Override
    public void onBackPressed() {

        if (getSupportFragmentManager().getBackStackEntryCount()==1){
            finish();
        }else if (getSupportFragmentManager().getBackStackEntryAt(getSupportFragmentManager().getBackStackEntryCount()-2).getName().equalsIgnoreCase("home")){
            btn_add.setVisibility(View.VISIBLE);
            setTile("Users");
            super.onBackPressed();
        }else {
            super.onBackPressed();
        }


    }

    public void setTile(String title){
        titleView.setText(title);
    }

    public void showProgress(boolean show){
        progress.setVisibility(show ? View.VISIBLE : View.GONE);
    }

    public void hideKeyboard(){
        View view = this.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }
}
