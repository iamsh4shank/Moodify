package com.fruitsalad.crimsonlychee.ui.mood.pagerfragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import com.fruitsalad.crimsonlychee.R;

public class VideosFragment extends Fragment {

    private RecyclerView videoRecyclerView;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_vidoes, container, false);
        videoRecyclerView = view.findViewById(R.id.recycler_videos);
        return view;
    }

}
