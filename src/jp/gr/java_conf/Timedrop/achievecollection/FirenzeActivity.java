package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FirenzeActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_firenze);
		
		Button break_venezia=(Button)findViewById(R.id.break_firenze);
		break_venezia.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
