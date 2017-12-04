package com.swarawan.smsbanking.bni;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.bni.menuitem.TransferAntarBNIActivity;
import com.swarawan.smsbanking.bni.menuitem.TransferDenganBeritaActivity;
import com.swarawan.smsbanking.bni.menuitem.TransferDenganBeritaNotifActivity;
import com.swarawan.smsbanking.bni.menuitem.TransferDenganKonfirmasiActivity;
import com.swarawan.smsbanking.bni.menuitem.TransferDenganNotifActivity;
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

public class MenuTransferBNI extends ListActivity {
	private final String idBank = "2";
	private LinearLayout linear;
	private ImageView img;
	private Activity activity = this;
	private ListAdapter listAdapter;
	private String sms;
	private DialogSendSMS dSend;
	private String[] data = { "Transfer Antar Rekening BNI",
			"Transfer Dengan Berita", "Transfer Dengan Notifikasi",
			"Transfer Dengan Berita Dan Notifikasi",
			"Transfer Dengan Konfirmasi" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		linear = (LinearLayout) findViewById(R.id.linear);

		linear.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.backgroundbni2));
		img.setImageResource(R.drawable.logo_transfer);
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
			startActivity(new Intent(this, TransferAntarBNIActivity.class));
			break;
		case 1:
			startActivity(new Intent(this, TransferDenganBeritaActivity.class));
			break;
		case 2:
			startActivity(new Intent(this, TransferDenganNotifActivity.class));
			break;
		case 3:
			startActivity(new Intent(this, TransferDenganBeritaNotifActivity.class));
			break;
		case 4:
			startActivity(new Intent(this, TransferDenganKonfirmasiActivity.class));
			break;
		}
	}
}
