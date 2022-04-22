package com.example.databasecurd.recycle_view;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.R;
import com.example.databasecurd.db.Entities.Message;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private final TextView name;
    private final TextView message;
    private final MessageAdapter messageAdapter;

    public MessageViewHolder(@NonNull View itemView, MessageAdapter messageAdapter) {
        super(itemView);
        name = itemView.findViewById(R.id.messageListView_name);
        message = itemView.findViewById(R.id.messageListView_message);
        this.messageAdapter = messageAdapter;
    }

    public void bind(Message entity){
        name.setText(entity.getUserName());
        message.setText(entity.getMessage());
    }
}
