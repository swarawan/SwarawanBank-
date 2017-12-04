package com.swarawan.smsbanking.widget;

import com.swarawan.smsbanking.MainActivity;
import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.bni.menuitem.SMSBNIActivity;
import com.swarawan.smsbanking.mandiri.menuitem.MandiriSMSActivity;
import com.swarawan.smsbanking.model.RiwayatModel;
import com.swarawan.smsbanking.sqlite.QuerySMS;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class MySMSReceiver extends BroadcastReceiver {
    private final String NOMOR_MANDIRI = "3355";
    private final String NOMOR_BNI = "3346";
    private String alamat;
    private String pesan;
    private QuerySMS qSMS;
    private RiwayatModel rm;
    private static final int NOTIFY_ME_ID = 1337;
    private int count = 0;
    private NotificationManager notifyMgr = null;
    private Notification notif;
    private PendingIntent pIntent;

    public void onReceive(Context context, Intent intent) {
        qSMS = new QuerySMS(context);
        rm = new RiwayatModel();
        Bundle bundle = intent.getExtras();
        Object[] pdus = (Object[]) bundle.get("pdus");
        SmsMessage message = SmsMessage.createFromPdu((byte[]) pdus[0]);
        alamat = message.getOriginatingAddress();
        pesan = message.getMessageBody();
        notifyMgr = (NotificationManager) context
                .getSystemService(Context.NOTIFICATION_SERVICE);

        pIntent = PendingIntent.getActivity(context, 0, new Intent(context,
                MainActivity.class), 0);

        if (alamat.equals(NOMOR_MANDIRI)) {
            rm.setIdBank("1");
            rm.setRiwayat(pesan);
            rm.setStatus("0");
            qSMS.insertSMS(rm);
            notif(context, "1");
        } else if (alamat.equals(NOMOR_BNI)) {
            rm.setIdBank("2");
            rm.setRiwayat(pesan);
            rm.setStatus("0");
            qSMS.insertSMS(rm);
            notif(context, "2");
        }
    }

    @TargetApi(Build.VERSION_CODES.JELLY_BEAN)
    private void notif(Context c, String kode) {
        String judul = null;
        String text = "Klik untuk melihat";
        Notification.Builder builder = new Notification.Builder(c);
        if (kode.equals("1")) {
            judul = "SMS Mandiri";
            builder.setSmallIcon(R.drawable.yeah);
            builder.setTicker("SwarawanBank!");
            builder.setContentTitle(judul);
            builder.setContentText(text);

            notif = builder.build();
            notif.number = ++count;
            notif.defaults |= Notification.DEFAULT_VIBRATE;
            notif.defaults |= Notification.DEFAULT_SOUND;
            notif.flags |= Notification.FLAG_AUTO_CANCEL;
            notifyMgr.notify(NOTIFY_ME_ID, notif);
        } else if (kode.equals("2")) {
            judul = "SMS BNI";
            builder.setSmallIcon(R.drawable.yeah);
            builder.setTicker("SwarawanBank!");
            builder.setContentTitle(judul);
            builder.setContentText(text);

            notif = builder.build();
            notif.number = ++count;
            notif.defaults |= Notification.DEFAULT_VIBRATE;
            notif.defaults |= Notification.DEFAULT_SOUND;
            notif.flags |= Notification.FLAG_AUTO_CANCEL;
            notifyMgr.notify(NOTIFY_ME_ID, notif);
        }
    }
}
