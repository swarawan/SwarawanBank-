package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class PembayaranTagihanBNI extends Activity implements
		OnItemSelectedListener {
	private final String idBank = "2";
	private String kode, sms, kodeTambahan;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private Spinner spTagihan;
	private EditText edNo;
	private TextView tx;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_pembayarantagihant);
		edNo = (EditText) findViewById(R.id.editNo_bni);
		spTagihan = (Spinner) findViewById(R.id.spinnerTagihan_bni);
		tx = (TextView) findViewById(R.id.tx);
		dSend = new DialogSendSMS(activity);

		spTagihan.setOnItemSelectedListener(this);
	}

	public void kirimSMS(View v) {
		String no =edNo.getText().toString();
		
		if(no.equals("")){
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
					Toast.LENGTH_SHORT).show();
		}else{
		sms = "PAY" + kode + " " + kodeTambahan + no;
		dSend.dialogSend(sms, idBank);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		kode = "";
		kodeTambahan = "";
		switch (position) {
		case 0:
		case 7:
			kode = " TELKOM";
			break;
		case 1:
			kode = " TELKOM";
			kodeTambahan = "0";
			break;
		case 2:
			kode = " PLN";
			break;
		case 3:
			kode = " HALO";
			break;
		case 4:
			kode = " MATRIX";
			break;
		case 5:
			kode = " STARONE";
			break;
		case 6:
			kode = " XPLOR";
			break;
		case 8:
			kode = " PAM BANDUNG";
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {

	}
}
