package com.example.testapp;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Profile_main extends AppCompatActivity {

    private EditText nameField, phoneField, emailField;
    //private ImageView profilePicture;
   // private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_main);

        // Initialize UI elements
       //profilePicture = findViewById(R.id.profile_picture);
        nameField = findViewById(R.id.name_field);
        phoneField = findViewById(R.id.phone_field);
        emailField = findViewById(R.id.email_field);
        //saveButton = findViewById(R.id.save_button);

        // Load existing profile data (optional: can be fetched from a database or API)
        loadProfileData();

        // Save button logic
       // saveButton.setOnClickListener(view -> saveProfileData());
    }

    private void loadProfileData() {
        // Dummy data: Replace this with actual data loading logic (e.g., from database or SharedPreferences)
        nameField.setText("John Doe");
        phoneField.setText("+1234567890");
        emailField.setText("johndoe@example.com");

        // Example for setting profile picture (optional)
      //  profilePicture.setImageResource(R.drawable.ic_profile); // Replace with your drawable
    }

    private void saveProfileData() {
        // Get user input
        String name = nameField.getText().toString().trim();
        String phone = phoneField.getText().toString().trim();
        String email = emailField.getText().toString().trim();

        // Validate input (basic example)
        if (name.isEmpty() || phone.isEmpty() || email.isEmpty()) {
            Toast.makeText(this, "All fields must be filled!", Toast.LENGTH_SHORT).show();
            return;
        }

        // Save data logic (e.g., save to database or SharedPreferences)
        // For now, just display a toast
        Toast.makeText(this, "Profile Saved: \nName: " + name + "\nPhone: " + phone + "\nEmail: " + email, Toast.LENGTH_LONG).show();
    }
}
