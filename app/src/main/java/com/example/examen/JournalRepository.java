package com.example.examen;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class JournalRepository {
    private journalDAO journalDAO;
    private LiveData<List<Journal>> mAllWords;

    JournalRepository(Application application) {
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        journalDAO = db.wordDao();
        mAllWords = journalDAO.getAllWords();
    }

    LiveData<List<Journal>> getAllWords() {
        return mAllWords;
    }

    public void insert (Journal word) {
        new insertAsyncTask(journalDAO).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Journal, Void, Void> {

        private journalDAO mAsyncTaskDao;

        insertAsyncTask(journalDAO dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Journal... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

}
