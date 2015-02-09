package com.frame.saeasyandroids.manager;

import java.util.Observable;
import java.util.Observer;

import org.apache.commons.lang3.StringUtils;

import android.app.Activity;

import com.frame.saeasyandroids.biz.Constant;

public class TopManager implements Observer {

	protected static final String TAG = "TopManager";
	private static TopManager manager = new TopManager();

	/**
	 * 将构造方法私有化起来!
	 */
	private TopManager() {
	}

	/**
	 * 向外提供的获取对象的方法
	 * 
	 * @return
	 */
	public static TopManager getInstance() {
		return manager;
	}

	public void init(Activity activity) {
		setListener(activity);
	}

	/**
	 * 设置标题中控件的点击事件
	 * 
	 * @param activity
	 */
	private void setListener(final Activity activity) {

	}

	/**
	 * 隐藏所有的标题
	 */
	private void initTitle() {
	}

	/**
	 * 显示通用的标题
	 */
	public void showCommonTitle() {
		initTitle();
		
	}

	/**
	 * 显示未登录的标题
	 */
	public void showUnLoginTitle() {
		initTitle();
		
	}

	/**
	 * 显示已经登陆的标题
	 */
	public void showLoginTitle(String userInfo) {
		initTitle();

	}

	/**
	 * 设置标题
	 * 
	 * @param resId
	 */
	public void setTopTitle(int resId) {

	}

	public void setTopTitle(String title) {

	}

	/**
	 * 接收到信息更改的信号之后进行界面的更改！
	 */
	@Override
	public void update(Observable observable, Object data) {
		/**
		 * 判断不为空才去执行，为了避免空指针异常！ 判断是否是由全部数字组成的String类型!
		 */
		if (data != null && StringUtils.isNumeric(data.toString())) {
			int id = Integer.parseInt(data.toString());

			switch (id) {
			// 界面大厅的界面
			case Constant.VIEW_HALL:

				break;
			}
		}

	}

}
