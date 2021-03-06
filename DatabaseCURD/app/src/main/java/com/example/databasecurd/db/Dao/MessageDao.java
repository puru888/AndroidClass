package com.example.databasecurd.db.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.databasecurd.db.Entities.Message;

import java.util.List;

@Dao
public interface MessageDao {

    @Insert
    void insert(Message message);
    @Query("Select * from message where `from`= :fromId and `to`= :toId or `from`= :toId and `to`= :fromId order by date asc")
    List<Message> getMessages(int fromId, int toId);
    @Delete
    public void deleteMessage(Message message);
    @Query("Update message set isRead=1 where `from`= :fromId and `to`= :toId")
    public void updateIsRead(int fromId, int toId);
}
