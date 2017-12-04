package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class TransferDenganKonfirmasiActivity extends Activity {
	private final String IDBANK = "2";
	private String kode, sms;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private EditText edRek, edNom;
	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_transfer_antarbni);

		edRek = (EditText) findViewById(R.id.editNoRek_bni);
		edNom = (EditText) findViewById(R.id.editJumlah_bni);
		img = (ImageView) findViewById(R.id.imageLayanan);
		dSend = new DialogSendSMS(activity);
		img.setImageDrawable(getResources().getDrawable(
				R.drawable.transfer_dengankonfirmasi));
	}

	public void kirimSMS(View v) {
		String rek = edRek.getText().toString();
		String nom = edNom.getText().toString();
		if(rek.equals("")||nom.equals("")){
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!", Toast.LENGTH_SHORT).show();
		}else{
		sms = "TRF KONFIRMASI " + rek + " " + nom;
		dSend.dialogSend(sms, IDBANK);}
	}
}
