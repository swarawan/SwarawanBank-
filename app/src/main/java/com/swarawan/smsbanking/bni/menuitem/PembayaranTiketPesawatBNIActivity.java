package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class PembayaranTiketPesawatBNIActivity extends Activity implements
		OnItemSelectedListener {
	private final String idBank = "2";
	private String kode, sms;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private Spinner spMaskapai;
	private EditText edKode, edNominal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_pembayarantiket);
		edKode = (EditText) findViewById(R.id.editKodePembayaran_bni);
		edNominal = (EditText) findViewById(R.id.editNominal_bni);
		spMaskapai = (Spinner) findViewById(R.id.spinnerMaskapai_bni);
		dSend = new DialogSendSMS(activity);

		spMaskapai.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " MANDALA";
			break;
		case 1:
			kode = " GARUDA";
			break;
		case 2:
			kode = " LION";
			break;
		case 3:
			kode = " AIRASIA";
			break;
		}
	}

	public void kirimSMS(View v) {
		String kod = edKode.getText().toString();
		String nom = edNominal.getText().toString();

		if (kod.equals("") || nom.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
					Toast.LENGTH_SHORT).show();
		} else {
			sms = "PAY" + kode + " " + kod + " " + nom;
			dSend.dialogSend(sms, idBank);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}
