package com.chumvehakh.postfreeapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.chumvehakh.postfreeapp.R;
import com.chumvehakh.postfreeapp.models.response.PostsItem;

import java.util.List;

public class PostAdapter extends RecyclerView.Adapter<PostAdapter.PostViewHolder>{
    private List<PostsItem> postsItemList;
    private Context context;

    public PostAdapter(List<PostsItem> postsItemList, Context context) {
        this.postsItemList = postsItemList;
        this.context = context;
    }

    @NonNull
    @Override
    public PostViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view =  LayoutInflater.from(context).inflate(R.layout.post_item_card_layout, null, false);
        return new PostViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PostViewHolder holder, int position) {
        PostsItem postsItem = postsItemList.get(position);
        if(postsItem.getTitle() !=null){
            holder.title.setText(postsItem.getTitle().toString());
        }
    }

    @Override
    public int getItemCount() {
        return postsItemList.size();
    }

    public static class PostViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        public PostViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.tvTitle);
        }
    }
}
