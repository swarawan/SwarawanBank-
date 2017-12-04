package com.swarawan.smsbanking.sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteMaster extends SQLiteOpenHelper {

	public SQLiteMaster(Context context) {
		super(context, "db_swarawanbank", null, 1);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String queryBank = "CREATE TABLE IF NOT EXISTS tb_bank "
				+ "(idbank TEXT PRIMARY KEY, namabank TEXT)";
		db.execSQL(queryBank);

		String queryRiwayat = "CREATE TABLE IF NOT EXISTS tb_riwayat "
				+ "(idriwayat INTEGER PRIMARY KEY, riwayat TEXT, idbank TEXT, status TEXT ,"
				+ "FOREIGN KEY (idbank) REFERENCES tb_bank(idbank))";
		db.execSQL(queryRiwayat);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS tb_bank");
		db.execSQL("DROP TABLE IF EXISTS tb_riwayat");
		onCreate(db);
	}

}
