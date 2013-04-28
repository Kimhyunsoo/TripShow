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
import android.widget.Toast;

public class TabsActivity extends TabActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_layout);
 
		final TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec("tab1")
		// .setIndicator("Device List",
		// getResources().getDrawable(R.drawable.device_icon))
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_home))
				.setContent(new Intent(this, Tab1_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab2")
		// .setIndicator("Device detail",
		// getResources().getDrawable(R.drawable.pie_chart))
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_camera))
				.setContent(new Intent(this, Tab2_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab3")
		// .setIndicator("Information",
		// getResources().getDrawable(R.drawable.inward_black_info))
				.setIndicator("", getResources().getDrawable(R.drawable.icon_tab_favorit))
				.setContent(new Intent(this, Tab3_Activity.class)));

		((ImageButton)findViewById(R.id.list_btn)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.search_btn)).setOnClickListener(this);
		
		for (int i = 0; i < 3; i++) {
			tabHost.getTabWidget().getChildAt(i).setBackgroundColor(Color.parseColor("#F7876D"));
		}
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
}