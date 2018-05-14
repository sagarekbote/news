package com.demo.news.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.demo.news.R;
import com.demo.news.model.Article;
import com.demo.news.view.OnArticleClickedListener;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Adapter for the top stories UI
 */
public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsListViewHolder> {

    private List<Article> mNewsList;
    private OnArticleClickedListener mClickListener;

    public NewsAdapter(@NonNull List<Article> newsList, OnArticleClickedListener clickedListener) {
        mNewsList = newsList;
        mClickListener = clickedListener;
    }

    public void setNewsList(@NonNull List<Article> newsList) {
        mNewsList = newsList;
        notifyItemRangeInserted(0, mNewsList.size());
    }

    @Override
    public NewsListViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.news_list_item, parent, false);
        return new NewsListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsListViewHolder holder, int position) {
        Article article = mNewsList.get(position);
        holder.title.setText(article.getTitle());
        holder.description.setText(article.getAbstract());
        holder.itemView.setTag(article);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onArticleClicked((Article) v.getTag());
            }
        });
    }

    @Override
    public int getItemCount() {
        return mNewsList == null ? 0 : mNewsList.size();
    }

    static class NewsListViewHolder extends RecyclerView.ViewHolder {

        @BindView(R.id.title)
        TextView title;
        @BindView(R.id.description)
        TextView description;

        public NewsListViewHolder(View view) {
            super(view);
            ButterKnife.bind(this, view);
        }
    }
}
