package com.dk.view.effect;

import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.ListView;

public class EffectHelper {

    public void init(final ListView list) {
        list.setOnScrollListener(new OnScrollListener() {

            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                for (int i = 0; i < list.getChildCount(); i++) {
                    list.getChildAt(i).invalidate();
                }
            }
        });
    }
}
