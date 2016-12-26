package com.mtaj.mtaj_08.calc_app.BackgroundServices;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.IBinder;
import android.support.v4.app.NotificationCompat;

import com.mtaj.mtaj_08.calc_app.Activities.CalculationActivity;
import com.mtaj.mtaj_08.calc_app.Activities.MainActivity;
import com.mtaj.mtaj_08.calc_app.R;

/**
 * Created by MTAJ-08 on 12/24/2016.
 */
public class MyAlarmService extends Service
{

    @Override
    public IBinder onBind(Intent arg0)
    {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void onCreate()
    {
        // TODO Auto-generated method stub
        super.onCreate();
    }

    @SuppressWarnings("static-access")
    @Override
    public void onStart(Intent intent, int startId)
    {
        super.onStart(intent, startId);

        Intent intent1 = new Intent(this.getApplicationContext(),CalculationActivity.class);

        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent1,
                PendingIntent.FLAG_UPDATE_CURRENT);
        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder notificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.calculator_128px)
                .setStyle(new NotificationCompat.BigTextStyle().bigText("Alarm Testing Demo"))
                .setContentTitle("MyCalc")
                .setContentText("MonthWise Alarm Testing Demo")
                .setAutoCancel(true)
                .setSound(defaultSoundUri)
                .setLargeIcon(BitmapFactory.decodeResource(getApplicationContext().getResources(), R.drawable.calculator_128px))
                .setContentIntent(pendingIntent);

        NotificationManager notificationManager =
                (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, notificationBuilder.build());
    }

    @Override
    public void onDestroy()
    {
        // TODO Auto-generated method stub
        super.onDestroy();
    }

}