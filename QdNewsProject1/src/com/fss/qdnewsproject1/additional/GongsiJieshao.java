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
		
	//	textView1.setText("   ȷʵ�˽�ʥ���׶����˶�֪����ʥ���׶�ȫ���������й�ʮ����ݻ�������Ӱ���أ�Ŀǰ���й�ȷʵ���˿ɱȡ�\n�������ˣ������ŵ���ʺ�����Ӱ���أ������Ĳ����ŵ������������糱��ԭ����ֲ��������������飻�ȴ��������⺣����Ӱ���أ��Ե��к�������Ϊ����ʥ�����ᵺ������Ӱ���أ���������������ϣ�����ٺ�������������ɫ�ʣ��ʻ����Ŀ��ʥ�������������Ļ�ɴ���ʥ���׶����ʷ������ֲ���Ӱ���غ���ͧ��Ӱ����������������Ŀǰ���й�������߶˻�ɴ��Ӱ��ѡ�ĵط���Ŀǰӵ�����Һ����󷫴��������ݻ���ͧ��ר��ʥ���׶����˳������������߶˻�ɴ�գ��Լ����ǹ��ʹ������Ǽ�������Ӱ����ʥ���׶����󺣾���Ӱ�����Ծ��Ժ��θ߶Ȱ���ȫ����ɴ��Ӱ�������й�Ӱ¥�磬ʥ���׶������ǹ�ģ��ʵ���������й���ɴ���Ⱥӡ�");
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
