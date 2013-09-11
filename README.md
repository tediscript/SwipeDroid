SwipeDroid
==========

Android swipe gesture detector. Create swipe listener for up, right, down and left.

Inspired from:
[http://www.techrepublic.com/blog/android-app-builder/use-androids-gesture-detector-to-translate-a-swipe-into-an-event/](http://www.techrepublic.com/blog/android-app-builder/use-androids-gesture-detector-to-translate-a-swipe-into-an-event/)

How to:

Put on your Activity

	private SwipeDetector sd = new SwipeDetector(this, new SwipeDetector.OnSwipeListener() {

		@Override
		public void onSwipeUp(float distance, float velocity) {
			tv.setText("Swipe Up");
			iv.setImageResource(R.drawable.up);
		}

		@Override
		public void onSwipeRight(float distance, float velocity) {
			tv.setText("Swipe Right");
			iv.setImageResource(R.drawable.right);
		}

		@Override
		public void onSwipeLeft(float distance, float velocity) {
			tv.setText("Swipe Left");
			iv.setImageResource(R.drawable.left);
		}

		@Override
		public void onSwipeDown(float distance, float velocity) {
			tv.setText("Swipe Down");
			iv.setImageResource(R.drawable.down);
		}
	});
	
And set listener to

	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return sd.onTouch(null, me);
	}