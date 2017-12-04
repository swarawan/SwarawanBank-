package com.swarawan.smsbanking.bni;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.bni.menuitem.InfoTagihanBNIActivity;
import com.swarawan.smsbanking.widget.DialogSendSMS;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuInformasiBNI extends ListActivity {
	private final String IDBANK = "2";
	private LinearLayout linear;
	private ImageView img;
	private Activity activity = this;
	private ListAdapter listAdapter;
	private String sms;
	private DialogSendSMS dSend;
	private String[] data = { "Informasi Saldo",
			"Informasi Transaksi Terakhir",
			"Informasi Tagihan Telepon Prabayar" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		linear = (LinearLayout) findViewById(R.id.linear);

		linear.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.backgroundbni2));
		img.setImageResource(R.drawable.logo_informasi);
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
			sms = "SAL";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 1:
			sms = "HST";
			dSend.dialogSend(sms, IDBANK);
			break;
		case 2:
			startActivity(new Intent(this, InfoTagihanBNIActivity.class));
			break;
		}
	}
}
