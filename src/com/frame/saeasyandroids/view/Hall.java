package com.frame.saeasyandroids.view;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.frame.saeasyandroids.R;
import com.frame.saeasyandroids.manager.UIManager;

/**
 * 主界面
 * @author zhangshun
 *
 */
public class Hall extends BaseView {
	private Button button;
	
	public Hall(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public void init() {
		view = (LinearLayout) inflater.inflate(R.layout.main, null);
		button = (Button) findViewById(R.id.main_bt);
	}
	@Override
	public void setListener() {
		button.setOnClickListener(this);
	}

	@Override
	public int getId() {
		return 0;
	}

	@Override
	public void onClick(View v) {
		super.onClick(v);
		switch (v.getId()) {
		case R.id.main_bt:
			UIManager.getInstance().changeView(LoadImageView.class, null);
			break;

		default:
			break;
		}
		
	}
	
}
