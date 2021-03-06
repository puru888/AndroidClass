package com.example.databasecurd.recycle_view;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.MessageActivity;
import com.example.databasecurd.R;
import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.MessageDao;
import com.example.databasecurd.db.Entities.Message;

public class MessageViewHolder extends RecyclerView.ViewHolder {

    private final TextView message;
    private Message messageEntity;

    private final MessageAdapter messageAdapter;

    public MessageViewHolder(@NonNull View itemView, MessageAdapter messageAdapter) {
        super(itemView);
        message = itemView.findViewById(R.id.user_message_view);
        this.messageAdapter = messageAdapter;

        AppDatabase appDatabase = AppDatabase.getDatabaseInstance(itemView.getContext());
        MessageDao messageDao = appDatabase.messageDao();

        itemView.setOnLongClickListener(view -> {
            messageAdapter.removeMessage(messageEntity);
            AppDatabase.databaseWriteExecutor.execute(() -> {
                messageDao.deleteMessage(messageEntity);
            });
            return true;
        });
    }

    public void bind(Message entity) {

        messageEntity = entity;
        message.setText(entity.getMessage());
    }
}
