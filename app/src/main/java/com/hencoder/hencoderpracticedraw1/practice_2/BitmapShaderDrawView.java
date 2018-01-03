package com.hencoder.hencoderpracticedraw1.practice_2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ComposeShader;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.hencoder.hencoderpracticedraw1.R;

/**
 * Created by Javen on 03/01/2018.
 */

public class BitmapShaderDrawView extends View {
    Paint paint;

    public BitmapShaderDrawView(Context context) {
        this(context, null);
    }

    public BitmapShaderDrawView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public BitmapShaderDrawView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        paint = new Paint();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap batMan = BitmapFactory.decodeResource(getResources(), R.drawable.bat_man);
        Shader batManShader = new BitmapShader(batMan, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Bitmap batManLog = BitmapFactory.decodeResource(getResources(), R.drawable.bat_log);
        Shader batLogShader = new BitmapShader(batManLog, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);

        Shader shader = new ComposeShader(batManShader, batLogShader, PorterDuff.Mode.SRC_OUT);
        paint.setShader(shader);

        canvas.drawCircle(800, 800, 300, paint);
    }
}
