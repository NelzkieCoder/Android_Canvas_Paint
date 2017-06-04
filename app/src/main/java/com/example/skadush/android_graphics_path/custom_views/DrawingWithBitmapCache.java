package com.example.skadush.android_graphics_path.custom_views;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.Toast;

/**
 * Created by skadush on 4/06/17.
 */

public class DrawingWithBitmapCache extends View {


    Paint paint;
    Path path;
    Bitmap bitmap = null;
    int width,height;

    public DrawingWithBitmapCache(final Context context) {
        super(context);


        //https://stackoverflow.com/questions/3591784/getwidth-and-getheight-of-view-returns-0
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                width = getWidth();
                height = getHeight();
                init();
            }
        });




    }




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

        bitmap = Bitmap.createBitmap(width,height, Bitmap.Config.ARGB_4444);
        Canvas c = new Canvas(bitmap);
        c.drawPath(path,paint);
//        c.setBitmap(bitmap);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint alphaPaint = new Paint();
        alphaPaint.setAlpha(255);
       canvas.drawBitmap(bitmap,0,0,alphaPaint);
    }

    void getTheRootView(){
        ViewGroup viewGroup = (ViewGroup) ((ViewGroup) this
                .findViewById(android.R.id.content)).getChildAt(0);
        Toast.makeText(getContext(), " " + viewGroup.toString(), Toast.LENGTH_SHORT).show();
    }
}
