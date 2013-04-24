package com.fss.qdnewsproject1;

import android.app.FragmentTransaction;
import android.os.Bundle;

import android.view.Menu;
import android.view.MenuItem;

import com.fss.qdnewsproject1.fragment.ContentFragment;
import com.fss.qdnewsproject1.fragment.MenuFragment;
import com.slidingmenu.lib.SlidingMenu;
import com.slidingmenu.lib.app.SlidingActivity;

public class MainActivity2 extends SlidingActivity{

	@Override
	public void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.frame_content);
		setBehindContentView(R.layout.frame_menu);
		
	//	setSecondaryMenu
		 
        SlidingMenu sm = getSlidingMenu();
        sm.setShadowWidth(50);
        sm.setShadowDrawable(R.drawable.shadow);
        sm.setBehindOffset(60);
        sm.setFadeDegree(0.35f);
        sm.setMode(SlidingMenu.LEFT_RIGHT);
      //  sm.set
      
        sm.setSecondaryMenu(R.layout.test1);
        sm.setSecondaryShadowDrawable(R.drawable.shadow);
        
    //    sm.setMenu(R.layout.frame_menu);
       // sm.setLeft(R.layout.frame_menu);
        //设置slding menu的几种手势模式
        //TOUCHMODE_FULLSCREEN 全屏模式，在content页面中，滑动，可以打开sliding menu
        //TOUCHMODE_MARGIN 边缘模式，在content页面中，如果想打开slding ,你需要在屏幕边缘滑动才可以打开slding menu
        //TOUCHMODE_NONE 自然是不能通过手势打开啦
        sm.setTouchModeAbove(SlidingMenu.TOUCHMODE_FULLSCREEN);
		
//		FragmentTransaction fragmentTransaction=getFragmentManager().beginTransaction();
//		MenuFragment menuFragment = new MenuFragment();
//      //  fragmentTransaction.replace(R.id.menu, menuFragment);
//        fragmentTransaction.replace(R.id.content, new ContentFragment("Welcome"),"Welcome");
//        fragmentTransaction.commit();
//       
//    //    getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// TODO Auto-generated method stub
		
		switch (item.getItemId()) {
        case android.R.id.home:
            //toggle就是程序自动判断是打开还是关闭
            toggle();
//          getSlidingMenu().showMenu();// show menu
//          getSlidingMenu().showContent();//show content
            return true;
        }
		return super.onOptionsItemSelected(item);
	}

}
