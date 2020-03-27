package com.fruitsalad.crimsonlychee.ui.mood.pagerfragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.fruitsalad.crimsonlychee.R;
import com.fruitsalad.crimsonlychee.model.Quote;
import com.fruitsalad.crimsonlychee.retrofit.RetrofitInstance;
import com.fruitsalad.crimsonlychee.retrofit.RetrofitService;
import com.fruitsalad.crimsonlychee.ui.mood.pagerfragments.recycleradapters.QuotesRecyclerViewAdapter;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class QuotesFragment extends Fragment {

    private RecyclerView quotesRecyclerView;
    private List<Quote> data = null;
    private ProgressBar progressBar;

    public QuotesFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_quotes, container, false);
        quotesRecyclerView = view.findViewById(R.id.recycler_quotes);
        progressBar = view.findViewById(R.id.pb_quotes);
        getData();
        return view;
    }

    private void getData() {
        RetrofitService service = RetrofitInstance.getRetrofit().create(RetrofitService.class);
        service.getCategorizedQuotes("happiness").enqueue(new Callback<List<Quote>>() {
            @Override
            public void onResponse(Call<List<Quote>> call, Response<List<Quote>> response) {
                data = response.body();
                quotesRecyclerView.setAdapter(new QuotesRecyclerViewAdapter(data));
                Log.i("Fetched Data", data.toString());
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<Quote>> call, Throwable t) {
                Log.i("FETCH ERROR", t.getMessage());
            }
        });
    }
}
