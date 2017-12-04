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

public class PAMActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Spinner spPAM;
	private EditText edNoPelanggan;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_pam);

		spPAM = (Spinner) findViewById(R.id.spinnerPam);
		edNoPelanggan = (EditText) findViewById(R.id.editNoPelanggan_pam);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_pam);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spPAM.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String nopel = edNoPelanggan.getText().toString();

		if (v.getId() == R.id.buttonKirim_pam) {
			if (nopel.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + nopel;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " PAL";
			break;
		case 1:
			kode = " AET";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
