package com.chumvehakh.postfreeapp.api;

import com.chumvehakh.postfreeapp.models.response.PostResponse;
import com.chumvehakh.postfreeapp.models.response.PostsItem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("/posts")
    Call<PostResponse> getAllPosts();
    @GET("/posts/{id}")
    Call<PostsItem> getPostById(@Path("id") int id);
}
