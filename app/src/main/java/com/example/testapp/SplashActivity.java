package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        // Splash screen timer (3 seconds)
        new Handler().postDelayed(() -> {
            // Start the Welcome Activity
            Intent intent = new Intent(SplashActivity.this, WelcomeActivity.class); // Replace with your Welcome Activity
            startActivity(intent);
            finish(); // Close the Splash Activity
        }, 3000); // 3000 milliseconds (3 seconds)
    }
}
