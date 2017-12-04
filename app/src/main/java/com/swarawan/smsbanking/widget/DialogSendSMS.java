package com.swarawan.smsbanking.widget;

import com.swarawan.smsbanking.model.RiwayatModel;
import com.swarawan.smsbanking.sqlite.QuerySMS;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;
import android.widget.Toast;

public class DialogSendSMS {
	private static String SEND = "SMS_SENT";
	private static String DELIVERED = "SMS_DELIVERED";
	private BroadcastReceiver sendBroadCast, deliveryBroadCast;
	private final String NOMOR_MANDIRI = "3355";
	private final String NOMOR_BNI = "3346";
	private Activity activity;
	private QuerySMS qSMS;
	private RiwayatModel rm;

	public DialogSendSMS(Activity activity) {
		this.activity = activity;
		qSMS = new QuerySMS(activity);
		rm = new RiwayatModel();
	}

	public void dialogSend(final String textSMS, final String idBank) {
		String nomor;
		if (idBank.equals("1")) {
			nomor = NOMOR_MANDIRI;
		} else {
			nomor = NOMOR_BNI;
		}
		AlertDialog.Builder builderExit = new AlertDialog.Builder(activity);
		builderExit.setTitle("Kirim ke " + nomor + "??");
		// builderExit.setMessage("Kirim SMS dengan format " + textSMS + "?");
		builderExit.setMessage(textSMS);
		builderExit.setCancelable(false);
		builderExit.setPositiveButton("Ya",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						kirim(activity, textSMS, idBank);
						// qSMS.insertSMS(textSMS, idBank);
						rm.setIdBank(idBank);
						rm.setRiwayat(textSMS);
						rm.setStatus("1");
						qSMS.insertSMS(rm);
						activity.finish();
					}
				});
		builderExit.setNegativeButton("Tidak",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				}).show();
	}

	public void dialogSend2(final String textSMS, final String idBank) {
		String nomor;
		if (idBank.equals("1")) {
			nomor = NOMOR_MANDIRI;
		} else {
			nomor = NOMOR_BNI;
		}
		AlertDialog.Builder builderExit = new AlertDialog.Builder(activity);
		builderExit.setTitle("Kirim ke " + nomor + "??");
		builderExit.setMessage(":: pin dirahasiakan ::");
		builderExit.setCancelable(false);
		builderExit.setPositiveButton("Ya!",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						kirim(activity, textSMS, idBank);
						// qSMS.insertSMS(textSMS, idBank);
						 rm.setIdBank(idBank);
						 rm.setRiwayat(":: pin dirahasiakan ::");
						 rm.setStatus("1");
						 qSMS.insertSMS(rm);
						activity.finish();
					}
				});
		builderExit.setNegativeButton("Tidak",
				new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				}).show();
	}

	public void kirim(Context context, String text, String idbank) {
		String nomor;
		sendBroadCast = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				switch (getResultCode()) {
				case Activity.RESULT_OK:
					Toast.makeText(activity.getBaseContext(), "SMS Terkirim!",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
					Toast.makeText(activity.getBaseContext(),
							"Generic Failure!", Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NO_SERVICE:
					Toast.makeText(activity.getBaseContext(), "No Service!",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_NULL_PDU:
					Toast.makeText(activity.getBaseContext(), "No PDU!",
							Toast.LENGTH_SHORT).show();
					break;
				case SmsManager.RESULT_ERROR_RADIO_OFF:
					Toast.makeText(activity.getBaseContext(), "Radio Off!",
							Toast.LENGTH_SHORT).show();
					break;
				}
			}
		};
		deliveryBroadCast = new BroadcastReceiver() {

			@Override
			public void onReceive(Context context, Intent intent) {
				if (getResultCode() == Activity.RESULT_OK) {
					Toast.makeText(activity.getBaseContext(),
							"SMS Terkirim yang ini!!", Toast.LENGTH_SHORT)
							.show();
				} else if (getResultCode() == Activity.RESULT_CANCELED) {
					Toast.makeText(activity.getBaseContext(), "SMS Gagal!",
							Toast.LENGTH_SHORT).show();
				}
			}
		};

		activity.registerReceiver(sendBroadCast, new IntentFilter(SEND));
		activity.registerReceiver(deliveryBroadCast,
				new IntentFilter(DELIVERED));

		PendingIntent pending = PendingIntent.getBroadcast(context, 0,
				new Intent(SEND), 0);
		PendingIntent delivered = PendingIntent.getBroadcast(context, 0,
				new Intent(DELIVERED), 0);

		SmsManager sms = SmsManager.getDefault();
		if (idbank.equals("1")) {
			nomor = NOMOR_MANDIRI;
		} else {
			nomor = NOMOR_BNI;
		}
		sms.sendTextMessage(nomor, null, text, pending, delivered);

		activity.unregisterReceiver(sendBroadCast);
		activity.unregisterReceiver(deliveryBroadCast);

	}
}
