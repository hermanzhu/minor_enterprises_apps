package com.fss.qdnewsproject1.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

import com.fss.qdnewsproject1.jsonitem.JidiItem;
import com.fss.qdnewsproject1.jsonitem.ShopsItem;

public class JsonUtils {
	public JsonUtils() { 
        
    } 
     
    /** 
     * 获取对象数据 
     * @param key 
     * @param jsonString 
     * @return 
     */ 
    public static Person getPerson(String key,String jsonString){ 
        Person person = new Person(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            JSONObject personObject = jsonObject.getJSONObject(key); 
            person.setId(personObject.getInt("id")); 
            person.setName(personObject.getString("name")); 
            person.setAddress(personObject.getString("address")); 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
        return person; 
    } 
    
    /**
     * 
    * @Title: getShop 
    * @Description: TODO
    * @param @param key
    * @param @param jsonString
    * @param @return    设定文件 
    * @return ShopsItem    返回类型 
    * @throws
     */
    public static ShopsItem getShop(String key,String jsonString){ 
        ShopsItem shopsItem = new ShopsItem(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            JSONObject personObject = jsonObject.getJSONObject(key); 
            shopsItem.setTel(personObject.getString("tel")); 
            shopsItem.setName(personObject.getString("name")); 
            shopsItem.setAddr(personObject.getString("addr")); 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
        return shopsItem; 
    }
    
    public static String getJianjieItem(String key,String jsonString){
    	String jianjie="";
    	 try {
			JSONObject jsonObject = new JSONObject(jsonString);
		//	jsonObject.getJSONObject(key).getString("");
		//	Log.d("json", jsonObject.getJSONObject(key).getString("").toString());
		//	Log.d("json", jsonObject.getJSONObject(key).toString());
		//Log.d("json", jsonObject.getString("about"))	;
			 jianjie=jsonObject.getString("about");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
    	return jianjie;
    }
    
    public static JidiItem getJidiItem(String key,String jsonString){ 
        JidiItem jidiItem = new JidiItem(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            JSONObject personObject = jsonObject.getJSONObject(key); 
            jidiItem.setId(personObject.getString("id")); 
            jidiItem.setName(personObject.getString("name")); 
           
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
        return jidiItem; 
    }
     
    /** 
     * 获取对象数组数据 
     * @param key 
     * @param jsonString 
     * @return 
     */ 
    public static List<Person> getPersons(String key,String jsonString){ 
        List<Person> list = new ArrayList<Person>(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            //返回json的数组 
            JSONArray jsonArray = jsonObject.getJSONArray(key); 
            for(int i=0;i<jsonArray.length();i++){ 
                JSONObject jsonObject2 = jsonArray.getJSONObject(i); 
                Person person = new Person(); 
                person.setId(jsonObject2.getInt("id")); 
                person.setName(jsonObject2.getString("name")); 
                person.setAddress(jsonObject2.getString("address")); 
                list.add(person); 
            } 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
         
        return list; 
    } 
    public static List<ShopsItem> getShopsItems(String key,String jsonString){ 
        List<ShopsItem> list = new ArrayList<ShopsItem>(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            //返回json的数组 
            JSONArray jsonArray = jsonObject.getJSONArray(key); 
            for(int i=0;i<jsonArray.length();i++){ 
                JSONObject jsonObject2 = jsonArray.getJSONObject(i); 
                ShopsItem shopItem = new ShopsItem(); 
                shopItem.setTel(jsonObject2.getString("tel")); 
                shopItem.setName(jsonObject2.getString("name")); 
                shopItem.setAddr(jsonObject2.getString("addr")); 
                list.add(shopItem); 
            } 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
         
        return list; 
    } 
    
    
    public static List<JidiItem> getJidiItems(String key,String jsonString){ 
        List<JidiItem> list = new ArrayList<JidiItem>(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            //返回json的数组 
            JSONArray jsonArray = jsonObject.getJSONArray(key); 
            for(int i=0;i<jsonArray.length();i++){ 
                JSONObject jsonObject2 = jsonArray.getJSONObject(i); 
                JidiItem jidiItem = new JidiItem(); 
                jidiItem.setId(jsonObject2.getString("id")); 
                jidiItem.setName(jsonObject2.getString("name")); 
               
                list.add(jidiItem); 
            } 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
         
        return list; 
    } 
    /** 
     * 获取String数组数据 
     * @param key 
     * @param jsonString 
     * @return 
     */ 
    public static List<String> getList(String key,String jsonString){ 
        List<String> list = new ArrayList<String>(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            JSONArray jsonArray = jsonObject.getJSONArray(key); 
            for(int i=0;i<jsonArray.length();i++){ 
                String msg = jsonArray.getString(i); 
                list.add(msg); 
            } 
        } catch (JSONException e) { 
            e.printStackTrace(); 
        } 
        return list; 
    } 
    /** 
     * 获取对象的Map集合数据 
     * @param key 
     * @param jsonString 
     * @return 
     */ 
    public static List<Map<String,Object>> getListMap(String key,String jsonString){ 
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>(); 
        try { 
            JSONObject jsonObject = new JSONObject(jsonString); 
            JSONArray jsonArray = jsonObject.getJSONArray(key); 
            for(int i=0;i<jsonArray.length();i++){ 
                JSONObject jsonObject2 = jsonArray.getJSONObject(i); 
                Map<String,Object> map = new HashMap<String, Object>(); 
                Iterator<String> iterator = jsonObject2.keys(); 
                while(iterator.hasNext()){ 
                    String json_key = iterator.next(); 
                    Object json_value = jsonObject2.get(json_key); 
                    if(json_value==null){ 
                        json_value = ""; 
                    } 
                    map.put(json_key, json_value); 
                } 
                list.add(map); 
               
            } 
        } catch (JSONException e) { 
            // TODO Auto-generated catch block 
            e.printStackTrace(); 
        } 
         
        return list; 
    } 
 

}
