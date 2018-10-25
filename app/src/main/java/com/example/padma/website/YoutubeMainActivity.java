package com.example.padma.website;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayer.OnInitializedListener;
import com.google.android.youtube.player.YouTubePlayer.Provider;
import com.google.android.youtube.player.YouTubePlayerView;

public class YoutubeMainActivity extends YouTubeBaseActivity {

    private static final String TAG = "MainActivity";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.youtubemain);
        Log.d(TAG, "onCreate: Startin,");
        Button btnP =  findViewById(R.id.button);
        final YouTubePlayerView mYoutubePlayerView = (YouTubePlayerView) findViewById(R.id.youtubePlayerViewId);


       final OnInitializedListener mOnInitializedListener = new OnInitializedListener() {


            @Override
            public void onInitializationSuccess(Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                Log.d(TAG, "onClick, Done Initialising");
                youTubePlayer.loadVideo ("S43CFcpOZSI");
            }

            @Override
            public void onInitializationFailure(Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Log.d(TAG, "onClick, Failed to Initialise");

                }


        };

        btnP.setOnClickListener(new OnClickListener(){

               @Override
               public void onClick(View v)
               {
                   Log.d(TAG,"OnClick: Initialising YouTube Player");
                   mYoutubePlayerView.initialize(YoutubeConfig.getApiKey(),mOnInitializedListener);


               }
           });








    }


}
