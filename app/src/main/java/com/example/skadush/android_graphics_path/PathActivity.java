package com.example.skadush.android_graphics_path;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.skadush.android_graphics_path.custom_views.AddingTouchView;
import com.example.skadush.android_graphics_path.custom_views.CornerPathEffectView;
import com.example.skadush.android_graphics_path.custom_views.DashPath;
import com.example.skadush.android_graphics_path.custom_views.DrawingWithBitmapCache;
import com.example.skadush.android_graphics_path.custom_views.DrawingWithPath;
import com.example.skadush.android_graphics_path.custom_views.NormalPath;
import com.example.skadush.android_graphics_path.custom_views.PathDashPathEffectView;

public class PathActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        int position = getIntent().getIntExtra(MainActivity.TAG,0);

        switch (position){
            case 0:
                setContentView(new NormalPath(this));
                break;
            case 1:
                setContentView(new DashPath(this));
                break;
            case 2:
                setContentView(new PathDashPathEffectView(this));
                break;
            case 3:
                setContentView(new CornerPathEffectView(this));
                break;
            case 4:
                setContentView(new AddingTouchView(this));
                break;
            case 5:
                setContentView(new DrawingWithPath(this));
                break;
            case 6:
                setContentView(new DrawingWithBitmapCache(this));
                break;
            default:
                setContentView(new NormalPath(this));
        }
    }

}
