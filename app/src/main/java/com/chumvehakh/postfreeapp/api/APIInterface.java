package com.chumvehakh.postfreeapp.api;

import com.chumvehakh.postfreeapp.models.request.RegiserRequest;
import com.chumvehakh.postfreeapp.models.response.BaseResponse;
import com.chumvehakh.postfreeapp.models.response.PostResponse;
import com.chumvehakh.postfreeapp.models.response.PostsItem;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface APIInterface {
    @GET("/posts")
    Call<PostResponse> getAllPosts();
    @GET("/posts/{id}")
    Call<PostsItem> getPostById(@Path("id") int id);

    @POST("/api/oauth/register")
    Call<BaseResponse<String>> registerUser(@Body RegiserRequest req);
}
