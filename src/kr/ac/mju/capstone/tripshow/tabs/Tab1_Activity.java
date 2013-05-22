package kr.ac.mju.capstone.tripshow.tabs;

import java.util.ArrayList;

import kr.ac.mju.capstone.tripshow.R;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ListView;

public class Tab1_Activity extends Activity implements OnClickListener, OnItemClickListener{

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
	    	data = new ListData(R.drawable.icon_sidemenu_mypage,R.drawable.icon_launcher , "name", "date", "in seoul","0","0");
	    	dList.add(data);
	    }
	    
	    mAdapter = new MyAdapter(this, R.layout.home_list, dList);
	    listView = (ListView)findViewById(R.id.listView1);
	    listView.setAdapter(mAdapter);
	    listView.setOnItemClickListener(this);

	    
	    
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
//		Intent intent = new Intent(this,);
//		startActivity(intent);
	}


	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		
	}



}
