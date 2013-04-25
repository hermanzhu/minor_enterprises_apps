package com.fss.qdnewsproject1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ImageView.ScaleType;

import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.fss.qdnewsproject1.fragment.LeftMenuFragment;
import com.fss.qdnewsproject1.fragment.RightMenuFragment;
import com.fss.qdnewsproject1.utils.BitmapUtils;
import com.fss.qdnewsproject1.utils.JsonApplication;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingFragmentActivity;

public class MainActivity3 extends SlidingFragmentActivity implements OnClickListener{

	public MainActivity3() {
		super();
	
		// TODO Auto-generated constructor stub
	}
	
	private ImageView iv1;
	private Bitmap bm1;// 图片资源Bitmap
	private Bitmap bm2;
	private float scaleW = 1;// 横向缩放系数，1表示不变
	private float scaleH = 1;// 纵向缩放系数，1表示不变

	private float curDegrees = 0;// 当前旋转度数
	private ImageView iv2;
	private TextView tv1;
	private TextView tv2;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		getSlidingMenu().setMode(SlidingMenu.LEFT_RIGHT);
		getSlidingMenu().setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
		setContentView(R.layout.index_of_shengwalunding);
		setBehindContentView(R.layout.frame_menu);
		
		FragmentTransaction ft=getSupportFragmentManager().beginTransaction();
		LeftMenuFragment leftMenuFragment=new LeftMenuFragment();
		ft.replace(R.id.left_menu, leftMenuFragment);
		ft.commit();
		
		getSlidingMenu().setSecondaryMenu(R.layout.frame_menu1);
		RightMenuFragment rightMenuFragment=new RightMenuFragment();
		ft=getSupportFragmentManager().beginTransaction();
		ft.replace(R.id.right_menu, rightMenuFragment);
		ft.commit();
		getSlidingMenu().setShadowWidth(50);
		getSlidingMenu().setBehindOffset(60);
		getSlidingMenu().setShadowDrawable(R.drawable.shadow);
		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadow);
	//	getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	//	getSupportActionBar().setTitle("圣瓦伦丁");
	//	getSupportActionBar().setDisplayUseLogoEnabled(false);
	//	getSupportActionBar().setIcon(R.drawable.liebiaob2x);
	//	getSupportActionBar().setDisplayShowCustomEnabled(true);
	//	getSupportActionBar().setCustomView(R.layout.add_zaixiandingcan);
	//	getSupportActionBar().setSplitBackgroundDrawable(d)
		//getSupportActionBar().setBackgroundDrawable(R.drawable.toutu);
		//获取参数信息
		Button listButton=(Button)findViewById(R.id.indexListButton);
		listButton.setOnClickListener(this);
		Button rightButton=(Button)findViewById(R.id.indexRightButton);
		rightButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				getSlidingMenu().showSecondaryMenu(false);
				
			}
		});
		iv1=(ImageView)findViewById(R.id.indexImageView1);
		//BitmapFactory bf=new BitmapFactory();
		bm1=BitmapFactory.decodeResource(getResources(), R.drawable.swld_pic1);
		bm2=BitmapFactory.decodeResource(getResources(), R.drawable.swld_pic2jpg);
		iv2=(ImageView)findViewById(R.id.indexImageView2);
		tv1=(TextView)findViewById(R.id.indexTextView1);
		tv2=(TextView)findViewById(R.id.indexTextView2);
		
		
		 
		 
		 DisplayMetrics dm=new DisplayMetrics();
		 getWindowManager().getDefaultDisplay().getMetrics(dm);
		 int screenWidth=dm.widthPixels;
		 int screenHeight=dm.heightPixels;
		 Log.d("screenWidth", String.valueOf(screenWidth));
		 Log.d("screenHeight", String.valueOf(screenHeight));
		 Bitmap newbm1=null;
		 BitmapDrawable bd1=null;
		 newbm1=BitmapUtils.BitmapFullWidthChange(screenWidth, screenHeight, bm1.getWidth(), bm1.getHeight(), 40,bm1);
		 bd1=BitmapUtils.BitmapFullWidthChangeDrawable(screenWidth, screenHeight, bm1.getWidth(), bm1.getHeight(), 30,bm1);
		// getSupportActionBar().setBackgroundDrawable(bd1);
		 //	 iv.setImageDrawable(bd);
		 iv1.setImageBitmap(newbm1);
		 iv1.setScaleType(ScaleType.CENTER);
		 Bitmap newbm2=null;
		 BitmapDrawable bd2=null;
		 newbm2=BitmapUtils.BitmapFullWidthChange(screenWidth, screenHeight, bm2.getWidth(), bm2.getHeight(), 40,bm2);
		 iv2.setImageBitmap(newbm2);
		 iv2.setScaleType(ScaleType.CENTER);
		 tv1.setText("圣瓦伦丁一起去三亚了！");
		 tv1.setTextSize(16);
			
//		getSupportFragmentManager()
//		.beginTransaction()
//		.replace(R.id.frame_content, new SampleListFragment())
//		.commit();
//		
//		getSlidingMenu().setSecondaryMenu(R.layout.menu_frame_two);
//		getSlidingMenu().setSecondaryShadowDrawable(R.drawable.shadowright);
//		getSupportFragmentManager()
//		.beginTransaction()
//		.replace(R.id.menu_frame_two, new SampleListFragment())
//		.commit();
	
	}
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			toggle();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getSupportMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		 toggle();
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
