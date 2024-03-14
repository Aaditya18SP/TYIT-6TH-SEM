package com.example.tyit_29_prac1.Prac10;

import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyit_29_prac1.R;

public class VideoActivity extends AppCompatActivity {

    VideoView videoView;
    Button btnVideoActPlayVideo, btnVideoActPauseVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        videoView = findViewById(R.id.vvVideoACT);
        btnVideoActPlayVideo = findViewById(R.id.btnVideoActPlayVideo);
        btnVideoActPauseVideo = findViewById(R.id.btnVideoActPauseVideo);


        try {

            MediaController mediaController = new MediaController(VideoActivity.this);
            mediaController.setAnchorView(videoView);
            videoView.setMediaController(mediaController);
            Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video_1);
            videoView.setVideoURI(uri);
            Log.d("VIDEO_ACT", "PACKAGE NAME:" + getPackageName());

        } catch (Exception e) {
            Log.d("VIDEO_ACT", "Error:" + e.toString());
        }

        //PLAY THE VIDEO
        btnVideoActPlayVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //videoView.requestFocus();
                Log.d("VIDEO_ACT", "INSIDE PLAY ON CLICK LISTENER");
                videoView.start();

            }
        });

        //PAUSE THE VIDEO
        btnVideoActPauseVideo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (videoView.isPlaying()) {
                    videoView.pause();
                }
            }
        });


    }
}