package com.swarawan.smsbanking.mandiri.menuitem;

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

public class IsiUlangPulsaActivity extends Activity implements OnClickListener,
		OnItemSelectedListener {
	private final String idBank = "1";
	private Activity activity = this;
	private Spinner spIsiPulsa, spNominal;
	private EditText edNoHP, edvocer;
	private Button bKirimSMS;
	private String kode = "", sms;
	private DialogSendSMS dSend;
	private ArrayAdapter<String> aa;
	private String[] arVocer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mandiri_isiulangpulsa);

		spIsiPulsa = (Spinner) findViewById(R.id.spinnerIsiPulsa);
		edNoHP = (EditText) findViewById(R.id.editNoHP_isipulsa);
		spNominal = (Spinner) findViewById(R.id.sp_nominal);
		// edvocer = (EditText) findViewById(R.id.textNilaiVoucher_isipulsa);

		bKirimSMS = (Button) findViewById(R.id.buttonKirim_isipulsa);
		dSend = new DialogSendSMS(activity);

		aa = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, new String[] { "25000",
						"50000", "150000", "200000", "300000", "500000",
						"1000000" });
		aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spNominal.setAdapter(aa);

		bKirimSMS.setOnClickListener(this);
		spIsiPulsa.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		String hp = edNoHP.getText().toString();
		String vocer = spNominal.getSelectedItem().toString();

		if (v.getId() == R.id.buttonKirim_isipulsa) {
			if (hp.equals("") || vocer == null) {
				Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
						Toast.LENGTH_SHORT).show();
			} else {
				sms = "ISI" + kode + " 1 " + hp + " " + vocer;
				dSend.dialogSend(sms, idBank);
			}
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		ArrayAdapter<String> ar = null;
		String[] nom = null;
		
		switch (position) {
		case 0:
			nom = new String[] { "25000", "50000", "150000", "200000",
					"300000", "500000", "1000000" };
			break;
		case 1:
			nom = new String[] { "25000", "50000", "100000", "250000",
					"500000", "1000000" };
			break;
		case 2:
			nom = new String[] { "25000", "50000", "75000", "100000", "150000" };
			break;
		case 3:
			nom = new String[] { "25000", "50000", "100000", "200000" };
			break;
		case 4:
			nom = new String[] { "25000", "50000", "100000", "150000",
					"200000", "300000", "500000" };
			break;
		case 5:
			nom = new String[] { "50000", "100000", "150000", "200000",
					"250000", "300000", "350000" };
			break;
		case 6:
			nom = new String[] { "25000", "50000", "100000", "150000", "250000" };
			break;
		case 7:
			nom = new String[] { "25000", "100000", "150000" };
			break;
		case 8:
			kode = " ESI";
			nom = new String[] { "20000", "50000", "100000", "200000" };
			break;
		case 9:
			kode = " STO";
			nom = new String[] { "20000", "50000", "100000", "200000" };
			break;
		}
		ar = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, nom);
		ar.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		spNominal.setAdapter(ar);
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
	}

	public void help(View v) {
		startActivity(new Intent(this, Help_Pulsa.class));
	}
}
