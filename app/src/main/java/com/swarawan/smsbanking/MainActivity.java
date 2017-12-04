package com.swarawan.smsbanking;

import com.swarawan.smsbanking.bni.MenuBNI;
import com.swarawan.smsbanking.mandiri.MenuMandiri;
import com.swarawan.smsbanking.sqlite.QuerySMS;
import com.swarawan.smsbanking.widget.MyBackgroundService;
import com.swarawan.smsbanking.R;
import android.os.Bundle;
import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.support.v4.app.NavUtils;

public class MainActivity extends Activity implements OnClickListener {

	private ImageButton bMandiri, bBNI;
	private QuerySMS qSMS;

	private static final int NOTIFY_ME_ID = 1337;
	private int count = 0;
	private NotificationManager notifyMgr = null;
	private Notification notif;
	private PendingIntent pIntent;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		bMandiri = (ImageButton) findViewById(R.id.imgMandiri);
		bBNI = (ImageButton) findViewById(R.id.imgBNI);
		qSMS = new QuerySMS(this);
		qSMS.getInstance();

		bMandiri.setOnClickListener(this);
		bBNI.setOnClickListener(this);
		service();
	}

	private void service() {
		startService(new Intent(this, MyBackgroundService.class));
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imgMandiri:
			startActivity(new Intent(MainActivity.this, MenuMandiri.class));
			break;
		case R.id.imgBNI:
			startActivity(new Intent(MainActivity.this, MenuBNI.class));
			break;
		}
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();

		unbindDrawable(findViewById(R.id.layoutRoot));
		System.gc();
	}

	private void unbindDrawable(View view) {
		if (view.getBackground() != null) {
			view.getBackground().setCallback(null);
		}
		if (view instanceof ViewGroup) {
			for (int i = 0; i < ((ViewGroup) view).getChildCount(); i++) {
				unbindDrawable(((ViewGroup) view).getChildAt(i));
			}
			((ViewGroup) view).removeAllViews();
		}
	}

}
