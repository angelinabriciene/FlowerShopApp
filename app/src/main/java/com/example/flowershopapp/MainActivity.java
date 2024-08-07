package com.example.flowershopapp;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.flowershopapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private ActivityMainBinding binding;
    private FlowerAdapter adapter;
    private ApiService apiService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://127.0.0.1:8070/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        apiService = retrofit.create(ApiService.class);
        adapter = new FlowerAdapter(this,new ArrayList<>());
        binding.listViewFlowers.setAdapter(adapter);
        fetchFlowers();
    }

    private void fetchFlowers() {
        apiService.getFlowers().enqueue(new Callback<List<Flower>>() {
            @Override
            public void onResponse(Call<List<Flower>> call, Response<List<Flower>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    adapter.clear();
                    adapter.addAll(response.body());
                } else {
                    showError("Failed to load data. Response code: " + response.code());
                }
            }

            @Override
            public void onFailure(Call<List<Flower>> call, Throwable t) {
                showError("Error: " + t.getMessage());
                Log.e(TAG, "Fetch flowers failed", t);
            }
        });
    }

    private void showError(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        binding = null;
    }
}