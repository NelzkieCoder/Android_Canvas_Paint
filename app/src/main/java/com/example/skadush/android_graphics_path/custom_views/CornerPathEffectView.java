package com.example.skadush.android_graphics_path.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.CornerPathEffect;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;

/**
 * Created by skadush on 4/06/17.
 */

public class CornerPathEffectView extends View {

    Paint paint;
    Path path;
    public CornerPathEffectView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(10);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();
        path.moveTo(50, 50);
        path.lineTo(50, 500);
        path.lineTo(200, 500);
        path.lineTo(200, 300);
        path.lineTo(350, 300);

        float radius = 50.0f;

        CornerPathEffect cornerPathEffect =
                new CornerPathEffect(radius);

        paint.setPathEffect(cornerPathEffect);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);

    }
}
