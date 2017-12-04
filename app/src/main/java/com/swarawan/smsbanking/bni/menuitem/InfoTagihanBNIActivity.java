package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class InfoTagihanBNIActivity extends Activity implements
		OnItemSelectedListener {
	private final String idBank = "2";
	private String kode, sms;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private Spinner spTagihan;
	private TextView tx;
	private EditText edNo;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_infotagihan);

		spTagihan = (Spinner) findViewById(R.id.spinnerTagihan);
		tx = (TextView) findViewById(R.id.tx);
		edNo = (EditText) findViewById(R.id.editTagihan);
		dSend = new DialogSendSMS(activity);

		spTagihan.setOnItemSelectedListener(this);
	}

	public void kirimSMS(View v) {
		String no = edNo.getText().toString();
		
		if(no.equals("")){
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
					Toast.LENGTH_SHORT).show();
		}else{
		sms = "TAG" + kode + " " + no;
		dSend.dialogSend(sms, idBank);
		}
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int position,
			long id) {
		kode = "";
		switch (position) {
		case 0:
			kode = " BNI";
			tx.setText("Nomor Kartu Kredit");
			break;
		case 2:
			kode = " HALO";
			tx.setText("Nomor Telepon / HP");
			break;
		case 3:
			kode = " MATRIX";
			tx.setText("Nomor Telepon / HP");
			break;
		case 4:
			kode = " STARONE";
			tx.setText("Nomor Telepon / HP");
			break;
		case 5:
			kode = " XPLOR";
			tx.setText("Nomor Telepon / HP");
			break;
		case 1:
		case 6:
		case 7:
			kode = " TELKOM";
			tx.setText("Nomor Telepon / HP");
			break;
		}
	}

	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}
