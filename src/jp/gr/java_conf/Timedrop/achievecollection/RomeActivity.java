package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class RomeActivity extends Activity {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_rome);
		
		Button break_venezia=(Button)findViewById(R.id.break_rome);
		break_venezia.setOnClickListener(new View.OnClickListener() {
	
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}
}
