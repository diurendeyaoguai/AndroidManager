package com.frame.saeasyandroids.view;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.frame.saeasyandroids.R;
import com.frame.saeasyandroids.adapters.EasyAdapter;
import com.frame.saeasyandroids.biz.Constant;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.ImageLoadingListener;
import com.nostra13.universalimageloader.core.assist.SimpleImageLoadingListener;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;
import com.nostra13.universalimageloader.core.display.RoundedBitmapDisplayer;

/**
 * 一个Demo。使用Universal_ImageLoader加载图片！
 * @author zhangshun
 *
 */
public class LoadImageView extends BaseView {

	private DisplayImageOptions options;
	private String[] array;
	private ImageLoader imageLoader;
	private ListView lv;
	private ImageLoadingListener animateFirstListener = new AnimateFirstDisplayListener();

	public LoadImageView(Context context, Bundle bundle) {
		super(context, bundle);
	}

	@Override
	public void init() {
		view = (LinearLayout) inflater.inflate(R.layout.image_loader, null);
		options = new DisplayImageOptions.Builder()
				.showStubImage(R.drawable.ic_launcher)
				.showImageForEmptyUri(R.drawable.ic_launcher)
				.showImageOnFail(R.drawable.ic_launcher).cacheInMemory(true)// 内存优化开启
				.cacheOnDisc(true).displayer(new RoundedBitmapDisplayer(20))// SD卡优化开启
				.build();
		lv = (ListView) findViewById(R.id.image_loader_lv);
		imageLoader = ImageLoader.getInstance();
		getUrlArray();
		List<String> list = Arrays.asList(array);
		EasyAdapter<String> adapter = new EasyAdapter<String>(list) {

			@Override
			protected View getViewItem(int position, View convertView,
					ViewGroup parent) {
				View view = null;
				if (convertView == null) {
					view = inflater.inflate(R.layout.image_loader_item, null);
					convertView = view;
				} else {
					view = convertView;
				}
				ImageView iv = (ImageView) view
						.findViewById(R.id.image_loader_item_iv);
				TextView tv = (TextView) view
						.findViewById(R.id.image_loader_item_tv);
				tv.setText("这是第" + (position + 1) + "张图片！");
				imageLoader.displayImage(array[position], iv, options,
						animateFirstListener);
				return view;
			}
		};
		lv.setAdapter(adapter);
	}

	@Override
	public void setListener() {

	}

	private static class AnimateFirstDisplayListener extends
			SimpleImageLoadingListener {

		static final List<String> displayedImages = Collections
				.synchronizedList(new LinkedList<String>());

		@Override
		public void onLoadingComplete(String imageUri, View view,
				Bitmap loadedImage) {
			if (loadedImage != null) {
				ImageView imageView = (ImageView) view;
				boolean firstDisplay = !displayedImages.contains(imageUri);
				if (firstDisplay) {
					FadeInBitmapDisplayer.animate(imageView, 500);
					displayedImages.add(imageUri);
				}
			}
		}
	}

	/**
	 * 将内存缓存清理！
	 */
	public void onPause() {
		imageLoader.clearMemoryCache();
	}
	
	@Override
	public int getId() {
		return Constant.VIEW_LOADIMAGE;
	}

	public void getUrlArray() {
		String first = "http://res.azrj.cn/cook/201205";
		String end = ".jpg";

		String mid1 = "/20120514/14160729_Q8HUP";
		String mid2 = "/20120514/14160016_AZSgb";
		String mid3 = "/20120514/14115524_oIOon";
		String mid4 = "/20120514/14115029_XGEZX";
		String mid5 = "/20120511/11151959_j7LY4";
		String mid6 = "/20120511/11111837_w8u0R";
		String mid7 = "/20120511/11111550_gl78N";
		String mid8 = "/20120511/11110956_kgJEU";
		String mid9 = "/20120508/08170359_XHmDJ";
		String mid10 = "/20120508/08165805_jvRGQ";

		String url1 = first + mid1 + end;
		String url2 = first + mid2 + end;
		String url3 = first + mid3 + end;
		String url4 = first + mid4 + end;
		String url5 = first + mid5 + end;
		String url6 = first + mid6 + end;
		String url7 = first + mid7 + end;
		String url8 = first + mid8 + end;
		String url9 = first + mid9 + end;
		String url10 = first + mid10 + end;

		array = new String[] { url1, url2, url3, url4, url5, url6, url7, url8,
				url9, url10, url1, url2, url3, url4, url5, url6, url7, url8,
				url9, url10 };
	}
}
