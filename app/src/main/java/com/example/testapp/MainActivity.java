package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnProceed = findViewById(R.id.Button1); // Proceed button
        btnProceed.setOnClickListener(view -> {
            // Navigate to app_main activity
            Intent intent = new Intent(MainActivity.this, app_main.class);
            startActivity(intent);
        });
    }
}
