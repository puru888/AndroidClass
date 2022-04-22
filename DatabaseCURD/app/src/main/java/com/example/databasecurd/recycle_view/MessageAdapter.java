package com.example.databasecurd.recycle_view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.R;
import com.example.databasecurd.db.Entities.Message;

import java.util.ArrayList;
import java.util.List;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {

    private List<Message> messageList = new ArrayList<>();

    public void addMessage(Message message){
        messageList.add(message);
        notifyDataSetChanged();
    }
    public void removeMessage(Message message){
        messageList.remove(message);
        notifyDataSetChanged();
    }
    public void changeData(List<Message> messageList){
        this.messageList = messageList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflateView = LayoutInflater.from(parent.getContext())
                .inflate(viewType,parent,false);
        return new MessageViewHolder(inflateView,this);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.bind(messageList.get(position));
    }

    @Override
    public int getItemCount() {
        return messageList.size();
    }

    @Override
    public int getItemViewType(int position) {
        return R.layout.from_user_message_list_view;
    }
}
