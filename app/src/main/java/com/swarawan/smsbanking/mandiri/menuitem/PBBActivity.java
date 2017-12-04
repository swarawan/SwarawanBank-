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

public class PBBActivity extends Activity implements OnClickListener {
	private final String idBank = "1";
	private EditText edNoPajak, edTahun;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_pbb);

		edNoPajak = (EditText) findViewById(R.id.editNoPajak_pbb);
		edTahun = (EditText) findViewById(R.id.editTahun_pbb);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_pbb);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String nopajak = edNoPajak.getText().toString();
		String tahun = edTahun.getText().toString();

		if (v.getId() == R.id.buttonKirim_airlines) {
			if (nopajak.equals("") || tahun.equals("")) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				sms = "BYR PBB 1 " + nopajak + " " + tahun;
				dSend.dialogSend(sms, idBank);
			}
		}
	}
}
