package com.example.databasecurd.db.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Message {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String message;
    @ColumnInfo(name = "user_name")
    private String userName;
    @ColumnInfo
    private int from;
    @ColumnInfo
    private int to;
    @ColumnInfo
    private boolean isRead;

    public Message(String message, String userName, int from, int to, boolean isRead) {
        this.message = message;
        this.userName = userName;
        this.from = from;
        this.to = to;
        this.isRead = isRead;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getFrom() {
        return from;
    }

    public void setFrom(int from) {
        this.from = from;
    }

    public int getTo() {
        return to;
    }

    public void setTo(int to) {
        this.to = to;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
