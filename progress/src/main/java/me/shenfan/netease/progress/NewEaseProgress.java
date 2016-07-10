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
        mCirclePaint.setStyle(Paint.Style.FILL);
        mCirclePaint.setColor(Color.RED);
        mCirclePaint.setStrokeWidth(2);
        mCirclePaint.setAntiAlias(true);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);

//         if (getMeasuredWidth() > getHeight()){
//             mWidth = getMeasuredHeight();
//         }else {
//             mWidth = getMeasuredWidth();
//         }
    }


    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);

        if (mCircleBounds == null){
            mCircleBounds = new RectF();
        }
        mCircleBounds.top = 4;
        mCircleBounds.left = 4;
        mCircleBounds.bottom = h - 4;
        mCircleBounds.right = w - 4;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        canvas.drawCircle(mCircleBounds.centerX(), mCircleBounds.centerY(),
//                mCircleBounds.width() / 2, mCirclePaint);

        canvas.drawArc(mCircleBounds, 0, 270, false, mCirclePaint);

//        canvas.drawt
    }
}
