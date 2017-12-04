package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class IsiUlangPulsaBNIActivity extends Activity implements
		OnClickListener, OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spIsiPulsa, spNom;
	private EditText edNoHP, edvocer;
	private Button bKirimSMS;
	private String kode = "", sms;
	private DialogSendSMS dSend;
	private ArrayAdapter<String> arr, aarNom;
	private String[] data = { "Simpati", "As", "Mentari", "IM3", "StarOne",
			"XL Voucher", "XL Bebas Xtra", "Flexi", "Esia", "Fren", "3 (Three)" };
	private String[] nominal = { "25000", "50000", "75000", "100000" };
	private String[] arVocer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_isiulangpulsa);

		spIsiPulsa = (Spinner) findViewById(R.id.spinnerIsiPulsa);
		spNom = (Spinner) findViewById(R.id.sp_nominal);
		edNoHP = (EditText) findViewById(R.id.editNoHP_isipulsa);
		edvocer = (EditText) findViewById(R.id.textNilaiVoucher_isipulsa);
		bKirimSMS = (Button) findViewById(R.id.buttonKirim_isipulsa);
		dSend = new DialogSendSMS(activity);

		arr = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, data);
		arr.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spIsiPulsa.setPromptId(R.string.prompt_isipulsa_mandiri);
		spIsiPulsa.setAdapter(arr);
		aarNom = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nominal);
		aarNom.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spNom.setPromptId(R.string.prompt_nilaivocer_mandiri);
		spNom.setAdapter(aarNom);

		bKirimSMS.setOnClickListener(this);
		spIsiPulsa.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String hp = edNoHP.getText().toString();
		String vocer = spNom.getSelectedItem().toString();

		if (v.getId() == R.id.buttonKirim_isipulsa) {
			if (hp.equals("") || vocer == null) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
						Toast.LENGTH_SHORT).show();
			} else {
				sms = "TOP " + kode +" "+ hp + " " + vocer;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {

		kode = "";
		switch (position) {
		case 5:
			kode = " XL";
			break;
		case 6:
			kode = " XTRA";
			break;
		case 7:
			kode = " FLEXI";
			break;
		case 8:
			kode = " ESIA";
			break;
		case 9:
			kode = " FREN";
			break;
		case 10:
			kode = " 3";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	}

	public void help(View v) {
		Toast.makeText(getBaseContext(), "Layanan Belum Tersedia",
				Toast.LENGTH_SHORT).show();
	}
}
