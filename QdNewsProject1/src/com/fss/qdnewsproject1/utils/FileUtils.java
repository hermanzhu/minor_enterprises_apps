package com.fss.qdnewsproject1.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.app.Activity;
import android.content.Context;
import android.content.res.AssetManager;
import android.util.Log;

public class FileUtils extends Activity{
	AssetManager assetManager=getAssets();
//	getr
	public  String getJsonString(String filename){
		StringBuilder sb=new StringBuilder();
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(assetManager.open(filename)));
			String lineString="";
			while((lineString=br.readLine())!=null){
				Log.d("lineString", lineString);
				sb.append(lineString);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb.toString();
	}

}
