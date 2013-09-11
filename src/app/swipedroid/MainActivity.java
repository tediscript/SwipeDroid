package app.swipedroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import app.gestures.SwipeDetector;
import app.gestures.SwipeListener;

public class MainActivity extends Activity {

	private ImageView iv;
	private TextView tv;
	private SwipeDetector sd;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		tv = (TextView) findViewById(R.id.textView1);
		iv = (ImageView) findViewById(R.id.imageView1);

		sd = new SwipeDetector(this, new SwipeListener() {

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

	}

	@Override
	public boolean onTouchEvent(MotionEvent me) {
		return sd.onTouch(null, me);
	}

}
