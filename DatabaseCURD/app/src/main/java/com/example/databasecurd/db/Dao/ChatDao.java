package com.example.databasecurd.db.Dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.databasecurd.db.Entities.ChatList;

import java.util.List;

@Dao
public interface ChatDao {

    @Query("Select * from ChatList where id!= :id")
    public List<ChatList> getChatList(int id);
    @Insert
    public void insertChat(ChatList chatList);
    @Query("Select id from chatlist where user_name= :userName")
    public int getChatId(String userName);
}
