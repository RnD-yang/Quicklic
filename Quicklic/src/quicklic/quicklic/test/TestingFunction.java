<<<<<<< HEAD
package quicklic.quicklic.test;

import java.io.Serializable;

import quicklic.floating.api.FloatingInterface;
import quicklic.floating.api.FloatingService;
import quicklic.quicklic.main.QuicklicMainActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class TestingFunction implements Serializable, FloatingInterface
{
	private static final long serialVersionUID = 1L;
	private static FloatingService floatingServices;
	private Intent intent;

	@Override
	public void setContext( FloatingService floatingServices )
	{
		TestingFunction.floatingServices = floatingServices;
	}

	@Override
	public void touched( View v )
	{
		Toast.makeText(floatingServices, "single", Toast.LENGTH_SHORT).show();
		intent = new Intent(floatingServices, QuicklicMainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 서비스 도중 실행 시, New Task 플래그가 필요하다.
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // 한 번 호출된 Activity에 대해서는 중복 호출 되지 않는다. (중복 불가 적용)
		setQuicklicVisibility(false);
		floatingServices.startActivity(intent);
	}

	@Override
	public void doubleTouched( View v )
	{
		Toast.makeText(floatingServices, "double", Toast.LENGTH_SHORT).show();
		floatingServices.changeMoveToSide();
	}

	@Override
	public void longTouched( View v )
	{
		Toast.makeText(floatingServices, "long", Toast.LENGTH_SHORT).show();
		floatingServices.stopQuicklicService();
	}

	@Override
	public boolean setAnimation()
	{
		return true;
	}

	@Override
	public void setQuicklicVisibility( boolean bool )
	{
		floatingServices.setVisibility(bool);
	}

	@Override
	public float setSize()
	{
		return 0.17f;
	}

	//-------------------------------------------------------------------
	//  API 비 제공 메소드
	//-------------------------------------------------------------------

	public static FloatingService getFloatingServices()
	{
		return floatingServices;
	}

}
=======
package quicklic.quicklic.test;

import java.io.Serializable;

import quicklic.floating.api.FloatingInterface;
import quicklic.floating.api.FloatingService;
import quicklic.quicklic.main.QuicklicMainActivity;
import android.content.Intent;
import android.view.View;
import android.widget.Toast;

public class TestingFunction implements Serializable, FloatingInterface
{
	private static final long serialVersionUID = 1L;
	private static FloatingService floatingService;
	private Intent intent;

	@Override
	public void setContext( FloatingService floatingService )
	{
		TestingFunction.floatingService = floatingService;
	}

	@Override
	public void touched( View v )
	{
		Toast.makeText(floatingService, "single", Toast.LENGTH_SHORT).show();
		intent = new Intent(floatingService, QuicklicMainActivity.class);
		intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // 서비스 도중 실행 시, New Task 플래그가 필요하다.
		intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP); // 한 번 호출된 Activity에 대해서는 중복 호출 되지 않는다. (중복 불가 적용)
		setQuicklicVisibility(false);
		floatingService.startActivity(intent);
	}

	@Override
	public void doubleTouched( View v )
	{
		Toast.makeText(floatingService, "double", Toast.LENGTH_SHORT).show();
		floatingService.changeMoveToSide();
	}

	@Override
	public void longTouched( View v )
	{
		Toast.makeText(floatingService, "long", Toast.LENGTH_SHORT).show();
		floatingService.stopQuicklicService();
	}

	@Override
	public boolean setAnimation()
	{
		return true;
	}

	@Override
	public void setQuicklicVisibility( boolean bool )
	{
		floatingService.setVisibility(bool);
	}

	@Override
	public float setSize()
	{
		return 0.17f;
	}

	//-------------------------------------------------------------------
	//  API 비 제공 메소드
	//-------------------------------------------------------------------

	public static FloatingService getFloatingService()
	{
		return floatingService;
	}

}
>>>>>>> first_branch
