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

public class SCTVActivity extends Activity implements OnClickListener {
	private final String idBank = "1";
	private EditText edNoRef, edJumlah;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_sumbangansctv);

		edNoRef = (EditText) findViewById(R.id.editNoRef_sctv);
		edJumlah = (EditText) findViewById(R.id.editJumlah_sctv);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_sctv);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String noref = edNoRef.getText().toString();
		String jumlah = edJumlah.getText().toString();
		if (v.getId() == R.id.buttonKirim_sctv) {
			if (noref.equals("") && jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR PUNDI 1 " + noref + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}
}
