package com.example.testapp;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class app_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);

        Button btnAll = findViewById(R.id.btn_all);
        Button btnOpen = findViewById(R.id.btn_open);

        // Load initial fragment
        loadFragment(new AllFragment());

        // Button click listeners
        btnAll.setOnClickListener(view -> loadFragment(new AllFragment()));
        btnOpen.setOnClickListener(view -> loadFragment(new OpenFragment()));
    }

    private void loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
        }
    }
}
