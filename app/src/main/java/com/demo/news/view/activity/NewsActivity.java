package com.demo.news.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;

import com.demo.news.R;
import com.demo.news.model.Article;
import com.demo.news.view.OnArticleClickedListener;
import com.demo.news.view.adapter.NewsAdapter;
import com.demo.news.viewmodel.ArticlesViewModel;

import org.parceler.Parcels;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * An activity for showing the news list of the application
 */
public class NewsActivity extends AppCompatActivity implements OnArticleClickedListener {

    @BindView(R.id.recycler_view)
    RecyclerView mArticlesRecyclerView;
    private NewsAdapter mNewsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ButterKnife.bind(this);
        ArticlesViewModel homeViewModel = ViewModelProviders.of(this).get(ArticlesViewModel.class);
        homeViewModel.getArticles().observe(this, new Observer<List<Article>>() {
            @Override
            public void onChanged(@Nullable List<Article> articleList) {
                if (articleList != null && articleList.size() > 0) {
                    mNewsAdapter = new NewsAdapter(articleList, NewsActivity.this);
                    mArticlesRecyclerView.setAdapter(mNewsAdapter);
                }
            }
        });
    }

    @Override
    public void onArticleClicked(@NonNull Article article) {
        Intent detailsIntent = new Intent(this, NewsDetailsActivity.class);
        detailsIntent.putExtra(NewsDetailsActivity.INTENT_EXTRA_ARTICLE, Parcels.wrap(article));
        startActivity(detailsIntent);
    }
}
