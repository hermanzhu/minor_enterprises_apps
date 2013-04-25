package com.fss.qdnewsproject1.utils;

import android.app.Application;

public class JsonApplication extends Application{
	private String jsonString;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		setJsonString("json");
	}

	public String getJsonString() {
		return jsonString;
	}

	public void setJsonString(String jsonString) {
		this.jsonString = jsonString;
	}

}
