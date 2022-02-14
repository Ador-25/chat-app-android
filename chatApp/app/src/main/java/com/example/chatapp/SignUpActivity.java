package com.example.chatapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import com.example.chatapp.databinding.ActivitySignUpBinding;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
//54 min 40 sec
public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding to review
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        //since binding is used
        setContentView(binding.getRoot());
        // hide the bar
        getSupportActionBar().hide();

        // for firebase auth***
        auth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();

        //onclick binding
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                auth.createUserWithEmailAndPassword
                        (binding.etEmail.getText().toString(),binding.etPassword.getText().toString()); // binding get text


            }
        });
    }
}