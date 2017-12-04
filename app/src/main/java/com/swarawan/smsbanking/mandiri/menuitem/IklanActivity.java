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

public class IklanActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spIklan;
	private EditText edNoAgen, edJumlah;
	private Button bKirimSMS;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_iklan);

		spIklan = (Spinner) findViewById(R.id.spinnerAgenIklan);
		edJumlah = (EditText) findViewById(R.id.editJumlah_iklan);
		edNoAgen = (EditText) findViewById(R.id.editNoAgen_iklan);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_iklan);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spIklan.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String jumlah = edJumlah.getText().toString();
		String noagen = edNoAgen.getText().toString();

		if (v.getId() == R.id.buttonKirim_iklan) {
			if (noagen.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + noagen + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " KMP";
			break;
		case 1:
			kode = " AXL";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
