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

public class TransferBedaBankActivity extends Activity implements
		OnClickListener, OnCheckedChangeListener {
	private final String idBank = "1";
	private EditText edNoRekLain, edBerita, edJumlah;
	private Button bKirimSMS;
	private CheckBox cekbokBerita;
	private Activity activity = this;
	private String kode, sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_transbedabank);

		edNoRekLain = (EditText) findViewById(R.id.editNoRekLain_transbedabank);
		edBerita = (EditText) findViewById(R.id.editBerita);
		edJumlah = (EditText) findViewById(R.id.editJumlah_transbedabank);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_transbedabank);
		cekbokBerita = (CheckBox) findViewById(R.id.cbBerita);
		dSend = new DialogSendSMS(activity);

		bKirimSMS.setOnClickListener(this);
		cekbokBerita.setOnCheckedChangeListener(this);
	}

	@Override
	public void onClick(View v) {
		String rek = edNoRekLain.getText().toString();
		String jumlah = edJumlah.getText().toString();
		String berita = edBerita.getText().toString();

		if (v.getId() == R.id.buttonKirim_transbedabank) {
			if (rek.equals(null) || jumlah.equals(null)) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
			} else {
				if (cekbokBerita.isChecked()) {
					sms = "TRT 1 " + rek + " " + jumlah + " #" + berita;
				} else {
					sms = "TRT 1 " + rek + " " + jumlah;
				}
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
		if (isChecked) {
			edBerita.setEnabled(true);
		}
	}
}
