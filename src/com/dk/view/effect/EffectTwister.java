package com.dk.view.effect;

import android.graphics.Matrix;

public class EffectTwister extends EffectBase {

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

        mDst[0] = calculateFactor(top) * w;
        mDst[1] = 0;
        mDst[2] = calculateFactor(top) * w;
        mDst[3] = h;
        mDst[4] = (1 - calculateFactor(top)) * w;
        mDst[5] = 0;
        mDst[6] = (1 - calculateFactor(top)) * w;
        mDst[7] = h;
        if (w == 0 || h == 0) {

        } else {
            matrix.setPolyToPoly(mSrc, 0, mDst, 0, NUM_OF_POLY_POINTS / 2);
        }

        return matrix;
    }

    private synchronized static float calculateFactor(int top) {
        if (top > 200) {
            return 0;
        } else {
            if (top < 0) {
                return 1;
            } else {
                // when it is 0.5, matrix has no effect. (???)
                if (top == 100) {
                    return 0.501f;
                }
                return (200 - top) / 200f;

            }

        }
    }
}
