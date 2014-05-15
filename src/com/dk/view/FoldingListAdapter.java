package com.dk.view;

import com.dk.view.effect.EffectBase;
import com.dk.view.effect.EffectTwister;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView.LayoutParams;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class FoldingListAdapter extends BaseAdapter {
    private Context mContext;
    private EffectBase mEffect;
    
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
        FoldingView item = (FoldingView)LayoutInflater.from(mContext).inflate(R.layout.view_list_item, null);
        item.setEffect(mEffect);
//        TextView tv = (TextView)item.findViewById(R.id.text);
//        LayoutParams params = new LayoutParams(-1, 40);
//        item.setLayoutParams(params);
        if (position % 2 == 0) {
            item.setBackgroundColor(0xffdedede);
        } else {
            item.setBackgroundColor(0xfff0f0f0);
        }

        return item;
    }
}
