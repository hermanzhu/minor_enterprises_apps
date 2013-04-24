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
        //����slding menu�ļ�������ģʽ
        //TOUCHMODE_FULLSCREEN ȫ��ģʽ����contentҳ���У����������Դ�sliding menu
        //TOUCHMODE_MARGIN ��Եģʽ����contentҳ���У�������slding ,����Ҫ����Ļ��Ե�����ſ��Դ�slding menu
        //TOUCHMODE_NONE ��Ȼ�ǲ���ͨ�����ƴ���
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
            //toggle���ǳ����Զ��ж��Ǵ򿪻��ǹر�
            toggle();
//          getSlidingMenu().showMenu();// show menu
//          getSlidingMenu().showContent();//show content
            return true;
        }
		return super.onOptionsItemSelected(item);
	}

}
