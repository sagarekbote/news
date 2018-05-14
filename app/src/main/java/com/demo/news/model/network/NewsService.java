package com.demo.news.model.network;

import com.demo.news.model.TopStoriesResponse;

import retrofit2.Response;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

/**
 * A retrofit interface which has all the supported network api calls
 */
public interface NewsService {

    @GET("/svc/topstories/v2/home.json")
    Observable<Response<TopStoriesResponse>> getTopStories(@Query("api-key") String apiKey);
}
