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

public class MenuTransaksi extends ListActivity {
	private String[] data = { "Transfer ke Rekening Sendiri",
			"Transfer ke Tujuan Lain" };
	private ImageView img;
	private ListAdapter listAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		img.setImageResource(R.drawable.logo_transfer);
		listAdapter = new ArrayAdapter<String>(this, R.layout.list_editor,
				R.id.list_content, data);
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		if (position == 0) {
			startActivity(new Intent(MenuTransaksi.this,
					TransferMandiriActivity.class));
		} else if (position == 1) {
			startActivity(new Intent(MenuTransaksi.this,
					TransferBedaBankActivity.class));
		}
	}
}