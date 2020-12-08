package com.magic.androidcore;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.net.Uri;

//import android.support.v7.app.AppCompatActivity;
import android.provider.CalendarContract;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.Surface;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.MediaController;
import android.widget.VideoView;

public class FullScreenVideoActivity extends Fragment {

    private VideoView videoView;
    private MediaController mediaController;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_full_screen_video);
//
//        ReproducirVideo();
//
//    }
//
    public FullScreenVideoActivity() {

    }

public static  FullScreenVideoActivity  newInstance( String param1 , String param2){

    FullScreenVideoActivity fragment = new  FullScreenVideoActivity();
    return fragment;
}



    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

    View view =  inflater.inflate(R.layout.activity_full_screen_video, container, false);


        videoView = view.findViewById(R.id.videoView);
        String fullScreen = getActivity().getIntent().getStringExtra("fullScreenInd");


        if("y".equals(fullScreen)){
            getActivity(). getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
//            getSupportActionBar().hide();
        }

        Uri videoUri = Uri.parse("android.resource://"+getActivity().getPackageName()+"/"+R.raw.pizza_comercial_s);
        videoView.setVideoURI(videoUri);
        mediaController = new FullScreenMediaController(getContext());
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();


        return super.onCreateView(inflater, container, savedInstanceState);

    }

    //    private boolean isLandScape(){
//        Display display = ((WindowManager) getSystemService(WINDOW_SERVICE))
//                .getDefaultDisplay();
//        int rotation = display.getRotation();
//
//        if (rotation == Surface.ROTATION_90
//                || rotation == Surface.ROTATION_270) {
//            return true;
//        }
//        return false;
//    }


//    private  void ReproducirVideo(){
//
//
//        videoView = findViewById(R.id.videoView);
//        String fullScreen =  getIntent().getStringExtra("fullScreenInd");
//
//
//        if("y".equals(fullScreen)){
//            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
////            getSupportActionBar().hide();
//        }
//
//        Uri videoUri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pizza_comercial_s);
//        videoView.setVideoURI(videoUri);
//        mediaController = new FullScreenMediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.start();
//
//
////        if(isLandScape()){
////            mediaController = new FullScreenMediaController(this);
////        }else {
////            mediaController = new MediaController(this);
////        }
//
//    }
}