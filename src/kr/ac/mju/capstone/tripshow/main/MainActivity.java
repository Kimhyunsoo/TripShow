package kr.ac.mju.capstone.tripshow.main;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.tabs.Tab1_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab2_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab3_Activity;
import kr.ac.mju.capstone.tripshow.tabs.Tab4_Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
 
		final TabHost tabHost = getTabHost();

		tabHost.addTab(tabHost.newTabSpec("tab1")
		// .setIndicator("Device List",
		// getResources().getDrawable(R.drawable.device_icon))
				.setIndicator("First")
				.setContent(new Intent(this, Tab1_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab2")
		// .setIndicator("Device detail",
		// getResources().getDrawable(R.drawable.pie_chart))
				.setIndicator("Second")
				.setContent(new Intent(this, Tab2_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab3")
		// .setIndicator("Information",
		// getResources().getDrawable(R.drawable.inward_black_info))
				.setIndicator("Third")
				.setContent(new Intent(this, Tab3_Activity.class)));

		tabHost.addTab(tabHost.newTabSpec("tab4")
		// .setIndicator("Information",
		// getResources().getDrawable(R.drawable.inward_black_info))
				.setIndicator("Fourth")
				.setContent(new Intent(this, Tab4_Activity.class)));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
