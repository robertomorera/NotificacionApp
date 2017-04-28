package com.roberto.notificacionapp;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lanzarNotificacion();
    }


    /**
     * Método que se encarga de lanzar la notification.
     */
    public void lanzarNotificacion(){
        //Creamos el builder para construir el formato de la notificación,
        NotificationCompat.Builder builder=new NotificationCompat.Builder(this);
        //Seteamos el icóno de la notificacion.
        builder.setSmallIcon(R.mipmap.ic_launcher);
        //Titulo de la notificación.
        builder.setContentTitle(Constantes.TITULO_NOTIFICACION);
        //Contenido de la notificación.
        builder.setContentText(Constantes.CONTENIDO_NOTIFICACION);
        //Fijo este parámetro para cuando el usuario pulse sobre la notificación se elimine.
        builder.setAutoCancel(true);
        //Creamos el intent para ir a la actividad principal y reproducir el video de saludo.
        Intent notificacionIntent=new Intent(this,ReproductorActivity.class);
        //Creamos el PendingIntent
        PendingIntent pendingIntent=PendingIntent.getActivity(this,(int)System.currentTimeMillis(),notificacionIntent,PendingIntent.FLAG_ONE_SHOT);
        //Asociamos al builder el pendingIntent.
        builder.setContentIntent(pendingIntent);
        //Lanzamos la notificación con el NotificationManager con el servicio de notificaciones del sistema.
        NotificationManager notificationManager=(NotificationManager)this.getSystemService(Context.NOTIFICATION_SERVICE);
        Notification notification=builder.build();
        //Notificamos la notificación.
        notificationManager.notify(100,notification);
    }

}



