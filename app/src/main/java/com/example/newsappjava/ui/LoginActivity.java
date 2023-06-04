package com.example.newsappjava.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.newsappjava.MainActivity;
import com.example.newsappjava.R;
import com.example.newsappjava.databinding.ActivityLoginBinding;
import com.example.newsappjava.helper.HelperClass;
import com.example.newsappjava.model.ResponseLogin;
import com.example.newsappjava.network.ApiConfig;
import com.jaeger.library.StatusBarUtil;

import java.util.Objects;

import es.dmoral.toasty.Toasty;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

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

    private void main() {
        new HelperClass().hideBar(this);
        StatusBarUtil.setColor(this, ContextCompat.getColor(this, R.color.white),0);
        binding.btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (validation()) {
                    login();
                }
            }
        });
    }

    private Boolean validation() {
        if (binding.edtUsername.getText().toString().isEmpty()) {
            Toasty.error(this, "Username harus diisi", Toasty.LENGTH_SHORT).show();
            return false;
        }
        if (binding.edtPassword.getText().toString().isEmpty()) {
            Toasty.error(this, "Password harus diisi", Toasty.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void login() {
        ProgressDialog dialog = ProgressDialog.show(this, "Loading",
                "Please wait...", true);
        dialog.show();
        ApiConfig.getInstanceRetrofit().login(binding.edtUsername.getText().toString(),
                binding.edtPassword.getText().toString()).enqueue(new Callback<ResponseLogin>() {
            @Override
            public void onResponse(Call<ResponseLogin> call, Response<ResponseLogin> response) {
                if (response.isSuccessful()){
                    dialog.dismiss();
                    ResponseLogin data = response.body();
                    if (!data.isError()){
                        Toasty.info(getApplicationContext(),data.getMessage().toString(),Toasty.LENGTH_SHORT).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                        finish();
                        return;
                    }
                    Toasty.error(getApplicationContext(),data.getMessage().toString(),Toasty.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<ResponseLogin> call, Throwable t) {
                dialog.dismiss();
                Toasty.error(getApplicationContext(),t.getMessage().toString(),Toasty.LENGTH_SHORT).show();
            }
        });

    }
}