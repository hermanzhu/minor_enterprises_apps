package com.fss.qdnewsproject1.additional;

import com.fss.qdnewsproject1.R;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class ZaixianDingcan extends Activity{
	
	private Button backButton;
	private Button sendButton;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.add_zaixiandingcan);
		backButton=(Button)findViewById(R.id.zaixian_back);
		sendButton=(Button)findViewById(R.id.zaixian_send);
		backButton.setOnClickListener(new OnClickListener() {
		
			@Override
			public void onClick(View paramView) {
				ZaixianDingcan.this.finish();
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
		return super.onCreateOptionsMenu(menu);
	}

}
