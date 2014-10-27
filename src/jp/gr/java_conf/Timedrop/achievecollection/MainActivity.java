package jp.gr.java_conf.Timedrop.achievecollection;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.app.Activity;
import android.view.View;
import android.widget.Toast;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;

public class MainActivity extends Activity {
	LocationManager varLocationManager;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		//LocationManagerクラスのインスタンスを取得
		varLocationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
		
		ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.country_array,
				android.R.layout.simple_spinner_item);
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		
		Spinner spinner = (Spinner) findViewById(R.id.spinner);
		spinner.setAdapter(adapter);
		
		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
			@Override
			public void onItemSelected(AdapterView<?> parent, View view, int position, long id){
				//String country = parent.getItemAtPosition(position).toString();
				showToast(latitude);
			}
			
			@Override
			public void onNothingSelected(AdapterView<?> parent){
				showToast("onNothingSelected");
			}
		});
	}

	@Override
	//ユーザーからの操作の受付を開始するときに呼ばれる
	protected void onResume()
	{
		super.onResume();
		//現在の位置情報を更新
		varLocationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 50, new SLocationListener());
	}
	
	class SLocationListener implements LocationListener
	{

		@Override
		//位置情報が更新されたときに呼び出されるコールバックメソッド
		//public void onLocationChanged(Location lc)
		{
			//更新された経度を取得
			int longitude = (int) (lc.getLongitude() * 1E6);
			//更新された緯度を取得
			int latitude = (int) (lc.getLatitude() * 1E6);
			//座標を指定するためのGeoPointをインスタンス化
			//GeoPoint varGeoPoint = new GeoPoint(latitude, longitude);
		}

		@Override
		//LocationListenerで実装が必要
		public void onProviderDisabled(String pv){
		}
		@Override
		public void onProviderEnabled(String pv){
		}

		@Override
		public void onStatusChanged(String pv, int status, Bundle ex){
		}	
	}
	
	private void showToast(String text){
		Toast.makeText(this, text, Toast.LENGTH_SHORT).show();
	}
	
}
