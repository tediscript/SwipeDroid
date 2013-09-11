package app.gestures;

// inspired from http://www.techrepublic.com/blog/android-app-builder/use-androids-gesture-detector-to-translate-a-swipe-into-an-event/

import android.content.Context;
import android.view.GestureDetector;
import android.view.GestureDetector.SimpleOnGestureListener;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class SwipeDetector extends SimpleOnGestureListener implements
		OnTouchListener {

	private GestureDetector gDetector;
	private SwipeListener listener;

	public SwipeDetector(Context context, SwipeListener listener) {
		gDetector = new GestureDetector(context, this);
		this.listener = listener;
	}

	@Override
	public boolean onFling(MotionEvent start, MotionEvent finish,
			float velocityX, float velocityY) {

		float gapX = start.getRawX() - finish.getRawX();
		float gapY = start.getRawY() - finish.getRawY();
		float distanceX = Math.abs(gapX);
		float distanceY = Math.abs(gapY);

		if (distanceY > distanceX) { // up downs
			if (gapY > 0) {
				// up
				listener.onSwipeUp(distanceY, velocityY);
			} else {
				// down
				listener.onSwipeDown(distanceY, velocityY);
			}
		} else { // left right
			if (gapX > 0) {
				// left
				listener.onSwipeLeft(distanceX, velocityX);
			} else {
				// rights
				listener.onSwipeRight(distanceX, velocityX);
			}
		}

		return super.onFling(start, finish, velocityX, velocityY);
	}

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		return gDetector.onTouchEvent(event);
	}

}