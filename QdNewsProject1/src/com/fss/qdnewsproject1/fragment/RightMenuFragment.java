package com.fss.qdnewsproject1.fragment;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.fss.qdnewsproject1.R;
import com.fss.qdnewsproject1.Constant.Contant1;
import com.fss.qdnewsproject1.additional.GongsiJieshao;
import com.fss.qdnewsproject1.additional.Gongsigedian;
import com.fss.qdnewsproject1.additional.Lianxiwomen;
import com.fss.qdnewsproject1.additional.ZaixianDingcan;
import com.fss.qdnewsproject1.jsonitem.JidiItem;
import com.fss.qdnewsproject1.jsonitem.ShopsItem;
import com.fss.qdnewsproject1.utils.HttpUtils;
import com.fss.qdnewsproject1.utils.JsonUtils;

import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
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

public class RightMenuFragment extends Fragment {
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
		contextView = inflater.inflate(R.layout.right_menu, container, false);
	//	listView = (ListView) contextView.findViewById(R.id.rightMenuListView1);
	//	initialList();
		RightMenuTask1 rightMenuTask1=new RightMenuTask1();
		rightMenuTask1.execute(listItems);
		
//		SimpleAdapter listItemAdapter = new SimpleAdapter(getActivity(),
//				listItems, R.layout.right_menu_list_view, new String[] {
//						"ItemImage", "TextItem"}, new int[] {
//						R.id.rightMenuListViewImageView1,
//						R.id.rightMenuListViewTextView1,
//						});
//		listView.setAdapter(listItemAdapter);
		
		
		
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
//		int iteri=0;
//		for (HashMap<String, Object> hashMap : listItems) {
//			iteri++;
//			System.out.println("-----"+iteri+"----"+hashMap.get("TextItem"));
//		}
//		
		
		return listItems;

	}
	
	public class RightMenuTask1 extends  AsyncTask<List<HashMap<String, Object>>, Integer, List<HashMap<String, Object>>>{
		List<HashMap<String, Object>> listItems = null;
		@Override
		protected List<HashMap<String, Object>> doInBackground(List<HashMap<String, Object>>... params) {
			// TODO Auto-generated method stub
			try {
				String PATHS = Contant1.jsonUrlString;
				String jsonString1 = HttpUtils.getJsonContent(PATHS);

				// Person person = JsonUtils.getPerson("person",
				// jsonString1);
				List<JidiItem> jidiItems = JsonUtils.getJidiItems(
						"bases", jsonString1);
				listItems = new ArrayList<HashMap<String, Object>>();
				HashMap<String, Object> map = null;
				for (Iterator iterator = jidiItems.iterator(); iterator
						.hasNext();) {
					JidiItem jidiItem = (JidiItem) iterator.next();
					//Log.d("ShopsItem", shopsItem.getName());
					map = new HashMap<String, Object>();
					map.put("name", jidiItem.getName());

					map.put("id", jidiItem.getId());
					
				//	Log.d("map", map.get("addr").toString());
					listItems.add(map);
					
				}
				return listItems;
			} catch (Exception e) {
				// TODO: handle exception
			}
			
			return null;
		}

		@Override
		protected void onPostExecute(List<HashMap<String, Object>> result) {
			// TODO Auto-generated method stub
			//super.onPostExecute(result);
			listItems=result;
			listView=(ListView)getActivity().findViewById(R.id.rightMenuListView1);
			SimpleAdapter simpleAdapter = new SimpleAdapter(getActivity(),
					listItems, R.layout.right_menu_list_view, new String[] {
							"name", "id" }, new int[] {
							R.id.rightMenuListViewTextView1,
							R.id.rightMenuListViewTextView2,
						});
			listView.setAdapter(simpleAdapter);
		}
		
   }
	

}
