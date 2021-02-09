package com.example.examen;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import java.util.Date;
@Entity(tableName = "journal_table")
public class Journal {
    @NonNull
    @ColumnInfo(name = "Title")
    private String Title ;
    @NonNull
    @ColumnInfo(name = "Content")
    private String Content ;
    @NonNull
    @PrimaryKey
    @ColumnInfo(name = "id")
    private  int id ;
    @NonNull
    @TypeConverters(DateConverter.class)
    @ColumnInfo(name = "Date")
    private Date Date ;

    public Journal(@NonNull String title, @NonNull String content, int id, @NonNull java.util.Date date) {
        Title = title;
        Content = content;
        this.id = id;
        Date = date;
    }

    public Journal(@NonNull String title, @NonNull String content, @NonNull java.util.Date date) {
        Title = title;
        Content = content;
        Date = date;
    }

    public Journal() {
    }

    public Journal(String stringExtra) {

    }

    @NonNull
    public String getTitle() {
        return Title;
    }

    public void setTitle(@NonNull String title) {
        Title = title;
    }

    @NonNull
    public String getContent() {
        return Content;
    }

    public void setContent(@NonNull String content) {
        Content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @NonNull
    public java.util.Date getDate() {
        return Date;
    }

    public void setDate(@NonNull java.util.Date date) {
        Date = date;
    }


}