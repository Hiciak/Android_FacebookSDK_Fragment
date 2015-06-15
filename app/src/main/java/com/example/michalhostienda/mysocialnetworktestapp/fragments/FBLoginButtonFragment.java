package com.example.michalhostienda.mysocialnetworktestapp.fragments;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.michalhostienda.mysocialnetworktestapp.R;

/**
 * Created by Michal.hostienda on 12/06/2015.
 */
public class FBLoginButtonFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View myViewToReturn = inflater.inflate(R.layout.fragment_fb_login_button, container, false);
        return myViewToReturn;
    }
}
