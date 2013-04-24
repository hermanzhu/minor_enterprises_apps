package com.fss.qdnewsproject1.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import com.fss.qdnewsproject1.LeftMenuActivity;
import com.fss.qdnewsproject1.R;
import com.fss.qdnewsproject1.additional.GongsiJieshao;
import com.fss.qdnewsproject1.additional.Gongsigedian;
import com.fss.qdnewsproject1.additional.Lianxiwomen;
import com.fss.qdnewsproject1.additional.ZaixianDingcan;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class LeftMenuFragment extends Fragment {
	private View contextView;
	private ListView listView;
	private List<HashMap<String, Object>> listItems=null;
	private ImageView imageViewTel;
	private TextView textViewTel;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setRetainInstance(true);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		contextView = inflater.inflate(R.layout.left_menu, container, false);
		listView = (ListView) contextView.findViewById(R.id.leftMenuListView1);
		initialList();
		imageViewTel=(ImageView)contextView.findViewById(R.id.left_menu_tel_imageView);
		textViewTel=(TextView)contextView.findViewById(R.id.left_menu_tel_textView);
		
		SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(),
				listItems, R.layout.left_menu_list_view, new String[] {
						"ItemImage", "TextItem", "JiantouImage" }, new int[] {
						R.id.leftMenuListViewImageView1,
						R.id.leftMenuListViewTextView1,
						R.id.leftMenuListViewImageView2 });
		listView.setAdapter(listItemAdapter);
		listView.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				// TODO Auto-generated method stub
//				System.out.println("view---------" + position + "id----" + id
//						+ "view----" + view.getId());
				Intent intent=null;
				switch (position) {
				case 0:
					intent = new Intent(getActivity(),
							GongsiJieshao.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(getActivity(),
							Gongsigedian.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(getActivity(),
							ZaixianDingcan.class);
					startActivity(intent);
					break;
				case 3:
					 intent = new Intent(getActivity(),
							ZaixianDingcan.class);
					startActivity(intent);
					break;
				case 4:
					 intent = new Intent(getActivity(),
							 Lianxiwomen.class);
					startActivity(intent);
					break;
				case 5:
					 intent = new Intent(getActivity(),
							Lianxiwomen.class);
					startActivity(intent);
					break;

				default:
					break;
				}

				
			}
		});
		imageViewTel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View paramView) {
				try {					
					   Intent intent = new Intent(Intent.ACTION_CALL);
					   intent.setData(Uri.parse("tel:+4001676668"));
					   startActivity(intent);
					
					} catch (Exception e) {
					 Log.e("SampleApp", "Failed to invoke call", e);
					}

				
			}
		});
		textViewTel.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View paramView) {
				try {					
					   Intent intent = new Intent(Intent.ACTION_CALL);
					   intent.setData(Uri.parse("tel:+4001676668"));
					   startActivity(intent);
					
					} catch (Exception e) {
					 Log.e("SampleApp", "Failed to invoke call", e);
					}

				
			}
		});
		return contextView;
	}
	
	protected List<HashMap<String, Object>> initialList(){
		listItems = new ArrayList<HashMap<String, Object>>();
//		List<HashMap<String, Object>> listItems = new ArrayList<HashMap<String, Object>>();

//		for (int i = 0; i < 5; i++) {
//			HashMap<String, Object> map = new HashMap<String, Object>();
//			map.put("ItemImage", R.drawable.dianhua12x);
//			map.put("TextItem", "咨询电话");
//			map.put("JiantouImage", R.drawable.jiantou12x);
//			listItems.add(map);
//
//		}
		HashMap<String, Object> map = new HashMap<String, Object>();
		map.put("ItemImage", R.drawable.jieshao2x);
		map.put("TextItem", "  公司介绍");
		map.put("JiantouImage", R.drawable.jiantou12x);
		listItems.add(map);
		map=new HashMap<String, Object>();
		map.put("ItemImage", R.drawable.gedian2x);
		map.put("TextItem", "  全国各店");
		map.put("JiantouImage", R.drawable.jiantou12x);
		listItems.add(map);
		map=new HashMap<String, Object>();
		map.put("ItemImage", R.drawable.yuyue12x);
		map.put("TextItem", "  在线预约");
		map.put("JiantouImage", R.drawable.jiantou12x);
		listItems.add(map);
		map=new HashMap<String, Object>();
		map.put("ItemImage", R.drawable.weixin2x);
		map.put("TextItem", "  关注微信");
		map.put("JiantouImage", R.drawable.jiantou12x);
		listItems.add(map);
		map=new HashMap<String, Object>();
		map.put("ItemImage", R.drawable.women2x);
		map.put("TextItem", "  联系我们");
		map.put("JiantouImage", R.drawable.jiantou12x);
		listItems.add(map);
//		map=new HashMap<String, Object>();
//		map.put("ItemImage", R.drawable.dianhua12x);
//		map.put("TextItem", "   咨询电话");
//		map.put("JiantouImage", R.drawable.jiantou12x);
//		listItems.add(map);
//		int iteri=0;
//		for (HashMap<String, Object> hashMap : listItems) {
//			iteri++;
//			System.out.println("-----"+iteri+"----"+hashMap.get("TextItem"));
//		}
//		
		
		return listItems;

	}
	

}
