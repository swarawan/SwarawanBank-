package com.swarawan.smsbanking.mandiri;

import com.swarawan.smsbanking.MainActivity;
import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.mandiri.menuitem.CicilanKreditActivity;
import com.swarawan.smsbanking.mandiri.menuitem.IsiUlangPulsaActivity;
import com.swarawan.smsbanking.mandiri.menuitem.KartuKreditActivity;
import com.swarawan.smsbanking.mandiri.menuitem.PascaBayarActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;

public class MenuIsiUlang extends ListActivity {
	private String[] data = { "Isi Ulang Pulsa Prabayar" };
	private ImageView img;
	private ListAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		img.setImageResource(R.drawable.logo_isipulsa);
		listAdapter = new ArrayAdapter<String>(this, R.layout.list_editor,
				R.id.list_content, data);
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (position == 0) {
			startActivity(new Intent(MenuIsiUlang.this, IsiUlangPulsaActivity.class));
			finish();
		}
	}

}
