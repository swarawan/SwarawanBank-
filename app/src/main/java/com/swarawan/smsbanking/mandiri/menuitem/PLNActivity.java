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

public class PLNActivity extends Activity implements OnClickListener {
	private final String idBank = "1";
	private EditText edNoPelanggan;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_pln);

		edNoPelanggan = (EditText) findViewById(R.id.editNoPelanggan_pln);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_pln);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String pel = edNoPelanggan.getText().toString();
		if (pel.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
		} else {
			sms = "BYR PLN 1 " + pel;
			dSend.dialogSend(sms, idBank);
		}
	}
}
