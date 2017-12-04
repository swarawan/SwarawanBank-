package com.swarawan.smsbanking.bni;

import com.swarawan.smsbanking.R;
import com.swarawan.smsbanking.bni.menuitem.SMSBNIActivity;
import com.swarawan.smsbanking.mandiri.MenuInformasi;
import com.swarawan.smsbanking.mandiri.MenuIsiUlang;
import com.swarawan.smsbanking.mandiri.MenuMandiri;
import com.swarawan.smsbanking.mandiri.MenuPembayaran;
import com.swarawan.smsbanking.mandiri.MenuPembelian;
import com.swarawan.smsbanking.mandiri.MenuTransaksi;
import com.swarawan.smsbanking.mandiri.menuitem.MandiriSMSActivity;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

public class MenuBNI extends Activity implements OnClickListener {
	private Button bInfo, bTrans, bIsiUlang, bPembayaran, bSMS, bBantuan;
	private LinearLayout linear;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu);

		bInfo = (Button) findViewById(R.id.butInfo);
		bTrans = (Button) findViewById(R.id.butTrans);
		bIsiUlang = (Button) findViewById(R.id.butIsiUlang);
		bPembayaran = (Button) findViewById(R.id.butPembayaran);
		bSMS = (Button) findViewById(R.id.butSMS);
		bBantuan = (Button) findViewById(R.id.butTiket);
		linear = (LinearLayout) findViewById(R.id.linearmenu);

		bBantuan.setText("Bantuan");
		linear.setBackgroundDrawable(getResources().getDrawable(
				R.drawable.backgroundbni));

		bInfo.setOnClickListener(this);
		bTrans.setOnClickListener(this);
		bIsiUlang.setOnClickListener(this);
		bPembayaran.setOnClickListener(this);
		bSMS.setOnClickListener(this);
		bBantuan.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.butInfo:
			startActivity(new Intent(MenuBNI.this, MenuInformasiBNI.class));
			break;
		case R.id.butTrans:
			startActivity(new Intent(MenuBNI.this, MenuTransferBNI.class));
			break;
		case R.id.butIsiUlang:
			startActivity(new Intent(MenuBNI.this, MenuIsiUlangBNI.class));
			break;
		case R.id.butPembayaran:
			startActivity(new Intent(MenuBNI.this, MenuPembayaranBNI.class));
			break;
		case R.id.butSMS:
			startActivity(new Intent(MenuBNI.this, SMSBNIActivity.class));
			// Toast.makeText(getBaseContext(), "Menu Belum Tersedia",
			// Toast.LENGTH_SHORT).show();
			break;
		case R.id.butTiket:
			startActivity(new Intent(MenuBNI.this, MenuBantuanBNI.class));
			break;
		}
	}
}
