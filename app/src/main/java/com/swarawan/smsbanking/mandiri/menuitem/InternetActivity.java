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

public class InternetActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Spinner spProvider;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;
	private EditText edNoPelanggan, edJumlah;
	private Button bKirimSMS;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_internet);

		spProvider = (Spinner) findViewById(R.id.spinnerProvider_internet);
		edJumlah = (EditText) findViewById(R.id.editJumlah_internet);
		edNoPelanggan = (EditText) findViewById(R.id.editPelanggan_internet);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_internet);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spProvider.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String jumlah = edJumlah.getText().toString();
		String nopel = edNoPelanggan.getText().toString();

		if (v.getId() == R.id.buttonKirim_internet) {
			if (nopel.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + nopel + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " SAT";
			break;
		case 1:
			kode = " CBN";
			break;
		}

	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
