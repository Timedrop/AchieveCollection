package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import java.io.FileNotFoundException;

import android.database.SQLException;
import android.content.ContentValues;
import android.util.Log;

public class SqlActivity extends Activity {

	private SQLiteDatabase db;

	private final int DB_VERSION = 1;
	private int DB_MODE = Context.MODE_PRIVATE;
	private final String DB_NAME = "italy_db";
	private final String TABLE_NAME = "italy_table";

	@Override protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_sql);

		db = null;

		openDatabase();
	}

	private void openDatabase(){
		db = openOrCreateDatabase(DB_NAME, DB_VERSION, null);
		createTable();
	}
	

	private void createTable(){
		String sql = "create table " + TABLE_NAME + " ("
			+ "id integer primary key autoincrement, "
			+ "name text not null, "
			+ "price integer);";

		try {
			db.execSQL(sql);
		} catch (SQLException e) {
			Log.e("ERROR", e.toString());
		}
	}

	public void insert() {
		EditText country_b = (EditText)findViewById(R.id.country);
		EditText point_b = (EditText)findViewById(R.id.point);
		EditText latitude_b = (EditText)findViewById(R.id.latitude);
		EditText longitude_b = (EditText)findViewById(R.id.longitude);
		EditText achieve_b = (EditText)findViewById(R.id.achieve);
		
		CharSequence country = country_b.getText().toString();
		CharSequence point = point_b.getText().toString();
		CharSequence latitude = latitude_b.getText().toString();
		CharSequence longitude = longitude_b.getText().toString();
		CharSequence achieve = achieve_b.getText().toString();
		
		ContentValues cv = new ContentValues();
		cv.put("country", (String) country);
		cv.put("point", (String) point);
		cv.put("latitude", (String) latitude);
		cv.put("longitude", (String) longitude);
		cv.put("achieve", (String) achieve);
		
		db.insert(TABLE_NAME, null, cv);
	}
	
	public void update() {
		EditText country_b = (EditText)findViewById(R.id.country);
		EditText point_b = (EditText)findViewById(R.id.point);
		EditText latitude_b = (EditText)findViewById(R.id.latitude);
		EditText longitude_b = (EditText)findViewById(R.id.longitude);
		EditText achieve_b = (EditText)findViewById(R.id.achieve);
		
		CharSequence country = country_b.getText().toString();
		CharSequence point = point_b.getText().toString();
		CharSequence latitude = latitude_b.getText().toString();
		CharSequence longitude = longitude_b.getText().toString();
		CharSequence achieve = achieve_b.getText().toString();
		
		ContentValues cv = new ContentValues();
		cv.put("country", (String) country);
		cv.put("point", (String) point);
		cv.put("latitude", (String) latitude);
		cv.put("longitude", (String) longitude);
		cv.put("achieve", (String) achieve);
		
		db.update(TABLE_NAME, cv, "point = " + point, null);
	}
	
	public void delete() {
		EditText point_b = (EditText)findViewById(R.id.point);

		CharSequence point = point_b.getText().toString();
		
		db.delete(TABLE_NAME, "point = " + point, null);
	}
}