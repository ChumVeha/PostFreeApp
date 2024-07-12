package com.chumvehakh.postfreeapp.api;

import com.chumvehakh.postfreeapp.models.response.PostResponse;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIInterface {
    @GET("/posts")
    Call<PostResponse> getAllPosts();
}
