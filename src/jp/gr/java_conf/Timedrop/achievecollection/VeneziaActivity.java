package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;

public class VeneziaActivity extends ListActivity {
	private SQLiteDatabase mDB;
	private Cursor mCursor;
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_venezia);
		
	}
}
