package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class app_main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_main);

        Button btnAll = findViewById(R.id.btn_all);
        Button btnOpen = findViewById(R.id.btn_open);
        ImageView profileImageButton = findViewById(R.id.Ibutton5); // Your profile image button

        // Load initial fragment
        loadFragment(new AllFragment());

        // Button click listeners
        btnAll.setOnClickListener(view -> loadFragment(new AllFragment()));
        btnOpen.setOnClickListener(view -> loadFragment(new OpenFragment()));

        // Profile image button click listener
        profileImageButton.setOnClickListener(view -> {
            // Start the Profile_main Activity
            Intent intent = new Intent(app_main.this, Profile_main.class);
            startActivity(intent);
        });
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
