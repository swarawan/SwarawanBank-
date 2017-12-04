package com.swarawan.smsbanking.bni;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuBantuanBNI extends ListActivity {
	private final String IDBANK = "2";
	private LinearLayout linear;
	private ImageView img;
	private Activity activity = this;
	private ListAdapter listAdapter;
	private String sms;
	private DialogSendSMS dSend;
	private String[] data = { "Fasilitas Bantuan", "Bantuan Cara Transfer",
			"Bantuan Isi Pulsa", "Bantuan Cek Saldo, Tagihan, Ganti Pin",
			"Bantuan Bayar Tagihan", "Bantuan Cek Rekening Koran" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		linear = (LinearLayout) findViewById(R.id.linear);

		linear.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.backgroundbni2));
		img.setImageResource(R.drawable.logo_bantuan);
		dSend = new DialogSendSMS(activity);

		listAdapter = new ArrayAdapter<String>(this, R.layout.list_editor,
				R.id.list_content, data);
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		switch (position) {
		case 0:
			sms = "HELP";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 1:
			sms = "HELP TRF";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 2:
			sms = "HELP TOP";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 3:
			sms = "HELP INQ";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 4:
			sms = "HELP PAY";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 5:
			sms = "HELP RKO";
			dSend.dialogSend(sms, IDBANK);
			break;
		}
	}
}
