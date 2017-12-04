package com.swarawan.smsbanking.mandiri;

import com.swarawan.smsbanking.mandiri.menuitem.*;

import com.swarawan.smsbanking.R;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuPembayaran extends ListActivity {
	private String[] data = { "Pembayaran Handphone Pasca Bayar",
			"Pembayaran Kartu Kredit", "Pembayaran Cicilan Kredit",
			"Pembayaran TV Kabel", "Pembayaran PAM", "Pembayaran PDAM",
			"Pembayaran Internet", "Pembayaran Kuliah", "Pembayaran Asuransi",
			"Pembayaran Iklan", "Pembayaran PBB", "Pembayaran Pundi Amal SCTV",
			"Pembayaran PLN" };
	private ImageView img;
	private ListAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);

		img = (ImageView) findViewById(R.id.imageLayanan);
		img.setImageResource(R.drawable.logo_pembayaran);

		listAdapter = new ArrayAdapter<String>(this, R.layout.list_editor,
				R.id.list_content, data);
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (position == 0) {
			startActivity(new Intent(MenuPembayaran.this,
					PascaBayarActivity.class));
		} else if (position == 1) {
			startActivity(new Intent(MenuPembayaran.this,
					KartuKreditActivity.class));
		} else if (position == 2) {
			startActivity(new Intent(MenuPembayaran.this,
					CicilanKreditActivity.class));
		} else if (position == 3) {
			startActivity(new Intent(MenuPembayaran.this, TVKabelActivity.class));
		} else if (position == 4) {
			startActivity(new Intent(MenuPembayaran.this, PAMActivity.class));
		} else if (position == 5) {
			startActivity(new Intent(MenuPembayaran.this, PDAMActivity.class));
		} else if (position == 6) {
			startActivity(new Intent(MenuPembayaran.this,
					InternetActivity.class));
		} else if (position == 7) {
			startActivity(new Intent(MenuPembayaran.this, KuliahActivity.class));
		} else if (position == 8) {
			startActivity(new Intent(MenuPembayaran.this,
					AsuransiActivity.class));
		} else if (position == 9) {
			startActivity(new Intent(MenuPembayaran.this, IklanActivity.class));
		} else if (position == 10) {
			startActivity(new Intent(MenuPembayaran.this, PBBActivity.class));
		} else if (position == 11) {
			startActivity(new Intent(MenuPembayaran.this, SCTVActivity.class));
		} else if (position == 12) {
			startActivity(new Intent(MenuPembayaran.this, PLNActivity.class));
		}
	}
}
