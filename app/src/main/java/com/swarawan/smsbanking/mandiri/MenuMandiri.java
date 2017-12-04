package com.swarawan.smsbanking.mandiri;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.mandiri.menuitem.MandiriSMSActivity;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListAdapter;
import android.widget.Toast;

public class MenuMandiri extends Activity implements OnClickListener {
	private Button bInfo, bTrans, bIsiUlang, bPembayaran, bSMS, bTiket;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		bInfo = (Button) findViewById(R.id.butInfo);
		bTrans = (Button) findViewById(R.id.butTrans);
		bIsiUlang = (Button) findViewById(R.id.butIsiUlang);
		bPembayaran = (Button) findViewById(R.id.butPembayaran);
		bSMS = (Button) findViewById(R.id.butSMS);
		bTiket = (Button) findViewById(R.id.butTiket);

		bInfo.setOnClickListener(this);
		bTrans.setOnClickListener(this);
		bIsiUlang.setOnClickListener(this);
		bPembayaran.setOnClickListener(this);
		bSMS.setOnClickListener(this);
		bTiket.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.butInfo:
			startActivity(new Intent(MenuMandiri.this, MenuInformasi.class));
			break;
		case R.id.butTrans:
			startActivity(new Intent(MenuMandiri.this, MenuTransaksi.class));
			break;
		case R.id.butIsiUlang:
			startActivity(new Intent(MenuMandiri.this, MenuIsiUlang.class));
			break;
		case R.id.butPembayaran:
			startActivity(new Intent(MenuMandiri.this, MenuPembayaran.class));
			break;
		case R.id.butSMS:
			startActivity(new Intent(MenuMandiri.this, MandiriSMSActivity.class));
			break;
		case R.id.butTiket:
			startActivity(new Intent(MenuMandiri.this, MenuPembelian.class));
			break;
		}
	}
}
