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

public class TagihanKKActivity extends Activity implements OnClickListener {
	private Activity activity = this;
	private final String idBank = "1";
	private EditText edNoKartu, edTglLahir;
	private Button bKirimSMS;
	private String sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_tagihankk);

		edNoKartu = (EditText) findViewById(R.id.editNoKartu_infotagihankk);
		edTglLahir = (EditText) findViewById(R.id.editTglLahir_infotagihankk);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_infotagihankk);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String nokartu = edNoKartu.getText().toString();
		String tglLahir = edTglLahir.getText().toString();
		
		if (v.getId() == R.id.buttonKirim_infotagihankk) {
			if (nokartu.equals("") || tglLahir.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "TGH KK " + nokartu + " " + tglLahir;
				dSend.dialogSend(sms, idBank);
			}
		}
	}
}
