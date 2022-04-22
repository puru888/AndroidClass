package com.example.databasecurd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databasecurd.db.Entities.Message;
import com.example.databasecurd.recycle_view.ChatListViewHolder;
import com.example.databasecurd.recycle_view.MessageAdapter;

import java.util.ArrayList;

public class MessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        RecyclerView list = findViewById(R.id.activity_message_recycler_view);
        EditText messageEditText = findViewById(R.id.activity_message_send_message);
        TextView userName = findViewById(R.id.message_list_user);
        list.setHasFixedSize(false);
        list.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<Message> messages = new ArrayList<>();
        Intent getIntent = getIntent();
            messages.add(new Message("Hello", 1, 2, false));
        userName.setText(getIntent.getStringExtra(ChatListViewHolder.EXTRA_TO_USER_NAME));

        MessageAdapter messageAdapter = new MessageAdapter(getIntent.getIntExtra(ChatListViewHolder.EXTRA_TO_USER_ID,-1));
        messageAdapter.changeData(messages);
        list.setAdapter(messageAdapter);

        findViewById(R.id.activity_message_sendBtn).setOnClickListener(v -> {
            String messageValue = messageEditText.getText().toString();
            Message message = new Message(messageValue,2,1,false);
            messageAdapter.addMessage(message);
        });
    }


}