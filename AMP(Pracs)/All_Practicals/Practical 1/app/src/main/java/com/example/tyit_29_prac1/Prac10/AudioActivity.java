package com.example.tyit_29_prac1.Prac10;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tyit_29_prac1.R;

public class AudioActivity extends AppCompatActivity {
    Button btnAudioPlay, btnAudioPause, btnAudioStop;
    MediaPlayer mediaPlayer;
    SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        mediaPlayer = MediaPlayer.create(this, R.raw.tum_saath_ho);
        seekBar = findViewById(R.id.prac10AudioSeekBar);


        btnAudioPlay = findViewById(R.id.audioPlay);
        btnAudioPause = findViewById(R.id.audioPause);
        btnAudioStop = findViewById(R.id.audioStop);

        btnAudioPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
                mediaPlayer.setLooping(true);
                //mediaPlayer.seekTo();
            }
        });


        btnAudioPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                }
            }
        });

        btnAudioStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()) {
                    mediaPlayer.stop();
                }
                try {
                    mediaPlayer.prepare();
                } catch (Exception e) {
                    Log.d("AUDIO_ACT", "Error:" + e.toString());
                }
            }
        });


        //SEEKBAR
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Log.d("AUDIO_ACT", "Progress value from seekbar:" + progress);
                int earlierProgress = 10;
                int mode;
                if (earlierProgress <= progress) {
                    mode = MediaPlayer.SEEK_NEXT_SYNC;
                } else {
                    mode = MediaPlayer.SEEK_PREVIOUS_SYNC;
                }

                Log.d("AUDIO_ACT", "Current mode to sync:" + mode);
                Log.d("AUDIO_ACT", "Duration to seek to:" + (long) (mediaPlayer.getDuration() * (progress / 100.0)));

                //mediaPlayer.pause();

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    mediaPlayer.seekTo((long) (mediaPlayer.getDuration() * (progress / 100.0)), mode);
                }

                //mediaPlayer.start();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}