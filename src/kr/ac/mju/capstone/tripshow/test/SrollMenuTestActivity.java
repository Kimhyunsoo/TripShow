package kr.ac.mju.capstone.tripshow.test;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.constants.TSConstants;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;

public class SrollMenuTestActivity extends Activity implements OnTouchListener {
	private boolean isMenuOpened = false;
	private int startX = 0;
	private int endX = 0;

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test_layout);
		// TODO Auto-generated method stub
		findViewById(R.id.slide_menu_btn).setOnTouchListener(this);
		View view = findViewById(R.id.contents);
		
		startX = 0;
		endX = (int)(view.getMeasuredWidth() * 0.7);
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			View contentView = findViewById(R.id.contents);
			
			switch (msg.what) {
			case TSConstants.SLIDING_LEFT:
				if (contentView.getLeft() >= endX) {
					contentView.layout(endX, contentView.getTop(), contentView.getRight() + endX, contentView.getBottom());
					isMenuOpened = true;
					findViewById(R.id.sub_layout).setClickable(true);
				} else {
					contentView.layout(contentView.getLeft() + 15, contentView.getTop(), contentView.getRight() + 15,
							contentView.getBottom());
				}
				break;
			case TSConstants.SLIDING_RIGHT:
				if (contentView.getLeft() <= 0) {
					contentView.layout(0, contentView.getTop(), contentView.getRight(), contentView.getBottom());
					isMenuOpened = false;
					findViewById(R.id.sub_layout).setClickable(false);
				} else {
					contentView.layout(contentView.getLeft() - 15, contentView.getTop(), contentView.getRight() - 15,
							contentView.getBottom());
				}
				break;
			default:
				break;
			}
		}
	};

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		// TODO Auto-generated method stub
		if (event.getAction() == MotionEvent.ACTION_UP) {
			if (isMenuOpened) {
				handler.sendEmptyMessage(TSConstants.SLIDING_LEFT);
			} else if (!isMenuOpened) {
				handler.sendEmptyMessage(TSConstants.SLIDING_RIGHT);
			}
		} else if (event.getAction() == MotionEvent.ACTION_MOVE) {

		}
		return false;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		if (isMenuOpened) {

		} else {
			super.onBackPressed();
		}
	}

}
