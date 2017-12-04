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

public class AirlinesActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spAirlines;
	private EditText edKodeBeli;
	private Button bKirimSMS;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_pesawat);

		spAirlines = (Spinner) findViewById(R.id.spinnerAirlines);
		edKodeBeli = (EditText) findViewById(R.id.editKodePembelian_airlines);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_airlines);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spAirlines.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String kodebeli = edKodeBeli.getText().toString();
		if (v.getId() == R.id.buttonKirim_airlines) {
			if (kodebeli.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + kodebeli;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " GIA";
			break;
		case 1:
			kode = " RIA";
			break;
		case 2:
			kode = " ASA";
			break;
		case 3:
			kode = " LIO";
			break;
		case 4:
			kode = " MDL";
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
