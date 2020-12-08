package com.magic.androidcore.framentos_drawer.home;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.MediaController;
import android.widget.VideoView;

import com.magic.androidcore.EsloganFragment;
import com.magic.androidcore.FullScreenVideoActivity;
import com.magic.androidcore.R;


public class HomeActivity extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        return root;
    }

}