package com.roberto.notificacionapp;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class ReproductorActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reproductor);
        VideoView video=(VideoView)findViewById(R.id.video);
        String path="android.resource://"+getPackageName()+"/"+R.raw.ganan;
        //Construimos la uri para acceder al recurso del video.
        Uri uri=Uri.parse(path);
        //Seteamos la URI al VideoView.
        video.setVideoURI(uri);
        //Construimos los controles de reproducción
        video.setMediaController(new MediaController(this));
        video.requestFocus();
        //Reproducimos el video.
        video.start();
    }
}
