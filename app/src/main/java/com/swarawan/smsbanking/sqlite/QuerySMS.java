package com.swarawan.smsbanking.sqlite;

import java.util.ArrayList;
import java.util.List;
import com.swarawan.smsbanking.model.ModelSMS;
import com.swarawan.smsbanking.model.RiwayatModel;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class QuerySMS extends SQLiteMaster {
	SQLiteDatabase sqlRead;
	ContentValues values;
	Cursor cursor;

	public QuerySMS(Context context) {
		super(context);
		values = new ContentValues();
	}

	public int totalKontak() {
		String query = "SELECT * FROM tb_bank";
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(query, null);

		return c.getCount();
	}

	public void getInstance() {
		if (totalKontak() < 1) {
			insertBank("1", "Bank Mandiri");
			insertBank("2", "Bank BNI");
		}
	}

	public void insertBank(String idbank, String namabank) {
		sqlRead = this.getWritableDatabase();
		// sqlRead = this.getReadableDatabase();

		values.put("idbank", idbank);
		values.put("namabank", namabank);

		sqlRead.insert("tb_bank", null, values);
		sqlRead.close();
	}

	// public void insertSMS(String isi, String idbank) {
	// sqlRead = this.getWritableDatabase();
	// // sqlRead = this.getReadableDatabase();
	//
	// values.put("riwayat", isi);
	// values.put("idbank", idbank);
	//
	// sqlRead.insert("tb_riwayat", null, values);
	// sqlRead.close();
	// }

	public void insertSMS(RiwayatModel rm) {
		sqlRead = this.getWritableDatabase();
		// sqlRead = this.getReadableDatabase();

		values.put("riwayat", rm.getRiwayat());
		values.put("idbank", rm.getIdBank());
		values.put("status", rm.getStatus());

		sqlRead.insert("tb_riwayat", null, values);
		sqlRead.close();
	}

	public List<RiwayatModel> ambilIsiSMSMandiri() {
		sqlRead = this.getWritableDatabase();
		List<RiwayatModel> listSMSMandiri = new ArrayList<RiwayatModel>();
		String query = "SELECT * FROM tb_riwayat WHERE idbank='1'";
		cursor = sqlRead.rawQuery(query, null);
		while (cursor.moveToNext()) {
			RiwayatModel rm = new RiwayatModel();
			rm.setRiwayat(cursor.getString(1));
			rm.setStatus(cursor.getString(3));
			listSMSMandiri.add(rm);
		}
		sqlRead.close();
		cursor.close();
		return listSMSMandiri;
	}

	public List<RiwayatModel> ambilIsiSMSBNI() {
		sqlRead = this.getWritableDatabase();
		List<RiwayatModel> listSMSBNI = new ArrayList<RiwayatModel>();
		String query = "SELECT * FROM tb_riwayat WHERE idbank='2'";
		cursor = sqlRead.rawQuery(query, null);
		while (cursor.moveToNext()) {
			RiwayatModel rm = new RiwayatModel();
			rm.setRiwayat(cursor.getString(1));
			rm.setStatus(cursor.getString(3));
			listSMSBNI.add(rm);
		}
		sqlRead.close();
		cursor.close();
		return listSMSBNI;
	}
}
