package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.util.AttributeSet;
import android.view.View;

public class Practice11PieChartView extends View {
    public static final String[] textArray = new String[]{"Lolipop", "KitKat", "Marshmallow", "Froyo", "Gingerbread", "Ice Cream Sandwich", "Jelly Bean"};

    public Practice11PieChartView(Context context) {
        super(context);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice11PieChartView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画饼图
        int screenWidth = getWidth();
        int screenHeight = getHeight();
        int halfWidth = screenWidth / 2;
        int halfHeight = screenHeight / 2;
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);

        drawSector(canvas, halfWidth, halfHeight, mPaint);
        drawLine(canvas, halfWidth, halfHeight, mPaint);
        drawText(canvas, screenWidth, screenHeight, mPaint);
    }

    private void drawText(Canvas canvas, int screenWidth, int screenHeight, Paint mPaint) {
        mPaint.setStrokeWidth(0);
        mPaint.setColor(Color.WHITE);
        mPaint.setTextSize(30);
        canvas.drawText(textArray[0], 60, 135, mPaint);
        canvas.drawText(textArray[1], 60, 750, mPaint);
        canvas.drawText(textArray[2], screenWidth - 310, 270, mPaint);
        canvas.drawText(textArray[3], screenWidth - 310, 425, mPaint);
        canvas.drawText(textArray[4], screenWidth - 310, 510, mPaint);
        canvas.drawText(textArray[5], screenWidth - 310, 560, mPaint);
        canvas.drawText(textArray[6], screenWidth - 310, 670, mPaint);

        mPaint.setTextSize(60);
        canvas.drawText("饼图", screenWidth / 2 - 170, screenHeight - 50, mPaint);
    }

    private void drawLine(Canvas canvas, int halfWidth, int halfHeight, Paint mPaint) {
        // 横线
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.GRAY);
        mPaint.setStrokeWidth(5);
        Path path = new Path();
        path.moveTo(400, 157);
        path.lineTo(385, 135);
        path.rLineTo(-200, 0);

        path.moveTo(390, 726);
        path.lineTo(375, 748);
        path.rLineTo(-200, 0);

        path.moveTo(900, 650);
        path.lineTo(915, 672);
        path.rLineTo(200, 0);

        path.moveTo(970, 495);
        path.lineTo(1000, 495);
        path.rLineTo(77, 60);
        path.rLineTo(30, 0);

        path.moveTo(halfWidth + 250, halfHeight - 40);
        path.rLineTo(30, 0);
        path.rLineTo(77, 60);
        path.rLineTo(30, 0);

        path.moveTo(halfWidth + 250, halfHeight - 65);
        path.rLineTo(135, 0);

        path.moveTo(halfWidth + 210, halfHeight - 200);
        path.rLineTo(30, -15);
        path.rLineTo(140, 0);
        canvas.drawPath(path, mPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @NonNull
    private void drawSector(Canvas canvas, int halfWidth, int halfHeight, Paint mPaint) {
        //红色扇形
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setColor(Color.RED);
        canvas.drawArc(halfWidth - 480, halfHeight - 380, halfWidth + 250, halfHeight + 280, -180, 115, true, mPaint);

        //蓝色扇形
        mPaint.setColor(Color.rgb(0, 191, 255));
        canvas.drawArc(halfWidth - 470, halfHeight - 360, halfWidth + 250, halfHeight + 300, -182, -105, true, mPaint);

        //绿色扇形
        mPaint.setColor(Color.rgb(46, 139, 87));
        canvas.drawArc(halfWidth - 460, halfHeight - 360, halfWidth + 250, halfHeight + 300, -289, -60, true, mPaint);

        //灰色扇形
        mPaint.setColor(Color.GRAY);
        canvas.drawArc(halfWidth - 460, halfHeight - 360, halfWidth + 250, halfHeight + 300, -351, -5, true, mPaint);

        //紫色扇形
        mPaint.setColor(Color.rgb(153, 50, 204));
        canvas.drawArc(halfWidth - 460, halfHeight - 360, halfWidth + 250, halfHeight + 300, -358, -7, true, mPaint);

        //黄色扇形
        mPaint.setColor(Color.rgb(255, 165, 0));
        canvas.drawArc(halfWidth - 460, halfHeight - 360, halfWidth + 250, halfHeight + 300, -7, -53, true, mPaint);
    }
}
