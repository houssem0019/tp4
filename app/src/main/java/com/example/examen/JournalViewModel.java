package com.example.examen;

import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import java.util.List;

public class JournalViewModel extends AndroidViewModel {
    private JournalRepository mRepository;

    private LiveData<List<Journal>> mAllWords;

    public JournalViewModel (Application application) {
        super(application);
        mRepository = new JournalRepository(application);
        mAllWords = mRepository.getAllWords();
    }

    LiveData<List<Journal>> getAllWords() { return mAllWords; }

    public void insert(Journal id) { mRepository.insert(id); }
}
