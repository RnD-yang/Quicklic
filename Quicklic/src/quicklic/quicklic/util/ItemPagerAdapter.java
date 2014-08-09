/**
 * Product by KIHan
 */
package quicklic.quicklic.util;

import java.util.ArrayList;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;

public class ItemPagerAdapter extends PagerAdapter {

	private LayoutInflater mInflater;
	private int mPagerCount = 0;
	private ArrayList<FrameLayout> mQuicklicViewList;

	public ItemPagerAdapter(Context c, int pagerCnt, ArrayList<FrameLayout> layoutList)
	{
		super();

		mInflater = LayoutInflater.from(c);
		mPagerCount = pagerCnt;
		mQuicklicViewList = layoutList;
	}

	@Override
	public int getCount()
	{
		return mPagerCount;
	}

	@Override
	public Object instantiateItem( View pager, int position )
	{

		Log.e("test", "instaniateItem : " + position);
		((ViewPager) pager).addView(mQuicklicViewList.get(position), 0);

		return mQuicklicViewList.get(position);
	}

	@Override
	public void destroyItem( View pager, int position, Object view )
	{
		((ViewPager) pager).removeView((View) view);
	}

	@Override
	public boolean isViewFromObject( View pager, Object obj )
	{
		return pager == obj;
	}

	@Override
	public void restoreState( Parcelable arg0, ClassLoader arg1 )
	{
	}

	@Override
	public Parcelable saveState()
	{
		return null;
	}

	@Override
	public void startUpdate( View arg0 )
	{
	}

	@Override
	public void finishUpdate( View arg0 )
	{
	}
}
