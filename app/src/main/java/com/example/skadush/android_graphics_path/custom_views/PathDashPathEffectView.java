package com.example.skadush.android_graphics_path.custom_views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathDashPathEffect;
import android.view.View;

/**
 * Created by skadush on 4/06/17.
 */

public class PathDashPathEffectView extends View{
    Paint paint;
    Path path;

    public PathDashPathEffectView(Context context) {
        super(context);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(20);
        paint.setStyle(Paint.Style.STROKE);

        path = new Path();

        Path pathShape = new Path();
        pathShape.addCircle(10, 10, 10, Path.Direction.CCW);

        float advance = 30.0f;
        float phase = 20.0f;
        PathDashPathEffect.Style style = PathDashPathEffect.Style.ROTATE;

        PathDashPathEffect pathDashPathEffect =
                new PathDashPathEffect(pathShape, advance, phase, style);

        paint.setPathEffect(pathDashPathEffect);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GRAY);

        path.reset();
        path.moveTo(50,  50);
        path.lineTo(50, getHeight()-50);
        path.lineTo(getWidth()-50, getHeight()-50);
        path.lineTo(getWidth()-50, 50);
        path.close();

        canvas.drawPath(path, paint);
    }
}
