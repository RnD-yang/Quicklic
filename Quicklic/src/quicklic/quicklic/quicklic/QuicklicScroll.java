package quicklic.quicklic.quicklic;

import java.util.ArrayList;

import quicklic.floating.api.R;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.OnClickListener;

public class QuicklicScroll {

	private QuicklicActivity quicklicActivity;
	private ArrayList<Drawable> imageList;

	public QuicklicScroll(QuicklicActivity quicklicActivity)
	{
		this.quicklicActivity = quicklicActivity;

		init();
	}

	private void init()
	{
		imageList = new ArrayList<Drawable>();

		// TODO
		imageList.add(quicklicActivity.getResources().getDrawable(R.drawable.scroll_test));

		quicklicActivity.addViewsForBalance(8, imageList, onClickListener);
	}

	private OnClickListener onClickListener = new OnClickListener()
	{
		@Override
		public void onClick( View v )
		{
			//TODO
		}
	};

}