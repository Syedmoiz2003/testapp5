package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
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
        ImageView profileImageButton = findViewById(R.id.Ibutton5);
        ImageView coursesimagebutton = findViewById(R.id.Ibutton3);
        ImageView interviewimagebutton = findViewById(R.id.Ibutton2);
        ImageView myjobimagebutton = findViewById(R.id.Ibutton4);
        ImageView jobsimagebutton = findViewById(R.id.ibutton1);

        // Your profile image button
         // Your profile image button
        // Load initial fragment
        loadFragment(new AllFragment());

        // Button click listeners
        btnAll.setOnClickListener(view -> loadFragment(new AllFragment()));
        btnOpen.setOnClickListener(view -> loadFragment(new OpenFragment()));

        // Profile image button click listener
        profileImageButton.setOnClickListener(view -> {
            // Start the Profile_main Activity
            Intent intent = new Intent(app_main.this, profile_main_1.class);
            startActivity(intent);
        });
        coursesimagebutton.setOnClickListener(View ->{
            Intent intent = new Intent(app_main.this, Courses.class);
            startActivity(intent);
        });

        interviewimagebutton.setOnClickListener(View ->{
            Intent intent = new Intent(app_main.this, interview.class);
            startActivity(intent);
        });

        myjobimagebutton.setOnClickListener(View ->{
            Intent intent = new Intent(app_main.this, my_job.class);
            startActivity(intent);
        });

        jobsimagebutton.setOnClickListener(View ->{
            Intent intent = new Intent(app_main.this, jobs.class);
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
