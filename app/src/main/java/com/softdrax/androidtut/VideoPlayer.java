package com.softdrax.androidtut;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoPlayer extends AppCompatActivity {
    VideoView vvVideoPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_player);

        vvVideoPlayer = findViewById(R.id.vvVideoPlayer);


        // local
        String localVideoPath = "android.resource://" + getPackageName() + "/raw/sample_video";

        //online
        String onlineVideoPath="https://bibekshrestha.info.np/assets/video/videoplayback.mp4";

        Uri vUri = Uri.parse(onlineVideoPath);

//        vvVideoPlayer.setVideoPath(localVideoPath);

        vvVideoPlayer.setVideoURI(vUri);

        // for media control

        MediaController mc = new MediaController(VideoPlayer.this);

        vvVideoPlayer.setMediaController(mc);
        mc.setAnchorView(vvVideoPlayer);

        vvVideoPlayer.start();

    }
}