package me.shenfan.neteasewelcome;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.util.AttributeSet;
import android.widget.FrameLayout;

/**
 * Created by Sun on 2016/6/20.
 */
public class ProportionFrameLayout extends FrameLayout {

    private ProportionHelper helper;

    public ProportionFrameLayout(Context context) {
        this(context, null);
    }

    public ProportionFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public ProportionFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public ProportionFrameLayout(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs){
        helper = new ProportionHelper(context, attrs);
    }


    public void setHeightWeight(int heightWeight){
        helper.setHeightWeight(heightWeight);
    }

    public void setWidthWeight(int widthWeight){
        helper.setHeightWeight(widthWeight);
    }

    public int getHeightWeigh() {
        return helper.getHeightWeigh();
    }

    public int getWidthWeight() {
        return helper.getWidthWeight();
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int[] size = helper.onMeasure(widthMeasureSpec, heightMeasureSpec);
        if (size != null){
            setMeasuredDimension(size[0], size[1]);
        }
    }
}
