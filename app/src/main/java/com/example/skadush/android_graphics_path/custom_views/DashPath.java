package com.example.skadush.android_graphics_path.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.DashPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by skadush on 4/06/17.
 */

public class DashPath extends View {
    Paint paint;
    Path path;
    LinearLayoutCompat linearLayoutCompat;
    public DashPath(Context context) {
        super(context);
        init();
    }

//    public DashPath(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public DashPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//        init();
//    }


    void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.moveTo(20,20); // the starting point
        path.lineTo(50, 50);
        path.lineTo(200, 500);
        path.lineTo(200, 300);
        path.lineTo(350, 300);

        float[] intervals = new float[]{50.0f, 50.0f};
        float phase = 0;

        DashPathEffect dashPathEffect =
                new DashPathEffect(intervals, phase);

        paint.setPathEffect(dashPathEffect);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }
}
