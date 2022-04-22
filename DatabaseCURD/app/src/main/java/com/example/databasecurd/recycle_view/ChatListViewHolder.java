package com.example.databasecurd.recycle_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.R;
import com.example.databasecurd.db.Entities.ChatList;

public class ChatListViewHolder extends RecyclerView.ViewHolder {

    private final TextView userName;
    private final ChatListAdapter chatListAdapter;

    public ChatListViewHolder(@NonNull View itemView, ChatListAdapter chatListAdapter) {
        super(itemView);

        userName = itemView.findViewById(R.id.chat_list_users);
        this.chatListAdapter = chatListAdapter;
    }

    public void bind(ChatList entity){
        userName.setText(entity.getUserName());
    }
}
