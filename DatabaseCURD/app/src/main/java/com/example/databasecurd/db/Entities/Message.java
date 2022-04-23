package com.example.databasecurd.db.Entities;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import java.sql.Timestamp;
import java.util.Date;

@Entity(foreignKeys = @ForeignKey(entity = ChatList.class, parentColumns = "id", childColumns = "to"))
public class Message {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @ColumnInfo
    private String message;
    @ColumnInfo
    private int from;
    @ColumnInfo
    private int to;
    @TypeConverters({Converter.class})
    private Date date;
    @ColumnInfo
    private boolean isRead;

    public Message(String message, int from, int to, boolean isRead) {
        this.message = message;
        this.from = from;
        this.to = to;
        date = new Date(System.currentTimeMillis());
        this.isRead = isRead;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
