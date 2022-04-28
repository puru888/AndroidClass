package com.example.recify.adapters;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recify.R;
import com.example.recify.db.AppDatabase;
import com.example.recify.db.Dao.RecipeDao;
import com.example.recify.entities.Recipe;
import com.squareup.picasso.Picasso;

public class FavoriteViewHolder extends RecyclerView.ViewHolder {
    private final ImageView image;
    private final TextView name;
    private Recipe recipe;

    public FavoriteViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.favoriteListItem_image);
        name = itemView.findViewById(R.id.favoriteListItem_name);

        RecipeDao recipeDao = AppDatabase.getDatabaseInstance(itemView.getContext()).recipeDao();

        itemView.findViewById(R.id.favoriteListItem_delete).setOnClickListener(view -> {
           AppDatabase.databaseWriteExecutor.execute(()->{
               recipeDao.delete(recipe);
           });
        });
    }

    public void bind(Recipe recipe){
        this.recipe = recipe;
        Picasso.get().load(recipe.getImage()).into(image);
        name.setText(recipe.getName());
    }
}
