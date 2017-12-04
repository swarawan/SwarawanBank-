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

public class PascaBayarActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Spinner spPascaBayar;
	private EditText edNoTelp;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_pasca_bayar);

		spPascaBayar = (Spinner) findViewById(R.id.spinnerProvider);
		edNoTelp = (EditText) findViewById(R.id.editTelp_pasca);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_pasca);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		spPascaBayar.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String notelp = edNoTelp.getText().toString();

		if (v.getId() == R.id.buttonKirim_pasca) {
			if (notelp.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR" + kode + " 1 " + notelp;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		kode = "";
		switch (position) {
		case 8:
			kode = " ESI";
			break;
		case 9:
			kode = " STO";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {

	}
}
