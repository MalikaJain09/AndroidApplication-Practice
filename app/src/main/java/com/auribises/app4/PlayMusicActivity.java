package com.auribises.app4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class PlayMusicActivity extends AppCompatActivity implements View.OnClickListener {


    TextView txtSongName;
    Button btnPlay,btnStop;
    String path;
    String songName;

    MediaPlayer mediaPlayer;

    void initViews(){
        txtSongName=findViewById(R.id.textSongName);
        btnPlay=findViewById(R.id.buttonPlay);
        btnStop=findViewById(R.id.buttonStop);

        btnPlay.setOnClickListener(this);
        btnStop.setOnClickListener(this);

        Intent rcv=getIntent();
        songName= rcv.getStringExtra("keySong");
        txtSongName.setText(songName);
        path = "/sdcard/Download";
        mediaPlayer = new MediaPlayer();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        initViews();
    }

    @Override
    public void onClick(View view) {
        if(view.getId()== R.id.buttonPlay){
            try {
                mediaPlayer.setDataSource(path+"/"+songName);
                mediaPlayer.prepare();
                mediaPlayer.start();
            }catch (Exception e){
                e.printStackTrace();
            }
        }else {
            mediaPlayer.stop();
            mediaPlayer.release();
            finish();
        }
    }
}
