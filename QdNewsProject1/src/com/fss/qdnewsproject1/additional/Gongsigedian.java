package com.fss.qdnewsproject1.additional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.fss.qdnewsproject1.R;
import com.fss.qdnewsproject1.Constant.Contant1;
import com.fss.qdnewsproject1.jsonitem.ShopsItem;
import com.fss.qdnewsproject1.utils.FileUtils;
import com.fss.qdnewsproject1.utils.HttpUtils;
import com.fss.qdnewsproject1.utils.JsonApplication;
import com.fss.qdnewsproject1.utils.JsonUtils;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

public class Gongsigedian extends Activity {
	TextView textView = null;
	List<HashMap<String, Object>> listItems = null;
	
	ListView listView=null;
//	SimpleAdapter simpleAdapter=null;
	Button backButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_gongsigedian);
		textView = (TextView) findViewById(R.id.gongsigedian_topbar_textview);
			GongsigedianNetWork();
		System.out.println("\"----\"\"");
		backButton=(Button)findViewById(R.id.gongsigedian_back);
	
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
	}

	private Handler handler = new Handler() {
		@Override
		public void handleMessage(Message msg) {
			List<HashMap<String, Object>> shopsItems = (List<HashMap<String, Object>>) msg.obj;
			SimpleAdapter simpleAdapter = new SimpleAdapter(Gongsigedian.this,
					shopsItems, R.layout.gongsigedian_list_view1, new String[] {
							"name", "addr", "tel" }, new int[] {
							R.id.gongsigedianListViewTextView_1,
							R.id.gongsigedianListViewTextView_2,
							R.id.gongsigedianListViewTextView_3 });
			// SimpleAdapter simpleAdapter=new SimpleAdapter(Gongsigedian.class,
			// shopsItems, R.layout.gongsigedian_list_view, new
			// String[]{"name"}, new int[]{R.id.gongsigedianListViewTextView1});
			// new sim
			Log.d("simpleadapter",String.valueOf(simpleAdapter.getCount()) );
			Log.d("simpleadapter",String.valueOf(simpleAdapter.getItem(1)) );
			Log.d("simpleadapter",String.valueOf(simpleAdapter.areAllItemsEnabled()) );
			simpleAdapter.notifyDataSetChanged();
			listView=(ListView)findViewById(R.id.gongsigedianListView1);
			listView.setAdapter(simpleAdapter);
		//	textView.setText(shopsItems.get(1).get("name").toString());
			
			
		}
	};

	private void GongsigedianNetWork() {
		new Thread() {
			public void run() {
				try {

					String PATHS = Contant1.jsonUrlString;
					String jsonString1 = HttpUtils.getJsonContent(PATHS);
//					JsonApplication ja=(JsonApplication)getApplication();
//					String jsonString1=ja.getJsonString();
					//Log.d("jsonstring", jsonString1);
					
					// Person person = JsonUtils.getPerson("person",
					// jsonString1);
					List<ShopsItem> shopsItems = JsonUtils.getShopsItems(
							"shops", jsonString1);
					listItems = new ArrayList<HashMap<String, Object>>();
					HashMap<String, Object> map = null;
					for (Iterator iterator = shopsItems.iterator(); iterator
							.hasNext();) {
						ShopsItem shopsItem = (ShopsItem) iterator.next();
						//Log.d("ShopsItem", shopsItem.getName());
						map = new HashMap<String, Object>();
						map.put("name", shopsItem.getName());

						map.put("addr", shopsItem.getAddr());
						map.put("tel", shopsItem.getTel());
					//	Log.d("map", map.get("addr").toString());
						listItems.add(map);

					}
					Message message = Message.obtain();
					message.obj = listItems;
					handler.sendMessage(message);

				} catch (Exception e) {
					e.printStackTrace();
				}

			}

		}.start();
	}
	
	

}
