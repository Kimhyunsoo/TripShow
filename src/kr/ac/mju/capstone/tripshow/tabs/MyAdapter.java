package kr.ac.mju.capstone.tripshow.tabs;

import java.util.ArrayList;

import kr.ac.mju.capstone.tripshow.R;
import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	private Context context;
	private LayoutInflater inflater;
	private ArrayList<ListData> list;
	private int layout;
	
	public MyAdapter(Context context, int layout, ArrayList<ListData> list) {
		this.context = context;
		inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		this.layout = layout;
		this.list = list;
	}
	
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View view, ViewGroup viewGruop) {
		// TODO Auto-generated method stub
		if (view == null) {
			view = inflater.inflate(layout, viewGruop, false);
		}
		
		ImageView userImg = (ImageView)view.findViewById(R.id.user_img);
		userImg.setImageURI(Uri.parse(list.get(position).getUserImg()));
		
		ImageView mainImg = (ImageView)view.findViewById(R.id.main_img);
		mainImg.setImageURI(Uri.parse(list.get(position).getMainImg()));
		
		TextView name = (TextView)view.findViewById(R.id.user_text);
		name.setText(list.get(position).getName());
	
		TextView date = (TextView)view.findViewById(R.id.date_text);
		date.setText(list.get(position).getDate());
		
		TextView location = (TextView)view.findViewById(R.id.location_text);
		location.setText(list.get(position).getLocation());
		
		TextView comment_cnt = (TextView)view.findViewById(R.id.comment_cnt_text);
		comment_cnt.setText(list.get(position).getComment_cnt());
		
		TextView favorite_cnt = (TextView)view.findViewById(R.id.favorite_cnt_text);
		favorite_cnt.setText(list.get(position).getFavorite_cnt());
		
		return view;
	}

}
