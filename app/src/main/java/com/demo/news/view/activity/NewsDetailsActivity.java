package com.demo.news.view.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.demo.news.R;
import com.demo.news.model.Article;
import com.demo.news.viewmodel.NewsDetailsViewModel;

import org.parceler.Parcels;

import butterknife.BindView;
import butterknife.ButterKnife;
/**
 * An activity for showing the news details
 * change 3
 */
public class NewsDetailsActivity extends AppCompatActivity {

    public static final String INTENT_EXTRA_ARTICLE = "article";
    @BindView(R.id.title)
    TextView mTitle;
    @BindView(R.id.description)
    TextView mDescription;
    @BindView(R.id.image_view)
    ImageView mImageView;
    private NewsDetailsViewModel mDetailsViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);
        init();
    }

    private void init() {
        mDetailsViewModel = ViewModelProviders.of(this).get(NewsDetailsViewModel.class);
        Article article = Parcels.unwrap(getIntent().getParcelableExtra(NewsDetailsActivity.INTENT_EXTRA_ARTICLE));
        mDetailsViewModel.setArticle(article);
        mDetailsViewModel.getArticleList().observe(this, new Observer<Article>() {
            @Override
            public void onChanged(@Nullable Article article) {
                mTitle.setText(article.getTitle());
                mDescription.setText(article.getAbstract());
                if (article.getImageUrl() != null) {
                    Glide.with(NewsDetailsActivity.this).load(article.getImageUrl())
                            .apply(new RequestOptions()
                                    .placeholder(new ColorDrawable(ContextCompat.getColor(NewsDetailsActivity.this, R.color.placeholder_gray)))
                                    .error(R.mipmap.ic_launcher)
                                    .dontAnimate())
                            .into(mImageView);
                }
            }
        });
    }
}
