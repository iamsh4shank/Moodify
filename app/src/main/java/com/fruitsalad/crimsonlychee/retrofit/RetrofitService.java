package com.fruitsalad.crimsonlychee.retrofit;

import com.fruitsalad.crimsonlychee.model.Quote;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("quotes/all")
    Call<List<Quote>> getAllQuotes();

    @GET("quotes")
    Call<List<Quote>> getCategorizedQuotes(@Query("category") String category);

}
