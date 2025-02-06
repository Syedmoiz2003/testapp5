package com.example.testapp;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {

    private EditText editTextFirstName, editTextLastName, editTextEmail, editTextMobile;
    private Button btnProceed;
    private DatabaseReference databaseReference; // Firebase Database reference

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Database reference
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");

        // Initialize UI elements
        editTextFirstName = findViewById(R.id.EditText1); // First Name EditText
        editTextLastName = findViewById(R.id.EditText2); // Last Name EditText
        editTextEmail = findViewById(R.id.EditText3); // Email EditText
        editTextMobile = findViewById(R.id.EditText4); // Mobile Number EditText
        btnProceed = findViewById(R.id.Button1); // Proceed Button
        TextView textSignIn = findViewById(R.id.text1);

        btnProceed.setOnClickListener(view -> {
            String firstName = editTextFirstName.getText().toString().trim();
            String lastName = editTextLastName.getText().toString().trim();
            String email = editTextEmail.getText().toString().trim();
            String mobileNumber = editTextMobile.getText().toString().trim();

            // Validate all fields
            if (TextUtils.isEmpty(firstName)) {
                Toast.makeText(MainActivity.this, "Please enter your First Name", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(lastName)) {
                Toast.makeText(MainActivity.this, "Please enter your Last Name", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(email)) {
                Toast.makeText(MainActivity.this, "Please enter your Email", Toast.LENGTH_SHORT).show();
            } else if (TextUtils.isEmpty(mobileNumber)) {
                Toast.makeText(MainActivity.this, "Please enter your Mobile Number", Toast.LENGTH_SHORT).show();
            } else if (mobileNumber.length() != 11) {
                Toast.makeText(MainActivity.this, "Mobile number must be exactly 11 digits", Toast.LENGTH_SHORT).show();
            } else {
                // Save user to Firebase
                saveUserToFirebase(firstName, lastName, email, mobileNumber);
            }
        });

        textSignIn.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
            startActivity(intent);
        });
    }

    private void saveUserToFirebase(String firstName, String lastName, String email, String mobileNumber) {
        // Create a user object
        User user = new User(firstName, lastName, email, mobileNumber);

        // Save user data in Firebase under the mobile number as the key
        databaseReference.child(mobileNumber).setValue(user).addOnCompleteListener(task -> {
            if (task.isSuccessful()) {
                Toast.makeText(MainActivity.this, "User registered successfully!", Toast.LENGTH_SHORT).show();
                // Navigate to WelcomeActivity
                Intent intent = new Intent(MainActivity.this, WelcomeActivity.class);
                intent.putExtra("mobile_number", mobileNumber);
                startActivity(intent);
            } else {
                Toast.makeText(MainActivity.this, "Error saving user!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // User class for Firebase
    public static class User {
        public String firstName, lastName, email, mobileNumber;

        public User() {
            // Default constructor required for Firebase
        }

        public User(String firstName, String lastName, String email, String mobileNumber) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.email = email;
            this.mobileNumber = mobileNumber;
        }
    }
}
