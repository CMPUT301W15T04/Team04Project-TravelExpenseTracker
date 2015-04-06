//from https://github.com/guardianproject/InformaApp March 20
package ca.ualberta.cs.cmput301w15t04team04project.XListView;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * 
 * @author yufei
 *
 */
public class NoSwipeViewPager extends ViewPager {
	public NoSwipeViewPager(Context context) {
		super(context);
	}
	/**
	 * 
	 * @param context
	 * @param attrs
	 */
	public NoSwipeViewPager(Context context, AttributeSet attrs) {
		super(context, attrs);
	}
	/**
	 * @param arg0
	 */
	@Override
	public boolean onInterceptTouchEvent(MotionEvent arg0) {
		// Never allow swiping to switch between pages
		return false;
	}

	/**
	 * @Parameters event The motion event.
	 * @Returns True if the event was handled, false otherwise.
	 */
	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// Never allow swiping to switch between pages
		return false;
	}
}
