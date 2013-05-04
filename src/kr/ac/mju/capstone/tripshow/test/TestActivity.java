package kr.ac.mju.capstone.tripshow.test;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.constants.TSConstants;
import kr.ac.mju.capstone.tripshow.tabs.Tab1_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab2_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab3_Activity;
import android.R.anim;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.Toast;

public class TestActivity extends TabActivity implements OnClickListener {

	private TabHost tabHost = null;
	private static final String TAB1 = "tab1";
	private static final String TAB2 = "tab2";
	private static final String TAB3 = "tab3";
	
	private View view; 
	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.test);

		tabHost = getTabHost();

		tabHost.addTab(tabHost
				.newTabSpec(TAB1)
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_tab_home))
				.setContent(new Intent(this, Tab1_Activity.class)));

		tabHost.addTab(tabHost
				.newTabSpec(TAB2)
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_tab_camera))
				.setContent(new Intent(this, Tab2_Activity.class)));

		tabHost.addTab(tabHost
				.newTabSpec(TAB3)
				.setIndicator("",
						getResources().getDrawable(R.drawable.icon_tab_favorit))
				.setContent(new Intent(this, Tab3_Activity.class)));

		findViewById(R.id.search_btn).setOnClickListener(this);
	}
	
	// To animate view slide out from top to bottom
	public void slideToBottom(View view) {
		int h = view.getHeight();
		int b = view.getBottom();
		TranslateAnimation animate = new TranslateAnimation(0, 0, -60, 0);
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
		view.setVisibility(View.VISIBLE);
	}

	// To animate view slide out from bottom to top
	public void slideToTop(final View view) {
		int h = view.getHeight();
		int b = view.getBottom();
		this.view = view;
		TranslateAnimation animate = new TranslateAnimation(0, 0, 60, 0);
		animate.setAnimationListener(new AnimationListener() {
			public void onAnimationStart(Animation animation) {
			}
			
			public void onAnimationRepeat(Animation animation) {
			}
			
			public void onAnimationEnd(Animation animation) {
				view.setVisibility(View.GONE);
			}
		});
		
		animate.setDuration(500);
		animate.setFillAfter(true);
		view.startAnimation(animate);
	}
	

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		if (v.getId() == R.id.search_btn) {
			LinearLayout ll = (LinearLayout)findViewById(R.id.LinearLayout_search);
			if (ll.getVisibility() == View.GONE) {
				slideToBottom(ll);
			} else {
				slideToTop(ll);
			}
		}
	}
}