package com.fss.qdnewsproject1;

import com.slidingmenu.lib.SlidingMenu;

import android.app.Activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;




public class MainActivity1 extends FragmentActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		SlidingMenu sm= new SlidingMenu(this);
		sm.attachToActivity(this, SlidingMenu.SLIDING_WINDOW);
		sm.setMode(SlidingMenu.LEFT_OF);
		sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_MARGIN);
		sm.setFadeDegree(0.35f);
		sm.setMenu(R.layout.left_menu);
		sm.setShadowWidthRes(R.dimen.shadow_width);
		sm.setShadowDrawable(R.drawable.shadow);
		sm.setBehindOffsetRes(R.dimen.slidingmenu_offset);
	//	sm.setle
		//FragmentTransaction ft=this.getFragmentManager().beginTransaction();
	//	FragmentTransaction t = this.getSupportFragmentManager().beginTransaction();
	//	LeftMenuListFragment lmf=new LeftMenuListFragment();
	//	t.replace(R.layout.left_menu, lmf);
	//	t.commit();
		//Right Side of Activity
	/*	
		SlidingMenu sm1= new SlidingMenu(this);
		sm1.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		sm1.setMode(SlidingMenu.RIGHT_OF);
		sm1.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm1.setFadeDegree(0.15f);
		sm1.setMenu(R.layout.test2);
		sm1.setShadowWidthRes(R.dimen.shadow_width);
		sm1.setShadowDrawable(R.drawable.shadow);
		sm1.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);*/
		
	}
	 @Override  
	    public boolean onOptionsItemSelected(MenuItem item) {  
	        switch(item.getItemId()){  
	        case R.id.menu_delete:  
	            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();  
	            break;  
	        case R.id.homeAsUp:
				Toast.makeText(this, "Home!", Toast.LENGTH_LONG).show();
				break;
	  
	        }  
	        return super.onOptionsItemSelected(item);  
	    }  

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.main, menu);
		//boolean isLight = QdNe.THEME == R.style.Theme_Sherlock_Light;
	

   
	     
		return super.onCreateOptionsMenu(menu);
	}

}
