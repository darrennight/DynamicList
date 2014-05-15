package com.dk.view.effect;

import android.graphics.Matrix;

public abstract class EffectBase {
    public abstract Matrix getMatrix(Matrix matrix, int w, int h, int top);

}
