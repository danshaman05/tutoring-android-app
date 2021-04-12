package com.example.tutoring;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

// Author: Daniel Grohol
// Created: 12.4.2021

// TutorApp
// App provide client for TutorService backend.
// App shows history of the tutor's lessons, and allow the tutor to add more lessons. Each lesson
// can be paid or unpaid (waits for the customer to pay).

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")     // TODO change to backend base URL
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        TutorService service = retrofit.create(TutorService.class);



        // Asynchronous call to our TutorService:
        service.listRepos("rypak-matus").enqueue(new Callback<List<Lesson>>() {
            @Override
            public void onResponse(Call<List<Lesson>> call, Response<List<Lesson>> response) {
                Log.e("MYAPP", "Success");

                List<Lesson> lessons = response.body();         // ziska lessons - objekty JSON - ako zoznam
                Log.e("MYAPP", String.valueOf(lessons.get(0).price));   // vypise cenu prvej lekcie
            }
            @Override
            public void onFailure(Call<List<Lesson>> call, Throwable t) {
                Log.e("MYAPP", "Failure");
            }
        });

    }
}