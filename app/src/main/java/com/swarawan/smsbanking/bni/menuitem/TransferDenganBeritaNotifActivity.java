package com.swarawan.smsbanking.bni.menuitem;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class TransferDenganBeritaNotifActivity extends Activity {
	private final String IDBANK = "2";
	private String kode, sms;
	private DialogSendSMS dSend;
	private Activity activity = this;
	private EditText edRek, edNom, edPenerima, edBerita;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.bni_transfer_beritanotif);

		edRek = (EditText) findViewById(R.id.editNoRek_bni);
		edNom = (EditText) findViewById(R.id.editJumlah_bni);
		edPenerima = (EditText) findViewById(R.id.editPenerima_bni);
		edBerita = (EditText) findViewById(R.id.editBerita_bni);
		dSend = new DialogSendSMS(activity);
	}

	public void kirimSMS(View v) {
		String rek = edRek.getText().toString();
		String nom = edNom.getText().toString();
		String pen = edPenerima.getText().toString();
		String ber = edBerita.getText().toString();

		if (rek.equals("") || nom.equals("") || pen.equals("")
				|| ber.equals("")) {
			Toast.makeText(getBaseContext(), "Isi Data dengan lengkap!",
					Toast.LENGTH_SHORT).show();
		} else {
			sms = "TRF BERITANOTIFIKASI " + rek + " " + nom + "" + " #" + ber
					+ "# " + pen;
			dSend.dialogSend(sms, IDBANK);
		}
	}
}
