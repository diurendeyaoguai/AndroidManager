package com.frame.saeasyandroids.view;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.RelativeLayout;

/**
 * View的基类(相似内容的集合)，对于里面的很多操作例如：View.OnClickListener()主要是为了后续的好处：针对继承的类可以直接的调用
 */
public abstract class BaseView implements View.OnClickListener {
	protected Context context;
	protected Bundle bundle;
	protected View view;//具体的内容（真实的view）/最外层还有一个容器：RelativeLayout；这个实例是子类实现的！
	protected static Handler handler;
	protected LayoutInflater inflater;

	public static void setHandler(Handler handler) {
		BaseView.handler = handler;
	}

	public BaseView(Context context, Bundle bundle) {
		this.bundle = bundle;
		this.context = context;
		inflater = LayoutInflater.from(context);
		init();
		setListener();
	}

	@Override
	public void onClick(View v) {

	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	/**
	 * 获取当前界面的View对象
	 * @return
	 */
	public View getView() {
		if (view.getLayoutParams() == null) {
			view.setLayoutParams(new RelativeLayout.LayoutParams(
					LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT));
		}
		return view;
	}

	protected View findViewById(int id) {
		return view.findViewById(id);
	}

	public abstract void init();

	public abstract void setListener();

	/**
	 * 当前容器的唯一标示，根据这个唯一的 标示可以用来进行bottom以及Top的切换
	 */
	public abstract int getId();

	/**
	 * 这两个方法的作用是：对于耗电之类的注册操作在onResume()方法中去操作，对于反注册之类的操作是在哪onPause()中！
	 */
	public void onResume() {

	}

	public void onPause() {

	}
}
