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

public class TVKabelActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Spinner spTVKabel;
	private EditText edNoPelanggan, edJumlah;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_tvkabel);

		spTVKabel = (Spinner) findViewById(R.id.spinnerTVKabel);
		edJumlah = (EditText) findViewById(R.id.editJumlah_tvkabel);
		edNoPelanggan = (EditText) findViewById(R.id.editNoPelanggan_tvkabel);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_tvkabel);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spTVKabel.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		if (v.getId() == R.id.buttonKirim_tvkabel) {
			String noPel = edNoPelanggan.getText().toString();
			String jumlah = edJumlah.getText().toString();
			if (noPel.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + noPel + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " IDV";
			break;
		case 1:
			kode = " DGT";
			break;
		case 2:
			kode = " AST";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
}
