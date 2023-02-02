package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.IOException;

public class MusicPlayer extends AppCompatActivity {
    Button btnAudioPlay, btnAudioStop, btnAudioPause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);
        btnAudioPlay=findViewById(R.id.btnAudioPlay);
        btnAudioPause=findViewById(R.id.btnAudioPause);
        btnAudioStop=findViewById(R.id.btnAudioStop);

        // offline audio
        String audioPath = "android.resource://" + getPackageName() + "/raw/besharam_rang";

        //audio from online

        String onlineAudioPath="http://lfcc.com.np/music/besharam_rang.mp3";



        MediaPlayer mediaPlayer = new MediaPlayer();

        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);

        Uri audioUri = Uri.parse(audioPath);
        Uri onlineAudio=Uri.parse(onlineAudioPath);


        try {
            mediaPlayer.setDataSource(this, audioUri);
            mediaPlayer.prepare();
        } catch (IOException e) {
            e.printStackTrace();
        }

        // play
        btnAudioPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.start();
            }
        });

        // pause
        btnAudioPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
            }
        });

        // stop
        btnAudioStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mediaPlayer.pause();
                mediaPlayer.seekTo(0);
            }
        });

        //mediaPlayer.seek()==skip by provided time

        //mediaPlayer.getDuration()===duration of current media

        //mediaPlayer.getCurrentPosition()===provides current duration of playing audio


    }
}