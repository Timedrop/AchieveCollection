package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

public class VeneziaActivity extends Activity {
	private SQLiteDatabase mDB;
	private Cursor mCursor;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venezia);
		
		// DB file path
		String path = "/data/data/" + getPackageName() + "/acdb.db";
		// Open DB (Create if not exists)
		SQLiteDatabase db;
		db = SQLiteDatabase.openOrCreateDatabase(path, null);
		
		// Make table (Venezia)
		String sql = "CREATE TABLE IF NOT EXISTS venezia" + " (_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);";
		db.execSQL(sql);
		
		// Close DB
		db.close();
	}
}
