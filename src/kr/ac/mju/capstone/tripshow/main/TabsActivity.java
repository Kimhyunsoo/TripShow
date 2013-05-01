package kr.ac.mju.capstone.tripshow.main;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.tabs.Tab1_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab2_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab3_Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.Toast;

public class TabsActivity extends TabActivity implements OnClickListener, OnTabChangeListener {
	private static final String TAB1 = "tab1";
	private static final String TAB2 = "tab2";
	private static final String TAB3 = "tab3";
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_layout);
 
		final TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec(TAB1)
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_home))
				.setContent(new Intent(this, Tab1_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB2)
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_camera))
				.setContent(new Intent(this, Tab2_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec(TAB3)
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_favorit))
				.setContent(new Intent(this, Tab3_Activity.class)));

		((ImageButton)findViewById(R.id.list_btn)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.search_btn)).setOnClickListener(this);
		
		for (int i = 0; i < 3; i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#F7876D"));
		}
		
		tabHost.setOnTabChangedListener(this);
		findViewById(R.id.tab1_indicator).setBackgroundColor(Color.parseColor("#ffffff"));
		findViewById(R.id.tab2_indicator).setBackgroundColor(Color.parseColor("#000000"));
		findViewById(R.id.tab3_indicator).setBackgroundColor(Color.parseColor("#000000"));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.list_btn:
			Toast.makeText(getBaseContext(), "List Button", Toast.LENGTH_SHORT).show();
			break;
		case R.id.search_btn:
			LinearLayout linearLayout = (LinearLayout)findViewById(R.id.LinearLayout_search);
			if (linearLayout.getVisibility() == View.GONE) {
				linearLayout.setVisibility(View.VISIBLE);
			} else {
				linearLayout.setVisibility(View.GONE);
			}
			break;
		default:
			break;
		}
	}

	@Override
	public void onTabChanged(String tabId) {
		// TODO Auto-generated method stub
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