package quicklic.quicklic.favorite;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public class PreferencesManager extends Activity
{
	SharedPreferences pref;

	public int getNumPreferences( Context context )
	{
		pref = context.getSharedPreferences("appData", MODE_PRIVATE);
		return pref.getInt("appNum", 0);
	}

	public String getAppPreferences( Context context, int i )
	{
		pref = context.getSharedPreferences("appData", MODE_PRIVATE);
		return pref.getString("appData" + i, null);
	}

	public void removeAppPreferences( Context context, int i )
	{
		System.out.println(i);
		SharedPreferences pref = context.getSharedPreferences("appData", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		int num = getNumPreferences(context);

		for ( int j = i; j < num; j++ )
		{
			editor.putString("appData" + j, getAppPreferences(context, j + 1));
		}

		editor.remove("appData" + num);

		num--;

		editor.putInt("appNum", num);

		editor.commit();
	}

	public void setPreference( String pkg, Context context )
	{
		SharedPreferences pref = context.getSharedPreferences("appData", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();

		int num = getNumPreferences(context);

		num++;

		editor.putString("appData" + num, pkg);
		editor.putInt("appNum", num);

		Log.e("[pkg]", pkg);
		Log.e("[num]", "" + num + ", " + getNumPreferences(context));

		editor.commit();
	}
}