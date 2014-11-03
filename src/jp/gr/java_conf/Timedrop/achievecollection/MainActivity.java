package jp.gr.java_conf.Timedrop.achievecollection;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}
	
	public void switchVeneziaActivity(View v) {
		// make intent and start VeneziaActivity
		Intent varIntent = new Intent(this, VeneziaActivity.class);
		startActivity(varIntent);
	}
	
	public void switchRomeActivity(View v) {
		// make intent and start RomeActivity
		Intent varIntent = new Intent(this, RomeActivity.class);
		startActivity(varIntent);
	}
	
	public void switchFirenzeActivity(View v) {
		// make intent and start FirenzeActivity
		Intent varIntent = new Intent(this, FirenzeActivity.class);
		startActivity(varIntent);
	}
	
	public void switchSqlActivity(View v) {
		// make intent and start SqlActivity
		Intent varIntent = new Intent(this, SqlActivity.class);
		startActivity(varIntent);
	}
	
	/*
	public void switchGpsActivity(View v) {
		// make intent and start GpsActivity
		Intent varIntent = new Intent(this, GpsActivity.class);
		startActivity(varIntent);
	}
	*/

	

}
