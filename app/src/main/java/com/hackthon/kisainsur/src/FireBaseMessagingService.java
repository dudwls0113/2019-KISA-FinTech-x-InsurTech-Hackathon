package com.hackthon.kisainsur.src;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.TaskStackBuilder;
import android.content.Context;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.util.Log;

import androidx.core.app.NotificationCompat;

import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;
import com.hackthon.kisainsur.R;
import com.hackthon.kisainsur.src.main.MainActivity;

import java.util.Random;

import static com.hackthon.kisainsur.src.ApplicationClass.channel_id;


public class FireBaseMessagingService extends FirebaseMessagingService {


    @Override
    public void onNewToken(String s) {
        super.onNewToken(s);
        Log.e("Firebase", "FireBaseMessagingService : " + s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {

//        Log.d("messageRe", remoteMessage.getFrom());

        if (remoteMessage != null && remoteMessage.getData().size() > 0) {
            Log.d("message", "Message Notification Body: " + remoteMessage.getData().get("message"));
//            final boolean pushEvent = sSharedPreferences.getBoolean("pushEvent", true);
//            if (pushEvent) {
//            sendNotification(remoteMessage);
            sendNotification(remoteMessage.getData().get("title"), remoteMessage.getData().get("message"), Integer.parseInt(remoteMessage.getData().get("travelNo")));
//            }
        }
    }


//    private void sendNotification(RemoteMessage remoteMessage) {
//        String title = remoteMessage.getData().get("title");
//        String message = remoteMessage.getData().get("message");
//        int postNo = Integer.parseInt(remoteMessage.getData().get("postNo"));
//        Intent intent = new Intent(this, PostActivity.class);
//        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
//        stackBuilder.addParentStack(PostActivity.class);
//        stackBuilder.addNextIntent(intent);
////        intent.putExtra("pushFlag", true);
//        intent.putExtra("postNo", postNo);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//        PendingIntent pendingIntent = stackBuilder.getPendingIntent(channel_id, PendingIntent.FLAG_UPDATE_CURRENT);
//        final String CHANNEL_ID = "channelId";
//        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
//            final String CHANNEL_NAME = "channelName";
//            final String CHANNEL_DESCRIPTION = "channelDescription";
//            final int importance = NotificationManager.IMPORTANCE_HIGH;
//
//            NotificationChannel mChannel = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, importance);
//            mChannel.setDescription(CHANNEL_DESCRIPTION);
//            mChannel.enableLights(true);
//            mChannel.enableVibration(true);
//            mChannel.setVibrationPattern(new long[]{100, 200, 100, 200});
//            mChannel.setLockscreenVisibility(Notification.VISIBILITY_PRIVATE);
//            notificationManager.createNotificationChannel(mChannel);
//        }
//        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID);
//        builder.setAutoCancel(true);
//        builder.setDefaults(Notification.DEFAULT_ALL);
//        builder.setWhen(System.currentTimeMillis());
//        builder.setSmallIcon(R.mipmap.ic_launcher);
//        builder.setContentText(message);
//        builder.setContentTitle(title);
//        builder.setContentIntent(pendingIntent);
//
//        notificationManager.notify(channel_id, builder.build());
//        channel_id++;
//        if (channel_id == 100) {
//            channel_id = 0;
//        }
//
//    }


    private void sendNotification(String messageTitle, String messageBody, int travelNo) {


        Intent intent = new Intent(this, MainActivity.class);
        TaskStackBuilder stackBuilder = TaskStackBuilder.create(this);
        stackBuilder.addParentStack(MainActivity.class);
        stackBuilder.addNextIntent(intent);
//        intent.putExtra("pushFlag", true);
        intent.putExtra("travelNo", travelNo);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        PendingIntent pendingIntent = stackBuilder.getPendingIntent(channel_id, PendingIntent.FLAG_UPDATE_CURRENT);

//        String channelId = getString(R.string.default_notification_channel_id);
        String channelId = String.valueOf(new Random().nextInt(10000));

        Uri defaultSoundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);

        NotificationCompat.Builder notificationBuilder = null;
        notificationBuilder = new NotificationCompat.Builder(this, channelId)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle(messageTitle)
                .setContentText(messageBody)
                .setStyle(new NotificationCompat.BigTextStyle()
                        .bigText(messageBody))
                .setSound(defaultSoundUri)
                .setGroup("com.hackthon.kisainsur")
                .setContentIntent(pendingIntent)
                .setAutoCancel(true);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            String channelName = "HACKATHON";
            NotificationChannel channel = new NotificationChannel(channelId, channelName, NotificationManager.IMPORTANCE_HIGH);
            notificationManager.createNotificationChannel(channel);
        }

        notificationManager.notify(new Random().nextInt(10000), notificationBuilder.build());

    }


}
