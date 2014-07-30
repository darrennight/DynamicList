package com.dk.view.effect;

import android.graphics.Matrix;

public class EffectScaleCenter extends EffectBase {
    private int mHeight;

    public EffectScaleCenter(int height) {
        mHeight = height;
    }

    private static final int NUM_OF_POLY_POINTS = 8;

    @Override
    public synchronized Matrix getMatrix(Matrix matrix, int w, int h, int top) {
        float[] mSrc = new float[NUM_OF_POLY_POINTS];
        float[] mDst = new float[NUM_OF_POLY_POINTS];

        mSrc[0] = 0;
        mSrc[1] = 0;
        mSrc[2] = 0;
        mSrc[3] = h;
        mSrc[4] = w;
        mSrc[5] = 0;
        mSrc[6] = w;
        mSrc[7] = h;
        float factor = calculateFactor(top);
        mDst[0] = factor * 0.25f * w;
        mDst[1] = factor * 0.25f * h;
        mDst[2] = factor * 0.25f * w;
        mDst[3] = (1 - factor * 0.25f) * h;
        mDst[4] = (1 - factor * 0.25f) * w;
        mDst[5] = factor * 0.25f * h;
        mDst[6] = (1 - factor * 0.25f) * w;
        mDst[7] = (1 - factor * 0.25f) * h;
        if (w == 0 || h == 0) {

        } else {
            matrix.setPolyToPoly(mSrc, 0, mDst, 0, NUM_OF_POLY_POINTS / 2);
        }
        return matrix;
    }

    private synchronized float calculateFactor(int top) {
        int abs = Math.abs(top - mHeight/2);
        return abs / (mHeight / 2.0f);
    }
}
