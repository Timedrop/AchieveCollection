package jp.gr.java_conf.Timedrop.achievecollection;

import android.app.Activity;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.widget.TextView;

public class GpsActivity extends Activity {
	private LocationManager mLocationManager;
	private TextView mTextView;
	
	private LocationListener mListener = new LocationListener() {
		@Override
		public void onStatusChanged(String provider, int status, Bundle extras) {
			// it is called when provider status changed.
		}
		@Override
		public void onProviderEnabled(String provider) {
			// it is called when provider enabled.
		}
		@Override
		public void onProviderDisabled(String provider) {
			// it is called when provider disabled.
		}
		@Override
		public void onLocationChanged(Location location) {
			// it is called that be able to get location.
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			mTextView.setText("ido = " + latitude + "kdo = " + longitude);
		}
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_gps);
		
		// get TextView
		mTextView = (TextView) findViewById(R.id.text_view_gps);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		// get LocationManager
		mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		// get best of provider
		// it could select detail options, but default this time.
		String provider = mLocationManager.getBestProvider(new Criteria(),  true);
		if (provider == null) {
			// no provider can get
		} else {
			mLocationManager.requestLocationUpdates(provider, 0, 0, mListener);
		}
	}
	
	@Override
	protected void onPause() {
		super.onPause();
		// cancel Listener.
		mLocationManager.removeUpdates(mListener);
	}
}
