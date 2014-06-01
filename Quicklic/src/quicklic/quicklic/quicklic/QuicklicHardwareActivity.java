package quicklic.quicklic.quicklic;

import java.util.ArrayList;

import quicklic.floating.api.R;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class QuicklicHardwareActivity extends QuicklicActivity {

	private ArrayList<Drawable> imageArrayList;
	WifiManager wifi;

	@Override
	protected void onCreate( Bundle savedInstanceState )
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_quicklic);

		initialize();
	}
	
	private void onWifi()
	{
		wifi.setWifiEnabled(true);
	}
	private void offWifi()
	{
		wifi.setWifiEnabled(false);
	}

	private void initialize()
	{
		imageArrayList = new ArrayList<Drawable>();
		wifi = (WifiManager)getSystemService(Context.WIFI_SERVICE);

		// TODO
		imageArrayList.add(getResources().getDrawable(R.drawable.hardware_test));
		imageArrayList.add(getResources().getDrawable(R.drawable.volume_test));
		imageArrayList.add(getResources().getDrawable(R.drawable.poweroff_test));

		addViewsForBalance(imageArrayList.size(), imageArrayList, onClickListener);
	}

	/*protected void onResume()
	{
		initialize();
		
		super.onResume();
	}*/

	private OnClickListener onClickListener = new OnClickListener()
	{
		@Override
		public void onClick( View v )
		{
			//TODO
			if ( v.getId() == 1 )
			{
				startActivity(new Intent(android.provider.Settings.ACTION_SOUND_SETTINGS));
			}
			if ( v.getId() == 2 )
			{
				if(!wifi.isWifiEnabled())
				{
					if(wifi.getWifiState() != WifiManager.WIFI_STATE_ENABLED)
					{
						onWifi();
						System.out.println("on");
					}
				}
				else
				{
					offWifi();
					System.out.println("off");
				}
			}
		}
	};

}