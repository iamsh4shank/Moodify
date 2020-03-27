package com.fruitsalad.crimsonlychee.ui.mood;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.fruitsalad.crimsonlychee.R;
import com.fruitsalad.crimsonlychee.model.Quote;
import com.fruitsalad.crimsonlychee.retrofit.RetrofitInstance;
import com.fruitsalad.crimsonlychee.retrofit.RetrofitService;
import com.google.android.material.tabs.TabLayout;



public class MoodFragment extends Fragment {

    // TODO: Put the mood stuff here

    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_mood, container, false);

        viewPager = root.findViewById(R.id.viewPager);
        viewPagerAdapter = new ViewPagerAdapter(getChildFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = root.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        return root;
    }
}