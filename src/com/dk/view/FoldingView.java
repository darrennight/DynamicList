package com.dk.view;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.dk.view.effect.EffectBase;

public class FoldingView extends LinearLayout {
    private EffectBase mEffect;

    public void setEffect(EffectBase mEffect) {
        this.mEffect = mEffect;
    }

    public FoldingView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void dispatchDraw(Canvas canvas) {
        canvas.save();
        canvas.concat(mEffect.getMatrix(canvas.getMatrix(), getWidth(), getHeight(), getTop()));
        super.dispatchDraw(canvas);
        canvas.restore();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }
}
