package com.frame.saeasyandroids.manager;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang3.StringUtils;

import com.frame.saeasyandroids.R;

import android.app.Activity;
import android.view.View;
import android.widget.RelativeLayout;

public class BottomManager implements Observer {
	protected static final String TAG = "BottomManager1";
	/******************* 第一步：管理对象的创建单例模式) ***************************************************/
	// 创建实例对象
	private static BottomManager inmanager;

	// 构造方法私有化
	private BottomManager() {
	}

	// 提供统一的对外获取实例的入口
	public static BottomManager getInstance() {
		if (inmanager == null) {
			inmanager = new BottomManager();
		}
		return inmanager;
	}

	/********** 底部菜单容器 **********/
	private RelativeLayout bottomMenuContainer;

	public void init(Activity activity) {
		bottomMenuContainer = (RelativeLayout) activity
				.findViewById(R.id.ii_main_bottom);
		setListener(activity);
	}

	/**
	 * 设置监听
	 */
	private void setListener(Activity activity) {
		
	}

	/****************** 第三步：控制各个导航容器的显示和隐藏 *****************************************/
	public void showCommonBottom() {
		if (bottomMenuContainer.getVisibility() == View.GONE
				|| bottomMenuContainer.getVisibility() == View.INVISIBLE) {
			bottomMenuContainer.setVisibility(View.VISIBLE);
		}
		//代码设置具体的显示与隐藏
	}

	public void showGameBottom() {
		if (bottomMenuContainer.getVisibility() == View.GONE
				|| bottomMenuContainer.getVisibility() == View.INVISIBLE) {
			bottomMenuContainer.setVisibility(View.VISIBLE);
		}
		//代码设置具体的显示与隐藏
	}

	/**
	 * 改变底部导航容器显示情况
	 */
	public void changeBottomVisiblity(int type) {
		if (bottomMenuContainer.getVisibility() != type)
			bottomMenuContainer.setVisibility(type);
		//代码设置具体的显示与隐藏
	}

	@Override
	public void update(Observable observable, Object data) {
		if (data != null && StringUtils.isNumeric(data.toString())) {
			int id = Integer.parseInt(data.toString());

			switch (id) {
			default:
				break;
			}
		}
	}

}
