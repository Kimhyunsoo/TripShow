package kr.ac.mju.capstone.tripshow.main;

import java.util.Timer;
import java.util.TimerTask;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.constants.TSConstants;
import kr.ac.mju.capstone.tripshow.tabs.Tab1_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab2_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab3_Activity;
import kr.ac.mju.mdc.mjuapp.util.PixelConverter;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TextView;
import android.widget.Toast;

public class TabsActivity extends TabActivity implements OnTouchListener, OnClickListener, OnTabChangeListener {
	private static final String TAB1 = "tab1";
	private static final String TAB2 = "tab2";
	private static final String TAB3 = "tab3";
	
	private boolean isMenuOpened = false;
	private int leftMax = 0;
	private int leftMin = 0;

	private float oldX = 0;
	private float upOldX = 0;

	private Timer slidingTimer = null;
	private TimerTask slidingTimerTask = null;
	
	private TabHost tabHost = null;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_layout);
 
		tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec(TAB1)
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_home))
				.setContent(new Intent(this, Tab1_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB2)
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_camera))
				.setContent(new Intent(this, Tab2_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB3)
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_favorit))
				.setContent(new Intent(this, Tab3_Activity.class)));

		((ImageButton)findViewById(R.id.search_btn)).setOnClickListener(this);
		
		for (int i = 0; i < 3; i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#F7876D"));
		}
		
		tabHost.setOnTabChangedListener(this);
		findViewById(R.id.tab1_indicator).setBackgroundColor(Color.parseColor("#ffffff"));
		findViewById(R.id.tab2_indicator).setBackgroundColor(Color.parseColor("#000000"));
		findViewById(R.id.tab3_indicator).setBackgroundColor(Color.parseColor("#000000"));
		
		init();
		initLayout();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	private void init() {
		// init url //general notice url
		//
		isMenuOpened = false;
		oldX = 0;
		upOldX = 0;
		DisplayMetrics displaymetrics = new DisplayMetrics();
		getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		PixelConverter converter = new PixelConverter(this);
		leftMax = (int) ((float)displaymetrics.widthPixels - converter.getWidth(135));
		leftMin = 0;
		
		findViewById(R.id.logout_btn).setOnClickListener(this);
		findViewById(R.id.sidemenu_friends).setOnClickListener(this);
		findViewById(R.id.sidemenu_message).setOnClickListener(this);
		findViewById(R.id.sidemenu_mypage).setOnClickListener(this);
		findViewById(R.id.sidemenu_settings).setOnClickListener(this);
		
		findViewById(R.id.slide_menu_btn).setOnTouchListener(this);
	}
	
	private void initLayout(){
		PixelConverter converter = new PixelConverter(this);
		RelativeLayout.LayoutParams rParams = null;
		rParams = (LayoutParams) findViewById(R.id.sub_layout).getLayoutParams();
		rParams.rightMargin = converter.getWidth(135);
		findViewById(R.id.sub_layout).setLayoutParams(rParams);
	}

	private Handler handler = new Handler() {
		public void handleMessage(Message msg) {
			super.handleMessage(msg);
			
			switch (msg.what) {
			case TSConstants.SLIDING_LEFT:
				slidingTimer = new Timer();
				slidingTimerTask = new TimerTask() {
					@Override
					public void run() {
						handler.post(new Runnable() {
							@Override
							public void run() {
								View contentView = findViewById(R.id.contents);
								// right to left
								if (contentView.getLeft() <= leftMin) {
									contentView.layout(0, contentView.getTop(), contentView.getRight(), contentView.getBottom());
									stopSlidingTimer();
									oldX = 0;
									upOldX = 0;
									isMenuOpened = false;
//									findViewById(R.id.notice_list_left_slidingbar).setClickable(false);
								} else {
									contentView.layout(contentView.getLeft() - 15, contentView.getTop(), contentView.getRight() - 15,
											contentView.getBottom());
								}
							}
						});
					}
				};
				slidingTimer.schedule(slidingTimerTask, 0, 5);
				break;
			case TSConstants.SLIDING_RIGHT:
				slidingTimer = new Timer();
				slidingTimerTask = new TimerTask() {
					@Override
					public void run() {
						handler.post(new Runnable() {
							@Override
							public void run() {
								View contentView = findViewById(R.id.contents);
								// to right
								if (contentView.getLeft() >= leftMax) {
									contentView.layout(leftMax, contentView.getTop(), leftMax + contentView.getRight(),
											contentView.getBottom());
									stopSlidingTimer();
									oldX = 0;
									upOldX = 0;
									isMenuOpened = true;
//									findViewById(R.id.notice_list_left_slidingbar).setClickable(true);
								} else {
									contentView.layout(contentView.getLeft() + 15, contentView.getTop(), contentView.getRight() + 15,
											contentView.getBottom());
								}
							}
						});
					}
				};
				slidingTimer.schedule(slidingTimerTask, 0, 5);
				break;
			default:
				break;
			}
		}
	};

	@Override
	public boolean onTouch(View v, MotionEvent event) {
		if (event.getAction() == MotionEvent.ACTION_MOVE) {
			float currentX = event.getRawX();
			if (oldX == 0.)
				oldX = currentX;
			// drag
			View view = findViewById(R.id.contents);
			if (view.getLeft() <= leftMax && view.getLeft() >= leftMin) {
				view.layout((int) (view.getLeft() - (oldX - currentX)), view.getTop(), (int) (view.getRight() - (oldX - currentX)),
						view.getBottom());
				upOldX = oldX;
				oldX = currentX;
			}
		} else if (event.getAction() == MotionEvent.ACTION_UP) {
			final float currentX = event.getRawX();
			// direction
			float direction = upOldX - currentX;
			if (isMenuOpened)
				handler.sendEmptyMessage(TSConstants.SLIDING_LEFT);
			else if (!isMenuOpened)
				handler.sendEmptyMessage(TSConstants.SLIDING_RIGHT);
			else if (direction > 0)
				handler.sendEmptyMessage(TSConstants.SLIDING_LEFT);
			else if (direction < 0)
				handler.sendEmptyMessage(TSConstants.SLIDING_RIGHT);
		}
		return false;
	}

	@Override
	public void onBackPressed() {
		if (isMenuOpened)
			handler.sendEmptyMessage(TSConstants.SLIDING_LEFT);
		else
			super.onBackPressed();
	}
	
	private void stopSlidingTimer() {
		if (slidingTimerTask != null) {
			slidingTimerTask.cancel();
			slidingTimerTask = null;
		}
		if (slidingTimer != null) {
			slidingTimer.purge();
			slidingTimer.cancel();
			slidingTimer = null;
		}
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.search_btn:
			LinearLayout linearLayout = (LinearLayout)findViewById(R.id.LinearLayout_search);
			if (linearLayout.getVisibility() == View.GONE) {
				slideToBottom(linearLayout);
			} else {
				slideToTop(linearLayout);
			}
			break;
		case R.id.logout_btn:
			Toast.makeText(getBaseContext(), "Logout", Toast.LENGTH_SHORT).show();
			break;
		case R.id.sidemenu_mypage:
			goToMyPage();
			break;
		case R.id.sidemenu_message:
			Toast.makeText(getBaseContext(), "message", Toast.LENGTH_SHORT).show();
			break;
		case R.id.sidemenu_friends:
			Toast.makeText(getBaseContext(), "friends", Toast.LENGTH_SHORT).show();
			break;
		case R.id.sidemenu_settings:
			Toast.makeText(getBaseContext(), "setting", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}

	private void goToMyPage() {
		FrameLayout fm = (FrameLayout)findViewById(android.R.id.tabcontent);
		fm.removeAllViews();
		
		LinearLayout linerLayout = new LinearLayout(this);
		linerLayout.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.FILL_PARENT));
		linerLayout.setBackgroundColor(Color.parseColor("#f9e2b0"));
		TextView tv = new TextView(this);
		tv.setText("My Page");
		tv.setTextColor(Color.BLACK);
		
		fm.addView(linerLayout);
		
	}
	
	public void slideToBottom(View view){
		TranslateAnimation animate = new TranslateAnimation(0,0,0,view.getHeight());
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.VISIBLE);
	}
	
	// To animate view slide out from bottom to top
	public void slideToTop(View view){
		TranslateAnimation animate = new TranslateAnimation(0,0,0,-view.getHeight());
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.GONE);
	}

	@Override
	public void onTabChanged(String tabId) {
		if (tabId.equals(TAB1)) {
			findViewById(R.id.tab1_indicator).setBackgroundColor(Color.parseColor("#ffffff"));
			findViewById(R.id.tab2_indicator).setBackgroundColor(Color.parseColor("#000000"));
			findViewById(R.id.tab3_indicator).setBackgroundColor(Color.parseColor("#000000"));
		} else if (tabId.equals(TAB2)) {
			findViewById(R.id.tab1_indicator).setBackgroundColor(Color.parseColor("#000000"));
			findViewById(R.id.tab2_indicator).setBackgroundColor(Color.parseColor("#ffffff"));
			findViewById(R.id.tab3_indicator).setBackgroundColor(Color.parseColor("#000000"));
		} else if (tabId.equals(TAB3)) {
			findViewById(R.id.tab1_indicator).setBackgroundColor(Color.parseColor("#000000"));
			findViewById(R.id.tab2_indicator).setBackgroundColor(Color.parseColor("#000000"));
			findViewById(R.id.tab3_indicator).setBackgroundColor(Color.parseColor("#ffffff"));
		}
	}
}