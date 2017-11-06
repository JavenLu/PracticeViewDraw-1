package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice2DrawCircleView extends View {
    private Paint paint;

    public Practice2DrawCircleView(Context context) {
        super(context);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice2DrawCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
        initData();
        showFillBlackCircle(canvas);
        showHollowBlackCircle(canvas);
        showFillBlueCircle(canvas);
        showBoldHollowCircle(canvas);
    }

    private void showBoldHollowCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(100);
        canvas.drawCircle(1000, 700, 200, paint);
    }

    private void showFillBlueCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(420, 650, 200, paint);
    }

    private void showFillBlackCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.BLACK);
        canvas.drawCircle(420, 200, 200, paint);
    }

    private void showHollowBlackCircle(Canvas canvas) {
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(5);
        canvas.drawCircle(1000, 200, 200, paint);
    }

    private void initData() {
        paint = new Paint();
    }
}
