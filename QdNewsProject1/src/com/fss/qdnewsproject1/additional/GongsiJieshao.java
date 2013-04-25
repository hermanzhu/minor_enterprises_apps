package com.fss.qdnewsproject1.additional;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.fss.qdnewsproject1.R;
import com.fss.qdnewsproject1.Constant.Contant1;
import com.fss.qdnewsproject1.utils.HttpUtils;
import com.fss.qdnewsproject1.utils.JsonApplication;
import com.fss.qdnewsproject1.utils.JsonUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.res.AssetManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class GongsiJieshao extends Activity{
	
	private Button backButton;
	private ImageView imageView1;
	private ImageView imageView2;
	private TextView textView1;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_gongsijieshao);
		backButton=(Button)findViewById(R.id.gongsijieshao_back);
	
		GongsijieshaoNetWork();
		backButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View paramView) {
				GongsiJieshao.this.finish();
				
			}
		});
		imageView1=(ImageView)findViewById(R.id.gongsijieshao_imageView1);
		imageView2=(ImageView)findViewById(R.id.gongsijieshao_imageView2);
		textView1=(TextView)findViewById(R.id.gongsijieshao_textView1);
		imageView1.setImageResource(R.drawable.icon_722x);
		imageView2.setImageResource(R.drawable.anniu);
		imageView2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View paramView) {
				try {					
					   Intent intent = new Intent(Intent.ACTION_VIEW);
					   intent.setData(Uri.parse("http://www.shengphoto.com"));
					   startActivity(intent);
					
					} catch (Exception e) {
					 Log.e("SampleApp", "Failed to invoke call", e);
					}

				
			}
		});
		textView1.setTextSize(12);
		
	//	textView1.setText("   确实了解圣瓦伦丁的人都知道，圣瓦伦丁全力打造了中国十大大奢华海景摄影基地，目前在中国确实无人可比。\n其囊括了：波多菲诺国际海景摄影基地，美丽的波多菲诺制造着意大利风潮，原版移植了意大利传世风情；热带雨林阳光海景摄影基地，以地中海拍摄风格为主；圣托里尼岛海景摄影基地，整个基地弥漫着希腊爱琴海白与蓝的浪漫色彩，彩绘出心目中圣托里尼最浪漫的婚纱生活；圣瓦伦丁国际帆船俱乐部摄影基地和游艇摄影会所，这两处基地目前在中国是拍摄高端婚纱摄影首选的地方，目前拥有三艘豪华大帆船和两艘奢华游艇，专供圣瓦伦丁新人出海游玩和拍摄高端婚纱照；以及三亚国际公馆五星级海景摄影基地圣瓦伦丁六大海景摄影基地以绝对海拔高度傲视全国婚纱摄影基地在中国影楼界，圣瓦伦丁无论是规模和实力都创下中国婚纱界先河。");
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}
	
	public void GongsijieshaoNetWork(){
		new Thread(){
			public void run(){
				String PATHS = Contant1.jsonUrlString;
				String jsonString1 = HttpUtils.getJsonContent(PATHS);
			//	JsonApplication ja=(JsonApplication)getApplication();
			//	String jsonString1=ja.getJsonString();
				String jiejshao=JsonUtils.getJianjieItem("about", jsonString1);
				Message message=Message.obtain();
				message.obj=jiejshao;
				handler.sendMessage(message);
			}
			
		}.start();
	}
	
	private Handler handler=new Handler(){

		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			textView1=(TextView)findViewById(R.id.gongsijieshao_textView1);
			textView1.setText(msg.obj.toString());
			textView1.setTextSize(12);
			
		}
		
	};
	

}
