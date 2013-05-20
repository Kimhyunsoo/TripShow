package kr.ac.mju.capstone.tripshow.tabs;

import java.util.ArrayList;

import kr.ac.mju.capstone.tripshow.R;
import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.widget.ListView;

public class Tab1_Activity extends Activity {

	private MyAdapter mAdapter;
	private ListData data;
	private ListView listView;  
	private ArrayList<ListData> dList;

	
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
	    setContentView(R.layout.tab1_layout);
	    
	    dList = new ArrayList<ListData>();
	    
	    for (int i = 0; i < 3; i++) {
	    	data = new ListData("R.drawable.icon_sidemenu_mypage", "mainImg", "name", "date", "in seoul", "1", "2");
	    	dList.add(data);
	    }
	    
	    mAdapter = new MyAdapter(this, R.layout.home_list, dList);
	    listView = (ListView)findViewById(R.id.listView1);
	    listView.setAdapter(mAdapter);
	    //listView.setOnItemClickListener(this);

	    
	    
	    
	    
	    
	    
	}

}
