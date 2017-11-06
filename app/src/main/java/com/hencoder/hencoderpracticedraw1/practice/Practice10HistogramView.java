package com.hencoder.hencoderpracticedraw1.practice;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Practice10HistogramView extends View {

    public static final int RECT_WIDTH = 120;
    public static final int RECT_SPACE = 30;
    public static final int RECT_NUM = 6;
    public static final int TEXT_NUM = 7;
    public static final String[] textArray = new String[]{"Froyo", "GB", "ICS", "JB", "KitKat", "L", "M"};

    public Practice10HistogramView(Context context) {
        super(context);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Practice10HistogramView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        综合练习
//        练习内容：使用各种 Canvas.drawXXX() 方法画直方图

        int width = getWidth();
        int height = getHeight();
        int whiteLineLeftSpace = width / 2 - (width / 2 - 200);

        Paint paint = new Paint();
        paint.setColor(Color.WHITE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(3);
        showFrameWhiteLine(canvas, whiteLineLeftSpace, paint);

        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        showBarChart(canvas, whiteLineLeftSpace, paint);

        paint.setColor(Color.WHITE);
        paint.setTextSize(35);
        showSmallText(canvas, whiteLineLeftSpace, paint);

        paint.setTextSize(60);
        canvas.drawText("直方图", width / 2 - 68, height - 100, paint);

    }

    private void showSmallText(Canvas canvas, int whiteLineLeftSpace, Paint paint) {
        for (int j = 0; j < TEXT_NUM; j++) {

            if (j == 1 || j == 0) {
                canvas.drawText(textArray[j], (whiteLineLeftSpace + 40) + 180 * j, 740, paint);
            } else if (j == 2) {
                canvas.drawText(textArray[j], (whiteLineLeftSpace + 40) + 165 * j, 740, paint);
            } else if (j == 3) {
                canvas.drawText(textArray[j], (whiteLineLeftSpace + 40) + 160 * j, 740, paint);
            } else if (j == 4) {
                canvas.drawText(textArray[j], (whiteLineLeftSpace + 40) + 150 * j, 740, paint);
            } else if (j == 5) {
                canvas.drawText(textArray[j], (whiteLineLeftSpace + 40) + 158 * j, 740, paint);
            } else {
                canvas.drawText(textArray[j], (whiteLineLeftSpace + 40) + 156 * j, 740, paint);
            }
        }
    }

    private void showFrameWhiteLine(Canvas canvas, int whiteLineLeftSpace, Paint paint) {
        Path path = new Path();
        path.moveTo(whiteLineLeftSpace, 100);
        path.lineTo(whiteLineLeftSpace, 700);
        path.rLineTo(1100, 0);
        path.moveTo(setSpace(whiteLineLeftSpace), 697);
        path.lineTo(rectWidth(whiteLineLeftSpace), 697);
        canvas.drawPath(path, paint);
    }

    private void showBarChart(Canvas canvas, int whiteLineLeftSpace, Paint paint) {
        for (int i = 0; i < RECT_NUM; i++) {
            if (i == 2) {
                canvas.drawRect(getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i, 400, (getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i) + RECT_WIDTH, 700, paint);
            } else if (i == 3) {
                canvas.drawRect(getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i, 200, (getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i) + RECT_WIDTH, 700, paint);
            } else if (i == 4) {
                canvas.drawRect(getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i, 100, (getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i) + RECT_WIDTH, 700, paint);
            } else if (i == 5) {
                canvas.drawRect(getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i, 420, (getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i) + RECT_WIDTH, 700, paint);
            } else {
                canvas.drawRect(getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i, 675, (getFirstRectLeft(whiteLineLeftSpace) + getRectWidthAddSpaceWidth() * i) + RECT_WIDTH, 700, paint);
            }
        }
    }

    private int getFirstRectLeft(int whiteLineLeft) {
        return whiteLineLeft + RECT_SPACE + RECT_WIDTH + RECT_SPACE;
    }

    private int getRectWidthAddSpaceWidth() {
        return RECT_WIDTH + RECT_SPACE;
    }

    private int rectWidth(int whiteLineLeft) {
        return setSpace(whiteLineLeft) + RECT_WIDTH;
    }

    private int setSpace(int whiteLineLeft) {
        return whiteLineLeft + RECT_SPACE;
    }
}
