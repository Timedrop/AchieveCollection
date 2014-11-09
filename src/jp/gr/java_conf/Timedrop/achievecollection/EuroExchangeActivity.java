package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class EuroExchangeActivity extends Activity {
	private final static int euro_std = 142;
	EditText yen_a = (EditText)findViewById(R.id.yen);
	String yen_b = yen_a.getText().toString();
	int yen=Integer.valueOf(yen_b).intValue();
	
	EditText euro_a = (EditText)findViewById(R.id.euro);
	String euro_b = euro_a.getText().toString();
	int euro=Integer.valueOf(euro_b).intValue();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_euro_exchange);
		
	}
	
	/*
	public void ytoe(int yen, int euro) {
		euro = yen * euro_std;
		EditText euroEditText = (EditText)findViewById(R.id.euro);
		euroEditText.setText=(euro);
	}
	
	public void etoy(int yen, int euro) {
		yen = euro / euro_std;
	}
	*/
}
