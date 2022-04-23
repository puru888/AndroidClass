package com.example.databasecurd;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.databasecurd.db.AppDatabase;
import com.example.databasecurd.db.Dao.MessageDao;
import com.example.databasecurd.db.Entities.Message;
import com.example.databasecurd.recycle_view.ChatListViewHolder;
import com.example.databasecurd.recycle_view.MessageAdapter;

import java.util.ArrayList;
import java.util.List;

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

        AppDatabase appDatabase = AppDatabase.getDatabaseInstance(this);
        MessageDao messageDao = appDatabase.messageDao();

        Intent getIntent = getIntent();
        int loggedInUserId = getIntent.getIntExtra(ChatListViewHolder.EXTRA_LOGGED_USER_ID,-1);
        int toUserId = getIntent.getIntExtra(ChatListViewHolder.EXTRA_TO_USER_ID,-1);
        userName.setText(getIntent.getStringExtra(ChatListViewHolder.EXTRA_TO_USER_NAME));

        MessageAdapter messageAdapter = new MessageAdapter(toUserId);
        AppDatabase.databaseWriteExecutor.execute(()->{
           List<Message> messages =  messageDao.getMessages(loggedInUserId,toUserId);
            messageAdapter.changeData(messages);
            list.setAdapter(messageAdapter);
        });

        findViewById(R.id.activity_message_sendBtn).setOnClickListener(v -> {
            String messageValue = messageEditText.getText().toString();
//            Log.e("Logged in user",String.valueOf(getIntent.getIntExtra(ChatListViewHolder.EXTRA_LOGGED_USER_ID,-1)));
//            Log.e("to user",String.valueOf(getIntent.getIntExtra(ChatListViewHolder.EXTRA_TO_USER_ID,-1)));
            Message message = new Message(messageValue,loggedInUserId,toUserId,false);
            AppDatabase.databaseWriteExecutor.execute(()->{
                messageDao.insert(message);
            });
            messageEditText.setText("");
            messageAdapter.addMessage(message);
        });
    }


}