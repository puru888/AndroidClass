package com.example.databasecurd.recycle_view;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.MessageActivity;
import com.example.databasecurd.R;
import com.example.databasecurd.db.Entities.ChatList;

public class ChatListViewHolder extends RecyclerView.ViewHolder {

    private final TextView userName;
    private final ChatListAdapter chatListAdapter;
    public static final String EXTRA_USER_NAME = "userName";

    public ChatListViewHolder(@NonNull View itemView, ChatListAdapter chatListAdapter) {
        super(itemView);

        userName = itemView.findViewById(R.id.chat_list_users);
        this.chatListAdapter = chatListAdapter;

        itemView.setOnClickListener(view -> {
            Intent intent = new Intent(itemView.getContext(), MessageActivity.class)
                    .putExtra(EXTRA_USER_NAME,userName.getText().toString());
            itemView.getContext().startActivity(intent);
        });
    }

    public void bind(ChatList entity){
        userName.setText(entity.getUserName());
    }
}
