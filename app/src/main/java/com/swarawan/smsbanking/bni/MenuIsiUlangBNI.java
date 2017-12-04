package com.swarawan.smsbanking.bni;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.bni.menuitem.IsiUlangPulsaBNIActivity;
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

public class MenuIsiUlangBNI extends ListActivity {
	private final String idBank = "2";
	private LinearLayout linear;
	private ImageView img;
	private Activity activity = this;
	private ListAdapter listAdapter;
	private String sms;
	private DialogSendSMS dSend;
	private String[] data = { "Isi Ulang Pulsa Prabayar" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.submenu);
		img = (ImageView) findViewById(R.id.imageLayanan);
		linear = (LinearLayout) findViewById(R.id.linear);

		linear.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.backgroundbni2));
		img.setImageResource(R.drawable.logo_isipulsa);
		dSend = new DialogSendSMS(activity);

		listAdapter = new ArrayAdapter<String>(this, R.layout.list_editor,
				R.id.list_content, data);
		setListAdapter(listAdapter);
	}

	@Override
	protected void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		startActivity(new Intent(this, IsiUlangPulsaBNIActivity.class));
	}
}
