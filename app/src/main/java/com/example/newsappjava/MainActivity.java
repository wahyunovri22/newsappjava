package com.example.newsappjava;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.newsappjava.adapter.NewsAdapter;
import com.example.newsappjava.databinding.ActivityMainBinding;
import com.example.newsappjava.helper.HelperClass;
import com.example.newsappjava.model.NewsItem;
import com.example.newsappjava.model.ResponseNews;
import com.example.newsappjava.network.ApiConfig;
import com.jaeger.library.StatusBarUtil;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        main();
    }

    private void main(){
        new HelperClass().hideBar(this);
        getSupportActionBar().hide();
        StatusBarUtil.setColor(this, ContextCompat.getColor(this,R.color.white),0);
        getData();
    }

    private void getData(){
        ProgressDialog dialog = ProgressDialog.show(MainActivity.this,"Loading","Please wait ....",true);
        dialog.show();
        ApiConfig.getInstanceRetrofit().news().enqueue(new Callback<ResponseNews>() {
            @Override
            public void onResponse(Call<ResponseNews> call, Response<ResponseNews> response) {
                dialog.dismiss();
                if (response.isSuccessful()){
                    ResponseNews data = response.body();
                    if (!data.isError()){
                        showData(data.getNews());
                    }
                }
            }

            @Override
            public void onFailure(Call<ResponseNews> call, Throwable t) {
                dialog.dismiss();
                Toast.makeText(MainActivity.this, t.getMessage().toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showData(List<NewsItem> list){
        NewsAdapter adapter = new NewsAdapter(list,this);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        binding.rvNews.setLayoutManager(layoutManager);
        binding.rvNews.setAdapter(adapter);

    }
}