package com.dk.view;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.dk.view.effect.EffectHelper;
import com.dk.view.effect.EffectScale;
import com.dk.view.effect.EffectScaleCenter;
import com.dk.view.effect.EffectTranslate;
import com.dk.view.effect.EffectTwister;

public class MainActivity extends Activity {
    private ListView mList;
    private FoldingListAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mList = (ListView) findViewById(R.id.list);
        mAdapter = new FoldingListAdapter(this);
        mAdapter.setEffect(new EffectTranslate());
        mList.setAdapter(mAdapter);
        new EffectHelper().init(mList);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
        case R.id.action_scale:
            mAdapter.setEffect(new EffectScale());
            break;

        case R.id.action_twister:
            mAdapter.setEffect(new EffectTwister());
            break;
        case R.id.action_translate:
            mAdapter.setEffect(new EffectTranslate());
            break;
        case R.id.action_scale_center:
            mAdapter.setEffect(new EffectScaleCenter(mList.getHeight()));
            break;

        }
        return super.onOptionsItemSelected(item);
    }

}
