package com.magic.androidcore;

import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;


public class EsloganFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public EsloganFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment EsloganFragment.
     */
    // TODO: Rename and change types and number of parameters

    private VideoView videoView;
    private MediaController mediaController;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_eslogan, container, false);


        videoView = view.findViewById(R.id.videoView2);
//        String fullScreen = getActivity().getIntent().getStringExtra("fullScreenInd");


//        if("y".equals(fullScreen)){
//            getActivity(). getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
////            getSupportActionBar().hide();
//        }

        Uri videoUri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.pizza_comercial_s);
        videoView.setVideoURI(videoUri);
//        mediaController = new FullScreenMediaController(getContext());

        mediaController = new MediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();

        return  videoView;
    }
}