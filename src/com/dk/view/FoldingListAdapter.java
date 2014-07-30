package com.dk.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.dk.view.effect.EffectBase;

public class FoldingListAdapter extends BaseAdapter {
	private Context mContext;
	private EffectBase mEffect;
	private int[] images = new int[] { R.drawable.p1, R.drawable.p2,
			R.drawable.p3 };

	FoldingListAdapter(Context context) {
		mContext = context;
	}

	public void setEffect(EffectBase effect) {
		mEffect = effect;
	}

	@Override
	public int getCount() {
		return 2000;
	}

	@Override
	public Object getItem(int position) {
		return null;
	}

	@Override
	public long getItemId(int position) {
		return 0;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		FoldingView item = (FoldingView) LayoutInflater.from(mContext).inflate(
				R.layout.view_list_item, null);

		item.setEffect(mEffect);
		ImageView image = (ImageView) item.findViewById(R.id.image);
		image.setImageResource(images[position % images.length]);
		if (position % 2 == 0) {
			item.setBackgroundColor(0xffdedede);
		} else {
			item.setBackgroundColor(0xfff0f0f0);
		}

		return item;
	}
}
