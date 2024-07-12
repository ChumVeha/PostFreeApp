package com.chumvehakh.postfreeapp;

import android.graphics.PostProcessor;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.chumvehakh.postfreeapp.adapter.PostAdapter;
import com.chumvehakh.postfreeapp.api.APIClient;
import com.chumvehakh.postfreeapp.api.APIInterface;
import com.chumvehakh.postfreeapp.app.BaseActivity;
import com.chumvehakh.postfreeapp.models.response.PostResponse;
import com.chumvehakh.postfreeapp.models.response.PostsItem;
import com.chumvehakh.postfreeapp.presenters.PostPresenter;
import com.chumvehakh.postfreeapp.views.PostView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends BaseActivity implements PostView {

    private PostAdapter postAdapter;
    private RecyclerView recyclerViewPost;
    private ProgressBar progressBar;
    private PostPresenter postPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        progressBar = findViewById(R.id.progressBar);
        progressBar.setVisibility(View.GONE);
        recyclerViewPost = findViewById(R.id.recyclerViewPost);
        postPresenter = new PostPresenter(this);
        postPresenter.getAllPosts();
    }

    @Override
    public void onLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void onHidingLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void onError(String message) {
        showMessage(message);
    }

    @Override
    public void onSuccess(String message) {
        showMessage(message);
    }

    @Override
    public void onGetPostSuccess(List<PostsItem> postsItemList) {
        postPresenter = new PostPresenter(this);
        recyclerViewPost.setAdapter(postAdapter);
        recyclerViewPost.setLayoutManager(new GridLayoutManager(this, 1));
    }
}