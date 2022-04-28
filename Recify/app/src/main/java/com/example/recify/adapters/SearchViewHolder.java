package com.example.recify.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recify.R;
import com.example.recify.entities.SearchRecipesResult;
import com.squareup.picasso.Picasso;

public class SearchViewHolder extends RecyclerView.ViewHolder {

    private final ImageView image;
    private final TextView name;
    private SearchRecipesResult searchRecipesResult;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.searchListItem_image);
        name = itemView.findViewById(R.id.searchListItem_name);
    }

    public void bind(SearchRecipesResult searchRecipesResult){
        this.searchRecipesResult = searchRecipesResult;
        Picasso.get().load(searchRecipesResult.getImage()).into(image);
        name.setText(searchRecipesResult.getTitle());
    }
}
