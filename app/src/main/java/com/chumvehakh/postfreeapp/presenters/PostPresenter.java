package com.chumvehakh.postfreeapp.presenters;

import android.view.View;

import androidx.recyclerview.widget.GridLayoutManager;

import com.chumvehakh.postfreeapp.MainActivity;
import com.chumvehakh.postfreeapp.adapter.PostAdapter;
import com.chumvehakh.postfreeapp.api.APIClient;
import com.chumvehakh.postfreeapp.api.APIInterface;
import com.chumvehakh.postfreeapp.models.response.PostResponse;
import com.chumvehakh.postfreeapp.models.response.PostsItem;
import com.chumvehakh.postfreeapp.views.PostView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class PostPresenter {
    private final PostView view;
    private APIInterface apiInterface;



    public PostPresenter(PostView view) {
        this.view = view;
        apiInterface = APIClient.getClient().create(APIInterface.class);
    }
    public void getAllPosts() {
        view.onLoading();
        apiInterface.getAllPosts().enqueue(new Callback<PostResponse>() {
            @Override
            public void onResponse(Call<PostResponse> call, Response<PostResponse> response) {
                view.onHidingLoading();
                if (response.isSuccessful() && null != response.body()){
                    view.onGetPostSuccess(response.body().getPosts());
                }
            }

            @Override
            public void onFailure(Call<PostResponse> call, Throwable throwable) {
                view.onHidingLoading();
            }
        });
    }
    public void getPostById(int id){
        view.onLoading();
        apiInterface.getPostById(id).enqueue(new Callback<PostsItem>() {
            @Override
            public void onResponse(Call<PostsItem> call, Response<PostsItem> response) {
                view.onHidingLoading();
                if (response.isSuccessful() && response.body() != null){
                    view.onGetPostByIdSuccess(response.body());
                }
            }

            @Override
            public void onFailure(Call<PostsItem> call, Throwable throwable) {
                view.onHidingLoading();
                view.onSuccess(throwable.getLocalizedMessage());
            }
        });
    }
}
