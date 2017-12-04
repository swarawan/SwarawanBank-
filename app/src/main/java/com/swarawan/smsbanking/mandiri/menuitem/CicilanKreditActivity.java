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

public class CicilanKreditActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spKreditor;
	private EditText edNoKontrak, edJumlah;
	private Button bKirimSMS;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_cicilan_kredit);

		spKreditor = (Spinner) findViewById(R.id.spinnerKreditor);
		edJumlah = (EditText) findViewById(R.id.editJumlah_cicilan);
		edNoKontrak = (EditText) findViewById(R.id.editNoKontrak_cicilan);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_cicilan);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spKreditor.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String jumlah = edJumlah.getText().toString();
		String nokontrak = edNoKontrak.getText().toString();

		if (v.getId() == R.id.buttonKirim_cicilan) {
			if (nokontrak.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + nokontrak + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " CITIPL";
			break;
		case 1:
			kode = " CITIFIN";
			break;
		case 2:
			kode = " ABNPL";
			break;
		case 3:
			kode = " ADR";
			break;
		case 4:
			kode = " OTO";
			break;
		case 5:
			kode = " SUN";
			break;
		case 6:
			kode = " SOF";
			break;
		case 7:
			kode = " COL";
			break;
		case 8:
			kode = " 21001";
			break;
		case 9:
			kode = " 21002";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub

	}
}
