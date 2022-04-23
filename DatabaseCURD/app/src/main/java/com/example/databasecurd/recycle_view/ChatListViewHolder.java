package com.example.databasecurd.recycle_view;

import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.databasecurd.MessageActivity;
import com.example.databasecurd.R;
import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.ChatDao;
import com.example.databasecurd.db.Entities.ChatList;

public class ChatListViewHolder extends RecyclerView.ViewHolder {

    private final TextView userName;
    private final ChatListAdapter chatListAdapter;
    public static final String EXTRA_TO_USER_NAME = "userName";
    public static final String EXTRA_TO_USER_ID = "id";
    public static final String EXTRA_LOGGED_USER_ID = "loggedUserId";

    public ChatListViewHolder(@NonNull View itemView, ChatListAdapter chatListAdapter) {
        super(itemView);

        userName = itemView.findViewById(R.id.chat_list_users);
        this.chatListAdapter = chatListAdapter;

        final AppDatabase appDatabase = AppDatabase.getDatabaseInstance(itemView.getContext());
        final ChatDao chatDao = appDatabase.chatDao();

        itemView.setOnClickListener(view -> {
            AppDatabase.databaseWriteExecutor.execute(() -> {
                int id = chatDao.getChatId(userName.getText().toString());
                Intent intent = new Intent(itemView.getContext(), MessageActivity.class)
                        .putExtra(EXTRA_TO_USER_NAME, userName.getText().toString())
                        .putExtra(EXTRA_TO_USER_ID,id)
                        .putExtra(EXTRA_LOGGED_USER_ID,chatListAdapter.getLoggedInUserId());
                itemView.getContext().startActivity(intent);
            });
        });
    }

    public void bind(ChatList entity) {
        userName.setText(entity.getUserName());
    }
}
