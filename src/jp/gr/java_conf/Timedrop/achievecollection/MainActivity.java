package jp.gr.java_conf.Timedrop.achievecollection;

import android.os.Bundle;
import android.widget.AdapterView;
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
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
				String country = parent.getItemAtPosition(position).toString();
				showToast("onItemSelected:" + country);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				showToast("onNothingSelected");
			}
		});
	}
	
	public void switchGpsActivity(View v) {
		// make intent and start GpsActivity
		Intent varIntent = new Intent(this, GpsActivity.class);
		startActivity(varIntent);
	}
	
	private void showToast(String text){
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
}
