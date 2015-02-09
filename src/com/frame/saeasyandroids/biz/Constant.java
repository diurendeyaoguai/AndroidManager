package com.frame.saeasyandroids.biz;

import android.os.Environment;

import com.frame.saeasyandroids.util.PackageUtils;

/**
 * 全局的常量设置
 * 
 * @author zhangshun
 * 
 */

public class Constant {

	/**
	 * 一个标示、 默认false,不退出软件 在MainActivity中进行判断，作用：安全退出app！
	 */
	public static boolean isBack = false;

	/**
	 * Hncj统一的SD路径；使用时在这个目录下创建文件夹；
	 */
	public static String App_Path = Environment.getExternalStorageDirectory()
			.getAbsolutePath()
			+ "/Android/data/"
			+ PackageUtils.getPackageName();

	/**
	 * 每一个View都有一个Id与之对应，作为它的唯一标示在更新Top与Bottom的时候用到！ 这里只是简单的示例，这个是没有实际用处的！
	 */
	public static final int VIEW_HALL = 0;

	/**
	 * LoadImageView界面
	 */
	public static final int VIEW_LOADIMAGE = 0;

}
