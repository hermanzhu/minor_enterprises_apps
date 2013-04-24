package com.fss.qdnewsproject1;

import com.actionbarsherlock.app.SherlockActivity;
import com.actionbarsherlock.view.Menu;
import com.actionbarsherlock.view.MenuItem;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivity;

import android.os.Bundle;
import android.widget.Toast;
import android.app.Activity;


public class MainActivity extends SherlockActivity {

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
		
		SlidingMenu sm1= new SlidingMenu(this);
		sm1.attachToActivity(this, SlidingMenu.SLIDING_CONTENT);
		sm1.setMode(SlidingMenu.RIGHT_OF);
		sm1.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		sm1.setFadeDegree(0.15f);
		sm1.setMenu(R.layout.test2);
		sm1.setShadowWidthRes(R.dimen.shadow_width);
		sm1.setShadowDrawable(R.drawable.shadow);
		sm1.setBehindOffsetRes(R.dimen.slidingmenu_offset);
		//getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		
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
		menu.add("Save")
        .setIcon(R.drawable.test1)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

    menu.add("Search")
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

    menu.add("Refresh")
        .setIcon(R.drawable.ic_launcher)
        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
		 getSupportMenuInflater().inflate(R.menu.main, menu);  
	     
		return super.onCreateOptionsMenu(menu);
	}

}
