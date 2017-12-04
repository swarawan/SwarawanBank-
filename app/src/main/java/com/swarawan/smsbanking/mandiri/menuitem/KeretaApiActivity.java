package com.swarawan.smsbanking.mandiri.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class KeretaApiActivity extends Activity implements OnClickListener {
	private final String idBank = "1";
	private EditText edKodeBeli;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_keretaapi);

		edKodeBeli = (EditText) findViewById(R.id.editKodePembelian_ka);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_ka);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String kodebeli = edKodeBeli.getText().toString();
		if (kodebeli.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
		} else {
			sms = "BYR KAI 1 " + kodebeli;
			dSend.dialogSend(sms, idBank);
		}
	}
}
