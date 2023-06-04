package com.example.newsappjava.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.newsappjava.databinding.RowNewsBinding;
import com.example.newsappjava.helper.HelperClass;
import com.example.newsappjava.model.NewsItem;
import com.squareup.picasso.Picasso;

import java.util.List;

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.ViewHolder> {

    List<NewsItem> list;
    Context context;

    public NewsAdapter(List<NewsItem> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        RowNewsBinding binding = RowNewsBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public RowNewsBinding binding;
        public ViewHolder(final RowNewsBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bind(NewsItem item){
            binding.tvTitle.setText(item.getJudul());
            binding.tvUsername.setText(item.getUserinput());
            binding.tvDate.setText(new HelperClass().convertDate(item.getTanggal()));
            Picasso.get().load(item.getCover()).into(binding.imgCover);
        }
    }
}
