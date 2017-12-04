package com.swarawan.smsbanking.mandiri.menuitem;

import java.util.List;
import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.model.RiwayatModel;
import com.swarawan.smsbanking.sqlite.QuerySMS;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.TableLayout.LayoutParams;

public class MandiriSMSActivity extends Activity {
	private final String idBank = "1";
	private Activity activity = this;
	private LinearLayout linear;
	private LinearLayout.LayoutParams layoutParam;
	private EditText edIsiSMS;
	private ScrollView sc;
	private DialogSendSMS dSend;
	private QuerySMS qSMS;
	private String sms;
	private static String SEND = "SMS_SENT";
	private static String DELIVERED = "SMS_DELIVERED";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_sms);

		edIsiSMS = (EditText) findViewById(R.id.textSMSMandiri);
		sc = (ScrollView) findViewById(R.id.scrollmandiri);
		linear = (LinearLayout) findViewById(R.id.layoutNganuMandiri);
		layoutParam = new LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT,
				LinearLayout.LayoutParams.WRAP_CONTENT);
		layoutParam.setMargins(5, 5, 5, 0);
		dSend = new DialogSendSMS(activity);
		qSMS = new QuerySMS(this);
		sc.fullScroll(View.FOCUS_DOWN);

		getData();
	}

	private void getData() {
		List<RiwayatModel> k = qSMS.ambilIsiSMSMandiri();
		for (RiwayatModel rm : k) {
			TextView tx = new TextView(this);
			tx.setLayoutParams(layoutParam);
			tx.setTypeface(Typeface.DEFAULT, Typeface.BOLD);
			tx.setGravity(Gravity.CENTER_VERTICAL);
			tx.setPadding(25, 5, 5, 5);
			if (rm.getStatus().equals("1")) {
				tx.setBackgroundResource(R.drawable.box_sms_putih);
				tx.setText("Saya : " + rm.getRiwayat());
			} else if (rm.getStatus().equals("0")) {
				tx.setBackgroundResource(R.drawable.box_sms_biru);
				tx.setText("Bank : " + rm.getRiwayat());
			}
			linear.addView(tx);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.activity_main, menu);
		return true;
	}

	// @Override
	// public boolean onOptionsItemSelected(MenuItem item) {
	// switch (item.getItemId()) {
	// case R.id.menu_kirim: {
	// dSend.dialogSendAct(edIsiSMS.getText().toString(), idBank);
	// edIsiSMS.setText("");
	// }
	// }
	// return true;
	// }

	public void kirimSMS(View v) {
		sms = edIsiSMS.getText().toString();
		dSend.dialogSend2(sms, idBank);
		linear.removeAllViews();
		getData();
	}
}
