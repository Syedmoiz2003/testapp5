package com.example.testapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class WelcomeActivity extends AppCompatActivity {

    private EditText editTextMobile;
    private Button btnLogin;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Initialize UI elements
        editTextMobile = findViewById(R.id.EditText1);
        TextView editTextMobile1 = findViewById(R.id.text3);
        btnLogin = findViewById(R.id.Button1);

        // Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Set click listener on Login button
        btnLogin.setOnClickListener(view -> {
            String mobileNumber = editTextMobile.getText().toString().trim();

            // Validate the mobile number before checking Firebase
            if (TextUtils.isEmpty(mobileNumber)) {
                Toast.makeText(WelcomeActivity.this, "Please enter your mobile number", Toast.LENGTH_SHORT).show();
            } else if (mobileNumber.length() != 11) {
                Toast.makeText(WelcomeActivity.this, "Mobile number must be exactly 11 digits", Toast.LENGTH_SHORT).show();
            } else {
                checkUserInFirebase(mobileNumber);
            }
        });

        editTextMobile1.setOnClickListener(view -> {
            Intent intent = new Intent(WelcomeActivity.this, MainActivity.class);
            startActivity(intent);
        });
    }

    private void checkUserInFirebase(String mobileNumber) {
        databaseReference.child(mobileNumber).addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    // Save logged-in user's phone number in SharedPreferences
                    SharedPreferences sharedPreferences = getSharedPreferences("UserData", MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("phoneNumber", mobileNumber);
                    editor.apply();

                    // Navigate to the main app
                    Intent intent = new Intent(WelcomeActivity.this, app_main.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(WelcomeActivity.this, "User does not exist. Please register first!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(WelcomeActivity.this, "Database Error: " + error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
