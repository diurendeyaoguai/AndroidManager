package com.frame.saeasyandroids.manager;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Observable;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.frame.saeasyandroids.util.Utils;
import com.frame.saeasyandroids.view.BaseView;

/**
 * 界面中间部分的管理
 * 
 * @author zhangshun
 * 
 */
public class UIManager extends Observable {
	private RelativeLayout relativeLayout;
	private BaseView currentview;
	private Map<String, BaseView> cacheview = new HashMap<String, BaseView>();
	private LinkedList<String> histroy = new LinkedList<String>();
	private static UIManager uimanager = new UIManager();

	private UIManager() {
	}

	public static UIManager getInstance() {
		return uimanager;
	}

	public void setMiddleContainer(RelativeLayout relativeLayout) {
		this.relativeLayout = relativeLayout;
	}

	/**
	 * 切换界面的方法
	 * 
	 * @param clazz
	 *            BaseView子类的字节码,所以下面使用反射进行对象的创建！
	 * @param bundle
	 *            用于传递数据的Bundle
	 */
	public void changeView(Class<? extends BaseView> clazz, Bundle bundle) {
		if (currentview != null) {
			if (currentview.getClass() == clazz) {
				return;
			}
			currentview.onPause();
		}
		String key = clazz.getSimpleName();
		BaseView targetview = null;
		if (cacheview.containsKey(key)) {
			targetview = cacheview.get(key);
			targetview.setBundle(bundle);
		} else {
			try {
				Constructor<? extends BaseView> constructor = clazz
						.getConstructor(Context.class, Bundle.class);
				targetview = constructor.newInstance(getContext(), bundle);
				cacheview.put(key, targetview);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (targetview == null) {
			Utils.toastShow("目标界面生成出错！targetview为null");
			return;
		}
		View view = targetview.getView();
		// 移除所有view
		relativeLayout.removeAllViews();
		// 添加当前的view
		relativeLayout.addView(view);
		targetview.onResume();

		// 存储当前正在显示的界面
		currentview = targetview;
		// 当界面切换成功过
		histroy.addFirst(key);
	}

	/**
	 * 处理返回键
	 * 
	 * @return
	 */
	public boolean goBack() {
		// 移除栈顶
		if (histroy.size() != 0) {
			if (histroy.size() == 1) {
				// 当用户不想退出系统时，返回键集合被清空了，保留首页
				return false;
			}
			histroy.removeFirst();
			// 获取最新的栈顶元素
			String key = histroy.getFirst();

			BaseView targetView = cacheview.get(key);
			View view = targetView.getView();
			if (currentview != null) {
				currentview.onPause();

			}
			relativeLayout.removeAllViews();
			relativeLayout.addView(view);
			targetView.onResume();
			currentview = targetView;
			return true;

			// 展示最新的栈顶元素
		}
		return false;
	}

	/**
	 * 返回上下文
	 * 
	 * @return
	 */
	private Context getContext() {
		return this.relativeLayout.getContext();
	}

	/**
	 * 得到当前显示的View
	 * 
	 * @return
	 */
	public BaseView getCurrentview() {
		return currentview;
	}
}
