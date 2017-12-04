package com.swarawan.smsbanking.mandiri;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.mandiri.menuitem.*;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuPembelian extends ListActivity {
	private String[] data = { "Pembelian Tiket Pesawat",
			"Pembelian Tiket Kereta Api", "Travel Agent / Hotel" };
	private ImageView img;
	private ListAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);

		img = (ImageView) findViewById(R.id.imageLayanan);
		img.setImageResource(R.drawable.logo_pembelian);

		listAdapter = new ArrayAdapter<String>(this, R.layout.list_editor,
				R.id.list_content, data);
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (position == 0) {
			startActivity(new Intent(MenuPembelian.this, AirlinesActivity.class));
		} else if (position == 1) {
			startActivity(new Intent(MenuPembelian.this,
					KeretaApiActivity.class));
		} else if (position == 2) {
			startActivity(new Intent(MenuPembelian.this,
					TravelAgentActivity.class));
		}
	}
}
