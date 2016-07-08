package me.shenfan.neteasewelcome;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sun on 2016/6/20.
 */
public class ProportionHelper {

    private int ww;
    private int hw;

    public ProportionHelper(Context context, AttributeSet attrs){
        TypedArray ta = context.obtainStyledAttributes(attrs,
                R.styleable.ProportionView);
        ww = ta.getInteger(R.styleable.ProportionView_widthWeight,  1);
        hw = ta.getInteger(R.styleable.ProportionView_heightWeight, 1);
        ta.recycle();
    }


    public int[] onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int widthMode = View.MeasureSpec.getMode(widthMeasureSpec);
        int heightMode = View.MeasureSpec.getMode(heightMeasureSpec);
        if (widthMode == View.MeasureSpec.EXACTLY
                && heightMode != View.MeasureSpec.EXACTLY) {
            int width = View.MeasureSpec.getSize(widthMeasureSpec);
            int height = width;
            if (heightMode == View.MeasureSpec.AT_MOST) {
                height = Math.min(height,
                        View.MeasureSpec.getSize(heightMeasureSpec));
            }

            return new int[]{width, (width * hw) / ww};
        }

        return null;
    }

    public void setHeightWeight(int heightWeight){
        this.hw = heightWeight;
    }

    public void setWidthWeight(int widthWeight){
        this.ww = widthWeight;
    }

    public int getHeightWeigh() {
        return hw;
    }

    public int getWidthWeight() {
        return ww;
    }
}
