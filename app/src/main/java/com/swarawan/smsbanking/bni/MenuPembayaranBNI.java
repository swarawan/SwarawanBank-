package com.swarawan.smsbanking.bni;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.bni.menuitem.PembayaranKartuKreditBNIActivity;
import com.swarawan.smsbanking.bni.menuitem.PembayaranTagihanBNI;
import com.swarawan.smsbanking.bni.menuitem.PembayaranTiketPesawatBNIActivity;
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

public class MenuPembayaranBNI extends ListActivity {
	private final String idBank = "2";
	private LinearLayout linear;
	private ImageView img;
	private Activity activity = this;
	private ListAdapter listAdapter;
	private String sms;
	private DialogSendSMS dSend;
	private String[] data = { "Pembayaran Kartu Kredit", "Pembayaran Tagihan",
			"Pembayaran Tiket" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		linear = (LinearLayout) findViewById(R.id.linear);

		linear.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.backgroundbni2));
		img.setImageResource(R.drawable.logo_pembayaran);
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
			startActivity(new Intent(this,
					PembayaranKartuKreditBNIActivity.class));
			break;
		case 1:
			startActivity(new Intent(this, PembayaranTagihanBNI.class));
			break;
		case 2:
			startActivity(new Intent(this,
					PembayaranTiketPesawatBNIActivity.class));
			break;
		}
	}
}
