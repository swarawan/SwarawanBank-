package com.swarawan.smsbanking.mandiri.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class AsuransiActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spAsuransi;
	private EditText edNoPolis, edJumlah;
	private Button bKirimSMS;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_asuransi);

		spAsuransi = (Spinner) findViewById(R.id.spinnerAsuransi);
		edJumlah = (EditText) findViewById(R.id.editJumlah_asuransi);
		edNoPolis = (EditText) findViewById(R.id.editNoPolis_asuransi);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_asuransi);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spAsuransi.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String jumlah = edJumlah.getText().toString();
		String polis = edNoPolis.getText().toString();

		if (v.getId() == R.id.buttonKirim_asuransi) {
			if (polis.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + polis + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " AXA";
			break;
		case 1:
			kode = " MAS";
			break;
		case 2:
			kode = " SML";
			break;
		case 3:
			kode = " CMG";
			break;
		case 4:
			kode = " BAJ";
			break;
		case 5:
			kode = " SEQ";
			break;
		case 6:
			kode = " AXF";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
}
