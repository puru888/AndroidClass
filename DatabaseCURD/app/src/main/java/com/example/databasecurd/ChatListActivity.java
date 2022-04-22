package com.example.databasecurd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.ChatDao;
import com.example.databasecurd.db.Entities.ChatList;
import com.example.databasecurd.db.Entities.Message;
import com.example.databasecurd.recycle_view.ChatListAdapter;
import com.example.databasecurd.recycle_view.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

public class ChatListActivity extends AppCompatActivity {
    List<ChatList> chats = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        AppDatabase appDatabase = AppDatabase.getDatabaseInstance(this);
        ChatDao chatDao = appDatabase.chatDao();
        Intent receivedIntentId = getIntent();

        RecyclerView list = findViewById(R.id.chat_list_recycleView);
        list.setHasFixedSize(false);
        list.setLayoutManager(new GridLayoutManager(this, 3));

        AppDatabase.databaseWriteExecutor.execute(() -> {
            if (receivedIntentId.hasExtra(LoginActivity.EXTRA_ID)) {
                chats = chatDao.getChatList(receivedIntentId.getIntExtra(LoginActivity.EXTRA_ID, -1));
            }
        });

        ChatListAdapter chatListAdapter = new ChatListAdapter();
        if (!chats.isEmpty()) {
            chatListAdapter.changeData(chats);
            list.setAdapter(chatListAdapter);
        }

    }
}