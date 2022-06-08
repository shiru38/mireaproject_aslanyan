package ru.mirea.aslanyan.mireaproject.ui.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolder {
    @GET("posts")
    Call<List<Post>> getPosts();
}