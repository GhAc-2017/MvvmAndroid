package com.kreeti.roomwords;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {

    private final LayoutInflater inflater;
    private List<Word> words;

    WordListAdapter(Context context) {
        inflater = LayoutInflater.from(context);
    }
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemview = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new WordViewHolder(itemview);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        if(words != null) {
            Word current = words.get(position);
            holder.wordItemView.setText(current.getWord());
        }
        else
            holder.wordItemView.setText("no word");
    }

    void setWords(List<Word> words){
        this.words = words;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if(words != null)
            return words.size();
        else return 0;
    }

    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;
        public WordViewHolder(@NonNull View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }
    }
}
