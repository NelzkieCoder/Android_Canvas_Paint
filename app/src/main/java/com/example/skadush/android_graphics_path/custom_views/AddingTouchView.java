package com.example.skadush.android_graphics_path.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by skadush on 4/06/17.
 */

public class AddingTouchView extends View {

    int paintColor = Color.BLACK;
    Paint drawPaint;
    List<Point> circlePoints;

    public AddingTouchView(Context context) {
        super(context);
        setupPaint();
        circlePoints = new ArrayList<>();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        circlePoints.add(new Point(Math.round(x), Math.round(y)));

        //indicate that the view should be redrawn
        postInvalidate();

        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (Point p : circlePoints) {
            canvas.drawCircle(p.x,p.y,5,drawPaint);
        }
    }

    private void setupPaint() {
        drawPaint = new Paint();
        drawPaint.setColor(paintColor);
        drawPaint.setAntiAlias(true);
        drawPaint.setStrokeWidth(5);
        drawPaint.setStyle(Paint.Style.STROKE);
        drawPaint.setStrokeJoin(Paint.Join.ROUND);
        drawPaint.setStrokeCap(Paint.Cap.ROUND);
    }
}
