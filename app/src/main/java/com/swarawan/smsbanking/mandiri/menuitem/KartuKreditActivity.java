package com.swarawan.smsbanking.mandiri.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.AdapterView.OnItemSelectedListener;

public class KartuKreditActivity extends Activity implements OnClickListener {
	private final String idBank = "1";
	private EditText edNoKK, edJumlah;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_kartukredit);

		edJumlah = (EditText) findViewById(R.id.editJumlah_kk);
		edNoKK = (EditText) findViewById(R.id.editNoKartu_kk);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_kk);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String jumlah = edJumlah.getText().toString();
		String nokk = edNoKK.getText().toString();

		if (v.getId() == R.id.buttonKirim_kk) {
			if (nokk.equals("") || jumlah.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR " + "KK" + " 1 " + nokk + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}
}
