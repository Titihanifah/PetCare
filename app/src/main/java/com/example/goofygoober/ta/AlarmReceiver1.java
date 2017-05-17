package com.example.goofygoober.ta;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;

/**
 * Created by Faldy on 18/05/2017.
 */

public class AlarmReceiver1 extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent service1 = new Intent(context, NotificationService1.class);
        service1.setData((Uri.parse("custom://" + System.currentTimeMillis())));
        context.startService(service1);
    }
}