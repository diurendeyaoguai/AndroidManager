package com.frame.saeasyandroids;

import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.RelativeLayout;

import com.frame.saeasyandroids.base.BaseActivity;
import com.frame.saeasyandroids.manager.BottomManager;
import com.frame.saeasyandroids.manager.PromptManager;
import com.frame.saeasyandroids.manager.PromptManager.dialogListener;
import com.frame.saeasyandroids.manager.TopManager;
import com.frame.saeasyandroids.manager.UIManager;
import com.frame.saeasyandroids.view.Hall;

/**
 * 框架展示的主界面
 * 
 * @author zhangshun
 * 
 */
public class MainActivity extends BaseActivity {
	private RelativeLayout middleContainer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		menu.add("");
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onMenuOpened(int featureId, Menu menu) {
		PromptManager.showMenu(this, "确定退出程序？", new dialogListener() {

			@Override
			public void clickBut(boolean isOk) {
				if (isOk) {
					// 点击确定将程序退出
					finish();
				} else {

				}
			}
		});
		// 将系统的菜单取消掉！
		return false;
	}

	@Override
	public void onBackPressed() {
		boolean result = UIManager.getInstance().goBack();

		if (!result) {
			PromptManager.showDialog(this, "确认要退出？", new dialogListener() {

				@Override
				public void clickBut(boolean isOk) {
					if (isOk) {
						MainActivity.this.finish();
					} else {

					}
				}
			});
		}
	}

	@Override
	public void onClick(View v) {

	}

	@Override
	protected int showLayoutView() {
		return R.layout.il_main;
	}

	/**
	 * 下面是一个Activity框架的核心
	 */
	@Override
	protected void setUpView() {
		middleContainer = getViewById(R.id.ii_main_middle);
		/**
		 * 下一行代码是将Activity中的Middle容器（其实就是一个RelativeLayout）
		 * 与UiManager中的容器关联起来，与BaseView中的Handler是一样的！
		 */
		UIManager.getInstance().setMiddleContainer(middleContainer);
		TopManager.getInstance().init(this);
		BottomManager.getInstance().init(this);
		/**
		 * 这里是使用观察者模式 addObserver()这个方法是继承来的！
		 */
		UIManager.getInstance().addObserver(TopManager.getInstance());
		UIManager.getInstance().addObserver(BottomManager.getInstance());
		UIManager.getInstance().changeView(Hall.class, null);
		/**
		 * 开始进行界面（Top/Bottom）的显示切换设置！
		 */
		TopManager.getInstance().showCommonTitle();
		BottomManager.getInstance().showCommonBottom();
	}

	@Override
	protected void fillData() {

	}

	@Override
	protected void setListener() {

	}
}
