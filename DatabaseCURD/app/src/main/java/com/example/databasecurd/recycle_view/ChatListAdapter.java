package com.example.databasecurd.recycle_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.R;
import com.example.databasecurd.db.Entities.ChatList;

import java.util.ArrayList;
import java.util.List;

public class ChatListAdapter extends RecyclerView.Adapter<ChatListViewHolder> {

    private List<ChatList> chatList = new ArrayList<>();
    private int loggedInUserId = -1;

    public void addChat(ChatList chat) {
        chatList.add(chat);
    }

    public void removeChat(ChatList chat) {
        chatList.remove(chat);
    }

    public void changeData(List<ChatList> chatList) {
        this.chatList = chatList;
    }
    public void setLoggedInUserId(int id) {
        this.loggedInUserId = id;
    }
    public int getLoggedInUserId(){
        return loggedInUserId;
    }

    @NonNull
    @Override
    public ChatListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext())
                .inflate(viewType, parent, false);
        return new ChatListViewHolder(inflateView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatListViewHolder holder, int position) {
        holder.bind(chatList.get(position));
    }

    @Override
    public int getItemCount() {
        return chatList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.chat_list_view;
    }
}
