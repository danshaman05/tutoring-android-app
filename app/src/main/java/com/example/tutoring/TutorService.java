package com.example.tutoring;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface TutorService {

    @GET("student/{student}/lessons")
    Call<List<Lesson>> listRepos(@Path("student") String user);
}
