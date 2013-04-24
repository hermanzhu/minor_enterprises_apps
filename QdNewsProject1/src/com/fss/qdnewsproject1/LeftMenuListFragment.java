package com.fss.qdnewsproject1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class LeftMenuListFragment extends ListFragment{


	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.left_menu, container,false);
		return view;
	}
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
	//	SampleAdapter adapter = new SampleAdapter(getActivity());
	//	SimpleAdapter adapter=new SimpleAdapter(getActivity(), null, R.id.listView1, from, to)
		SampleAdapter adapter=new SampleAdapter(getActivity());
		adapter.add(new SampleItem("公司介绍", R.drawable.dianhua));
		adapter.add(new SampleItem("全国各店", R.drawable.gedian));
		adapter.add(new SampleItem("在线预约", R.drawable.dianhua1));
		adapter.add(new SampleItem("关注微信", R.drawable.weixin));
		
		setListAdapter(adapter);
		
	}
	private class SampleItem {
		public String tag;
		public int iconRes;

		public SampleItem(String tag, int iconRes) {
			this.tag = tag;
			this.iconRes = iconRes;
		}
	}
	
	public class SampleAdapter extends ArrayAdapter<SampleItem> {

		public SampleAdapter(Context context) {
			super(context, 0);
		}

		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = LayoutInflater.from(getContext()).inflate(
						R.layout.row, null);
			}
			ImageView icon = (ImageView) convertView
					.findViewById(R.id.row_icon);
			icon.setImageResource(getItem(position).iconRes);
			TextView title = (TextView) convertView
					.findViewById(R.id.row_title);
			title.setText(getItem(position).tag);

			return convertView;
		}

	}

}
