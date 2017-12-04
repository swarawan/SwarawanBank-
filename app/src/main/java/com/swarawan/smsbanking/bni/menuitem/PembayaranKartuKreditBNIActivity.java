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

public class PembayaranKartuKreditBNIActivity extends Activity implements
		OnItemSelectedListener {
	private final String idBank = "2";
	private String kode, sms;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private Spinner spKK;
	private EditText edNo, edNominal;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_pembayarankartukredit);
		edNo = (EditText) findViewById(R.id.editNoKK_bni);
		edNominal = (EditText) findViewById(R.id.editNominal_bni);
		spKK = (Spinner) findViewById(R.id.spinnerKK_bni);
		dSend = new DialogSendSMS(activity);

		spKK.setOnItemSelectedListener(this);
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		switch (position) {
		case 0:
			kode = " BNI";
			break;
		case 1:
			kode = " SCB";
			break;
		case 2:
			kode = " HSBC";
			break;
		case 3:
			kode = " NIAGA";
			break;
		case 4:
			kode = " ABNAMRO";
			break;
		case 5:
			kode = " ANZ";
			break;
		case 6:
			kode = " GE";
			break;
		case 7:
			kode = " MEGA";
			break;
		case 8:
			kode = " CITIBANK";
			break;
		case 9:
			kode = " DANAMON";
			break;
		case 10:
			kode = " PERMATA";
			break;
		case 11:
			kode = " BUKOPIN";
			break;
		case 12:
			kode = " AMEX";
			break;
		}
	}

	public void kirimSMS(View v) {
		String no = edNo.getText().toString();
		String nom = edNominal.getText().toString();

		if (no.equals("") || nom.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
					Toast.LENGTH_SHORT).show();
		} else {
			sms = "PAY" + kode + " " + no + " " + nom;
			dSend.dialogSend(sms, idBank);
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}
