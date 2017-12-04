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

public class KuliahActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Spinner spUniv;
	private EditText edNim, edJumlah;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_bayarkuliah);

		spUniv = (Spinner) findViewById(R.id.spinnerUniv_kuliah);
		edJumlah = (EditText) findViewById(R.id.editJumlah_kuliah);
		edNim = (EditText) findViewById(R.id.editNIM_kuliah);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_kuliah);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spUniv.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String nim = edNim.getText().toString();
		String jumlah = edJumlah.getText().toString();

		if (v.getId() == R.id.buttonKirim_kuliah) {
			if (nim.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + nim + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " BSI";
			break;
		case 1:
			kode = " TRI";
			break;
		case 2:
			kode = " UNUD";
			break;
		case 3:
			kode = " UB";
			break;
		case 4:
			kode = " UNAIR";
			break;
		case 5:
			kode = " UBAYA";
			break;
		case 6:
			kode = " UUGM";
			break;
		case 7:
			kode = " UI";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
