package kr.ac.mju.capstone.tripshow.main;

import java.util.ArrayList;

import kr.ac.mju.capstone.tripshow.R;
import kr.ac.mju.capstone.tripshow.constants.TSConstants;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class SideMenuListAdapter extends BaseAdapter {

	private ArrayList<SideMenuData> sList;
	private LayoutInflater inflater;
	private int layout;
	
	public SideMenuListAdapter(Context context, int layout, ArrayList<SideMenuData> sList) {
		this.sList = sList;
		this.inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.layout = layout;
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return sList.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return sList.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup parent) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = inflater.inflate(layout, parent, false);
		}
		
		ImageView imgView = (ImageView)view.findViewById(R.id.sidemenu_row_img);
		imgView.setImageResource(sList.get(position).getImgId());
		
		TextView tv = (TextView)view.findViewById(R.id.sidemenu_row_text);
		tv.setText(sList.get(position).getName());
		return view;
	}
	
}
