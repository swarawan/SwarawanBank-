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
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class TransferMandiriActivity extends Activity implements
		OnClickListener {
	private final String idBank = "1";
	private EditText edNoRek2, edJumlah;
	private Button bKirimSMS;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_transantarsendiri);

		edNoRek2 = (EditText) findViewById(R.id.editNoRek2_transmandiri);
		edJumlah = (EditText) findViewById(R.id.editJumlah_transmandiri);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_transmandiri);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		String jumlah = edJumlah.getText().toString();
		String norek = edNoRek2.getText().toString();
		if (norek.equals("") || jumlah.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
		} else {
			if (v.getId() == R.id.buttonKirim_transmandiri) {
				sms = "TRS 1 " + norek + " " + jumlah;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

}
