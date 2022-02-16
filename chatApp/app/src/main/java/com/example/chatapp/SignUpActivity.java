package com.example.chatapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.chatapp.Models.User;
import com.example.chatapp.databinding.ActivitySignUpBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
//54 min 40 sec
public class SignUpActivity extends AppCompatActivity {
    ActivitySignUpBinding binding;
    private FirebaseAuth auth;
    private FirebaseDatabase database;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //binding to review
        binding = ActivitySignUpBinding.inflate(getLayoutInflater());
        //since binding is used
        setContentView(binding.getRoot());
        // hide the bar
        getSupportActionBar().hide();

        // for firebase auth*****
        auth = FirebaseAuth.getInstance();
        database= FirebaseDatabase.getInstance();
        // creating progress dialog
        progressDialog = new ProgressDialog(SignUpActivity.this);
        progressDialog.setTitle("Creating Account");
        progressDialog.setMessage("Creating your Account");

        //onclick binding
        binding.btnSignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                boolean temp=false;
                if(binding.etUserName.getText().toString().length()==0 ||binding.etPassword.getText().toString().length()==0 || binding.etEmail.getText().toString().length()==0 ){
                    Toast.makeText(SignUpActivity.this, "Please fill up all the boxes properly", Toast.LENGTH_SHORT).show();

                }
                else{
                    temp=true;
                }
                if(temp){
                    progressDialog.show();
                    auth.createUserWithEmailAndPassword
                            (binding.etEmail.getText().toString(),binding.etPassword.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) { // see AuthResult implementation
                            progressDialog.dismiss();
                            if(task.isSuccessful()){
                                User user = new User(binding.etUserName.getText().toString(),binding.etPassword.getText().toString(),binding.etEmail.getText().toString());
                                String id= task.getResult().getUser().getUid();
                                database.getReference().child("Users").child(id).setValue(user);
                                binding.etEmail.setText("");
                                binding.etUserName.setText("");
                                binding.etPassword.setText("");
                                Toast.makeText(SignUpActivity.this, "User Created Successfully, Now you can Sign in", Toast.LENGTH_SHORT).show();


                            }
                            else{
                                Toast.makeText(SignUpActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                progressDialog.dismiss(); // extra
                            }
                        }
                    }); // binding get text
                }
                else{
                    Intent intent = new Intent(SignUpActivity.this,SignUpActivity.class);
                    startActivity(intent);
                }




            }
        });
        binding.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SignUpActivity.this,SignInActivity.class);
                startActivity(intent);
            }
        });
    }
}