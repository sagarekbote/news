package com.demo.news.view;

import com.demo.news.model.Article;

/**
 * An interface to be implemented by classes who want to listen for news item click
 * Additional comment
 */
public interface OnArticleClickedListener {
    void onArticleClicked(Article article);
}
