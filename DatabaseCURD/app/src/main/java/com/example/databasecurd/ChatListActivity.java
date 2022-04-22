package com.example.databasecurd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.databasecurd.db.Entities.ChatList;
import com.example.databasecurd.recycle_view.ChatListAdapter;

import java.util.ArrayList;

public class ChatListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_list);

        RecyclerView list = findViewById(R.id.chat_list_recycleView);
        list.setHasFixedSize(false);
        list.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<ChatList> chats = new ArrayList<>();
        chats.add(new ChatList("Admin"));

        ChatListAdapter chatListAdapter = new ChatListAdapter();
        chatListAdapter.changeData(chats);
        list.setAdapter(chatListAdapter);
    }
}