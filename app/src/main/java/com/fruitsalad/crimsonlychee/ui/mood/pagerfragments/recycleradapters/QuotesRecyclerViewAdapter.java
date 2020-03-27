package com.fruitsalad.crimsonlychee.ui.mood.pagerfragments.recycleradapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.fruitsalad.crimsonlychee.R;
import com.fruitsalad.crimsonlychee.model.Quote;

import java.util.List;

public class QuotesRecyclerViewAdapter extends RecyclerView.Adapter<QuotesRecyclerViewAdapter.QuotesViewHolder> {

    private List<Quote> quoteList;
    private Context context;

    public QuotesRecyclerViewAdapter(List<Quote> quoteList) {
        this.quoteList = quoteList;
    }

    public QuotesRecyclerViewAdapter(List<Quote> quoteList, Context context) {
        this.quoteList = quoteList;
        this.context = context;
    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.quote_recycler_item, parent, false);
        return new QuotesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuotesViewHolder holder, int position) {
        holder.quote.setText(quoteList.get(position).getQuote());
    }

    @Override
    public int getItemCount() {
        return quoteList.size();
    }

    class QuotesViewHolder extends RecyclerView.ViewHolder {

        TextView quote;

        public QuotesViewHolder(@NonNull View itemView) {
            super(itemView);
            quote = itemView.findViewById(R.id.tv_quote);
        }
    }

}
