package com.example.examen;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface journalDAO {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insert(Journal id);

    @Query("DELETE FROM journal_table")
    void deleteAll();

    @Query("SELECT * from journal_table ")
    LiveData<List<Journal>> getAllWords();
}
