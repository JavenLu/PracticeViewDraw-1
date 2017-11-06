package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice8DrawArcView extends View {

    public Practice8DrawArcView(Context context) {
        super(context);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice8DrawArcView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawArc() 方法画弧形和扇形

        int width = getWidth();
        int height = getHeight();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(width / 2-200, height / 2 - 200, width / 2 + 200, height / 2 + 200, -10, -120, true, paint);

        paint.setStyle(Paint.Style.STROKE);
        canvas.drawArc(width / 2-200, height / 2 - 200, width / 2 + 200, height / 2 + 200, -135, -45, false, paint);

        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(width / 2-200, height / 2 - 200, width / 2 + 200, height / 2 + 200, 20, 140, false, paint);
    }
}
