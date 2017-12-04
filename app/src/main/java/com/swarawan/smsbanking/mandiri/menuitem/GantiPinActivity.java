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

public class GantiPinActivity extends Activity implements OnClickListener {
	private Activity activity = this;
	private final String idBank = "1";
	private EditText edPinLama, edPinBaru, edKonfirmPinBaru;
	private Button bKirimSMS;
	private String sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_gantipin);

		edPinLama = (EditText) findViewById(R.id.editPinLama);
		edPinBaru = (EditText) findViewById(R.id.editPinBaru);
		edKonfirmPinBaru = (EditText) findViewById(R.id.editKonfirmasiPinBaru);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_gantiPin);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String pb = edPinBaru.getText().toString();
		String pl = edPinLama.getText().toString();
		String pk = edKonfirmPinBaru.getText().toString();
		if (v.getId() == R.id.buttonKirim_infotagihankk) {
			if (pb.equals("") || pl.equals("") || pk.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				if (!pb.equals(pk)) {
					Toast.makeText(getBaseContext(), "Pin Baru Tidak Sama..",
							Toast.LENGTH_LONG).show();
					edPinBaru.setText("");
					edKonfirmPinBaru.setText("");
				} else {
					sms = "PIN " + pl + " " + pb + " " + pb;
					dSend.dialogSend(sms, idBank);
				}
			}
		}
	}
}
