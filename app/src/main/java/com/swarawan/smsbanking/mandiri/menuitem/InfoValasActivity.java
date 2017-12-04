package com.swarawan.smsbanking.mandiri.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class InfoValasActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spValas;
	private Button bKirimSMS;
	private String sms, kodeValas = "";
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_valas);

		spValas = (Spinner) findViewById(R.id.spinnerValas);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_valas);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spValas.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.buttonKirim_valas) {
			sms = "FX" + kodeValas;
			dSend.dialogSend(sms, idBank);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kodeValas = " USD";
			break;
		case 1:
			kodeValas = " UAD";
			break;
		case 2:
			kodeValas = " CAD";
			break;
		case 3:
			kodeValas = " CHF";
			break;
		case 4:
			kodeValas = " NZD";
			break;
		case 5:
			kodeValas = " DKK";
			break;
		case 6:
			kodeValas = " GBP";
			break;
		case 7:
			kodeValas = " HKD";
			break;
		case 8:
			kodeValas = " JPY";
			break;
		case 9:
			kodeValas = " SGD";
			break;
		case 10:
			kodeValas = " EUR";
			break;
		case 11:
			kodeValas = " SEK";
			break;
		case 12:
			kodeValas = " NOK";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
}
