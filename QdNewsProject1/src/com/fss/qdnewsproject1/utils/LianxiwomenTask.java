package com.fss.qdnewsproject1.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.fss.qdnewsproject1.jsonitem.ShopsItem;

import android.os.AsyncTask;

public class LianxiwomenTask extends  AsyncTask<List<HashMap<String, Object>>, Integer, List<HashMap<String, Object>>>{
	List<HashMap<String, Object>> listItems = null;
	@Override
	protected List<HashMap<String, Object>> doInBackground(List<HashMap<String, Object>>... params) {
		// TODO Auto-generated method stub
		try {
			String PATHS = "http://192.168.39.228:8090/JsonTest1/servlet/JsonServlet";
			String jsonString1 = HttpUtils.getJsonContent(PATHS);

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
				return listItems;
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return null;
	}
	@Override
	protected void onPostExecute(List<HashMap<String, Object>> result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
	}

}
