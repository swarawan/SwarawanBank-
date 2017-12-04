package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TransferDenganBeritaActivity extends Activity {
	private final String IDBANK = "2";
	private String kode, sms;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private EditText edRek, edNom, edBerita;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_transfer_berita);

		edRek = (EditText) findViewById(R.id.editNoRek_bni);
		edNom = (EditText) findViewById(R.id.editJumlah_bni);
		edBerita = (EditText) findViewById(R.id.editBerita_bni);
		dSend = new DialogSendSMS(activity);
	}

	public void kirimSMS(View v) {
		String rek = edRek.getText().toString();
		String nom = edNom.getText().toString();
		String ber = edBerita.getText().toString();

		if (rek.equals("") || nom.equals("") || ber.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
					Toast.LENGTH_SHORT).show();
		} else {
			sms = "TRF BERITA " + rek + " " + nom + " #" + ber + "#";
			dSend.dialogSend(sms, IDBANK);
		}
	}
}
