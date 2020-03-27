package com.fruitsalad.crimsonlychee.ui.mood;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.fruitsalad.crimsonlychee.ui.mood.pagerfragments.PostsFragment;
import com.fruitsalad.crimsonlychee.ui.mood.pagerfragments.QuotesFragment;
import com.fruitsalad.crimsonlychee.ui.mood.pagerfragments.VideosFragment;

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        Fragment fragment = null;
        if (position == 0)
        {
            fragment = new QuotesFragment();
        }
        else if (position == 1)
        {
            fragment = new VideosFragment();
        }
        else if (position == 2)
        {
            fragment = new PostsFragment();
        }
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;
        if (position == 0)
        {
            title = "Quotes";
        }
        else if (position == 1)
        {
            title = "Videos";
        }
        else if (position == 2)
        {
            title = "Posts";
        }
        return title;
    }
}
