package com.swarawan.smsbanking.mandiri;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.mandiri.menuitem.AirlinesActivity;
import com.swarawan.smsbanking.mandiri.menuitem.GantiPinActivity;
import com.swarawan.smsbanking.mandiri.menuitem.TagihanKKActivity;
import com.swarawan.smsbanking.mandiri.menuitem.InfoValasActivity;
import com.swarawan.smsbanking.mandiri.menuitem.KeretaApiActivity;
import com.swarawan.smsbanking.mandiri.menuitem.TravelAgentActivity;
import com.swarawan.smsbanking.widget.DialogSendSMS;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuInformasi extends ListActivity {
	private final String idBank = "1";
	private ImageView img;
	private Activity activity = this;
	private String[] data = { "Informasi Saldo",
			"Informasi 5 Transaksi Terakhir",
			"Informasi Tagihan Kartu Kredit Mandiri",
			"Informasi Suku Bunga Deposito", "Informasi Suku Bunga Tabungan",
			"Informasi Kurs Valuta Asing", "Informasi Daftar Rekening Sendiri",
			"Informasi Daftar Rekening Tujuan Transfer", "Ganti Pin",
			"Bantuan Perintah SMS Banking Mandiri" };
	private ListAdapter listAdapter;
	private String sms;
	private DialogSendSMS dSend;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
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
			sms = "SAL 1";
			dSend.dialogSend(sms, idBank);
			break;
		case 1:
			sms = "TRN 1";
			dSend.dialogSend(sms, idBank);
			break;
		case 2:
			startActivity(new Intent(MenuInformasi.this,
					TagihanKKActivity.class));
			break;
		case 3:
			sms = "DEP";
			dSend.dialogSend(sms, idBank);
			break;
		case 4:
			sms = "TAB";
			dSend.dialogSend(sms, idBank);
			break;
		case 5:
			startActivity(new Intent(MenuInformasi.this,
					InfoValasActivity.class));
			break;
		case 6:
			sms = "DRS";
			dSend.dialogSend(sms, idBank);
			break;
		case 7:
			sms = "DRT";
			dSend.dialogSend(sms, idBank);
			break;
		case 8:
			startActivity(new Intent(MenuInformasi.this,
					GantiPinActivity.class));
			break;
		case 9:
			sms = "?";
			dSend.dialogSend(sms, idBank);
			break;
		}
	}
}
