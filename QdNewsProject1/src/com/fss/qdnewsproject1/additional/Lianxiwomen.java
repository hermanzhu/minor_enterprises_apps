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
import com.fss.qdnewsproject1.utils.HttpUtils;
import com.fss.qdnewsproject1.utils.JsonApplication;
import com.fss.qdnewsproject1.utils.JsonUtils;
import com.fss.qdnewsproject1.utils.LianxiwomenTask;

import android.app.Activity;
import android.content.res.AssetManager;
import android.os.AsyncTask;
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

public class Lianxiwomen extends Activity {
	TextView textView = null;
	List<HashMap<String, Object>> listItems = null;
	
	ListView listView=null;
//	SimpleAdapter simpleAdapter=null;
	Button backButton;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_lianxiwomen);
		//textView = (TextView) findViewById(R.id.lianxiwomen_topBar);
		//	lianxiwomenNetWork();
	//	listView=(ListView)findViewById(R.id.lianxiwomenListView1);
		LianxiwomenTask1 lianxiwomenTask=new LianxiwomenTask1();
		lianxiwomenTask.execute(listItems);

		
		System.out.println("\"----\"\"");
		backButton=(Button)findViewById(R.id.lianxiwomen_back);
		
	
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
				
			}
		});
		
	}


	
	
	public class LianxiwomenTask1 extends  AsyncTask<List<HashMap<String, Object>>, Integer, List<HashMap<String, Object>>>{
		List<HashMap<String, Object>> listItems = null;
		@Override
		protected List<HashMap<String, Object>> doInBackground(List<HashMap<String, Object>>... params) {
			// TODO Auto-generated method stub
			try {
//				String PATHS = Contant1.jsonUrlString;
//				String jsonString1 = HttpUtils.getJsonContent(PATHS);
				String paths="jsontxt/txt.json";
				String jsonString1=getJsonString(paths);
				//JsonApplication ja=(JsonApplication)getApplication();
				//String jsonString1=ja.getJsonString();
				Log.d("json", jsonString1);
				// Person person = JsonUtils.getPerson("person",
				// jsonString1);
				List<ShopsItem> shopsItems = JsonUtils.getShopsItems(
						"contact", jsonString1);
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
			listView=(ListView)findViewById(R.id.lianxiwomenListView1);
			SimpleAdapter simpleAdapter = new SimpleAdapter(Lianxiwomen.this,
					listItems, R.layout.lianxiwomen_list_view1, new String[] {
							"name", "addr", "tel" }, new int[] {
							R.id.lianxiwomenListViewTextView_1,
							R.id.lianxiwomenListViewTextView_2,
							R.id.lianxiwomenListViewTextView_3 });
			listView.setAdapter(simpleAdapter);
		}
		
   }
	public  String getJsonString(String filename){
		StringBuilder sb=new StringBuilder();
		AssetManager assetManager=getAssets();
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(assetManager.open(filename)));
			String lineString="";
			while((lineString=br.readLine())!=null){
			//	Log.d("lineString", lineString);
				sb.append(lineString);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}
}