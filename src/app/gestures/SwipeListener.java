package app.gestures;

public interface SwipeListener {

	public void onSwipeUp(float distance, float velocity);

	public void onSwipeDown(float distance, float velocity);

	public void onSwipeLeft(float distance, float velocity);

	public void onSwipeRight(float distance, float velocity);

}
