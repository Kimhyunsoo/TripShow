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
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.TabHost;
import android.widget.Toast;

public class TabsActivity extends TabActivity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_lyaout);
 
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

		((ImageButton)findViewById(R.id.list_btn)).setOnClickListener(this);
		((ImageButton)findViewById(R.id.search_btn)).setOnClickListener(this);
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
			Toast.makeText(getBaseContext(), "Search Button", Toast.LENGTH_SHORT).show();
			break;
		default:
			break;
		}
	}
}
