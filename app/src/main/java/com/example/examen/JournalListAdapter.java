package com.example.examen;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class JournalListAdapter extends RecyclerView.Adapter<JournalListAdapter.WordViewHolder> {
    private final LayoutInflater mInflater;
    private List<Journal> mWords; // Cached copy of words

    JournalListAdapter(Context context) { mInflater = LayoutInflater.from(context); }

    @Override
    public WordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(WordViewHolder holder, int position) {
        if (mWords != null) {
            Journal current = mWords.get(position);
            holder.wordItemView.setText(current.getTitle());
            holder.wordItemView2.setText(current.getContent());
            holder.wordItemView3.setText((CharSequence) current.getDate());
        } else {
            // Covers the case of data not being ready yet.
            holder.wordItemView.setText("No Word");
            holder.wordItemView2.setText("No Word");
            holder.wordItemView3.setText("No Word");
        }
    }

    void setWords(List<Journal> words){
        mWords = words;
        notifyDataSetChanged();
    }

    // getItemCount() is called many times, and when it is first called,
    // mWords has not been updated (means initially, it's null, and we can't return null).
    @Override
    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        private final TextView wordItemView2;
        private final TextView wordItemView3;


        private WordViewHolder(View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView5);
            wordItemView2 = itemView.findViewById(R.id.textView4);
            wordItemView3 = itemView.findViewById(R.id.textView3);
        }
}}
