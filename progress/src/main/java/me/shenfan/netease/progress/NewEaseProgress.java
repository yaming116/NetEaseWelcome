package me.shenfan.netease.progress;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Sun on 2016/6/17.
 */
public class NewEaseProgress extends View {

    private Paint mCirclePaint;

    private float mRadius;
    private float mStrokeWidth;


    private float mCenterX;
    private float mCenterY;
    private float mPaddingX;
    private float mPaddingY;


    private RectF mCircleBounds;

    public NewEaseProgress(Context context) {
        this(context, null);
    }

    public NewEaseProgress(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public NewEaseProgress(Context context, AttributeSet attrs, int defStyleAttr) {
        this(context, attrs, defStyleAttr, 0);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public NewEaseProgress(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        init(context, attrs);
    }


    private void init(Context context, AttributeSet attrs){
        mCirclePaint = new Paint();
        mCirclePaint.setFlags(Paint.ANTI_ALIAS_FLAG);
        mCirclePaint.setStyle(Paint.Style.STROKE);
        mCirclePaint.setColor(Color.RED);
        mCirclePaint.setStrokeWidth(2);
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        mCenterX = w / 2f;
        mCenterY = h / 2f;
        mPaddingX = w / 2f - mRadius;
        mPaddingY = h / 2f - mRadius;

        mCircleBounds = new RectF();
        mCircleBounds.top = mPaddingY;
        mCircleBounds.left = mPaddingX;
        mCircleBounds.bottom = h / 2f + mRadius;
        mCircleBounds.right = w / 2f + mRadius;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(mCircleBounds.centerX(), mCircleBounds.centerY(), 30, mCirclePaint);
    }
}
