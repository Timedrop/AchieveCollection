package jp.gr.java_conf.Timedrop.achievecollection;

public class GPSActivity extends Activity {
	private LocationManager mLocationManager;
	private TextView mTextView;
	
	private LocationListener mListner = new LoLocationListner {
		@Override
		public void onStatusChanged(String pprovider, int status, Bundle extras) {
			//プロバイダの状態が変化したら呼び出される。
		}
		@Override
		public void onProviderEnabled(String provider) {
			//プロバイダが有効になったら呼び出される。
		}
		@Override
		public void onProviderDisabled(String provider) {
			//プロバイダが無効になったら呼び出される。
		}
		@Override
		public void onLocationChanged(Location location){
			//位置情報が取得出来るたびに呼び出される。
			double latitude = location.getLatitude();
			double longitude = location.getLongitude();
			mTextView.setText("緯度 = " + latitude +
							  ", 経度 = " + longitude);
		}	
	};
	
	@Override
	public void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContextView(R.layout.activity_gps);
		
		// TextViewを取得
		mTextView = (TextView) findViewById(R.id.text_view);
	}
	
	@Override
	protected void onResume(){
		super.onResume();
		
		// LocationManagerを取得
		mLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		// 現在の状況に適切なプロバイダを取得する
		// Criteriaで細かい条件指定ができるが今回はデフォで
		String provider = mLocationManager.getBestProvider(
			new Criteria(), true);
		if (provider == null){
			// 位置取得が出来るプロバイダがない。
		} else {
			// リスナーをセットして位置情報の取得を開始
			mLocationManager.requestLocationUpdates(provider, 0, 0, mListener);
		}
	}
	
	@Override
	protected void onPause(){
		super.onPause();
		// リスナーを解除
		mLocationManager.removeUpdates(mListener);
	}
}
