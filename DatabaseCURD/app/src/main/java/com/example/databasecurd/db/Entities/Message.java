package com.example.databasecurd.db.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
@Entity
public class Message {
    @ColumnInfo
    private String message;
    @PrimaryKey
    private int from;
    @ColumnInfo
    private int to;
    @ColumnInfo
    private boolean isRead;

    public Message(String message,int from, int to, boolean isRead) {
        this.message = message;
        this.from = from;
        this.to = to;
        this.isRead = isRead;
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
