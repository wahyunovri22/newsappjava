package com.example.newsappjava.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newsappjava.MainActivity;
import com.example.newsappjava.databinding.ActivityLoginBinding;

import java.util.Objects;

import es.dmoral.toasty.Toasty;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Objects.requireNonNull(getSupportActionBar()).hide();
        main();
    }

    private void main(){
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()){
                    login();
                }
            }
        });
    }

    private Boolean validation(){
        if (binding.edtUsername.getText().toString().isEmpty()){
            Toasty.error(this,"Username harus diisi",Toasty.LENGTH_SHORT).show();
            return false;
        }
        if (binding.edtPassword.getText().toString().isEmpty()){
            Toasty.error(this,"Username harus diisi",Toasty.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void login(){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }
}