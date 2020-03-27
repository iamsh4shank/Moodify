package com.fruitsalad.crimsonlychee.ui.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.fruitsalad.crimsonlychee.R;

public class ProfileFragment extends Fragment {

    // TODO: Put the profile stuff here

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_profile, container, false);

        return root;
    }
}