package com.kreeti.roomwords;

import android.app.Application;
import android.os.AsyncTask;
import android.util.Log;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {

    private WordDao wordDao;
    private LiveData<List<Word>> mWords;

    WordRepository(Application application){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(application);
        wordDao = db.wordDao();
        mWords = wordDao.getAllWords();
    }

    LiveData<List<Word>> getAllWords() {
        return mWords;
    }

    public void insert(Word word) {
        new insertAsyncTask(wordDao).execute(word);
    }

    private static class insertAsyncTask extends AsyncTask<Word, Void, Void> {

        private WordDao asyncDao;

        insertAsyncTask(WordDao wordDao) {
            asyncDao = wordDao;
        }

        @Override
        protected Void doInBackground(final Word... words) {
                for(Word w : words)
                    Log.d("words list", w.toString());
                asyncDao.insert(words[0]);
                return null;
        }
    }
}
