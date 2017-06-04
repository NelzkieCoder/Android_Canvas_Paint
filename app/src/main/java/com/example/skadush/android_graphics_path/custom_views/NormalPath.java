package com.example.skadush.android_graphics_path.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by skadush on 4/06/17.
 */

public class NormalPath extends View {
    Paint paint;
    Path path;

    public NormalPath(Context context) {
        super(context);
        init();
    }

//    public NormalPath(Context context, @Nullable AttributeSet attrs) {
//        super(context, attrs);
//        init();
//    }
//
//    public NormalPath(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
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
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path,paint);
    }
}
