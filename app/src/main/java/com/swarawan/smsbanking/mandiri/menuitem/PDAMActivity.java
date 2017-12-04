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

public class PDAMActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Spinner spPDAM;
	private EditText edNoPelanggan;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_pdam);

		spPDAM = (Spinner) findViewById(R.id.spinnerPdam);
		edNoPelanggan = (EditText) findViewById(R.id.editNoPelanggan_pdam);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_pdam);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spPDAM.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String noPelanggan = edNoPelanggan.getText().toString();

		if (v.getId() == R.id.buttonKirim_pdam) {
			if (noPelanggan.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + noPelanggan;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " BDG";
			break;
		case 1:
			kode = " MLGKT";
			break;
		case 2:
			kode = " BATUKT";
			break;
		case 3:
			kode = " CRBKT";
			break;
		case 4:
			kode = " TGRKB";
			break;
		case 5:
			kode = " BGRKT";
			break;
		case 6:
			kode = " BGRKB";
			break;
		case 7:
			kode = " BEKASI";
			break;
		case 8:
			kode = " PALEMBANG";
			break;
		case 9:
			kode = " JAMBI";
			break;
		case 10:
			kode = " LAMPUNG";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
