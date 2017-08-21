package helloandroid.homework3_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hadesshark on 2017/8/20.
 */

public class ShapeView extends View {
    private Paint paint = new Paint();
    private Rect rect = new Rect();

    public ShapeView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShapeView(Context context) {
        super(context);
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);

        int view_height = this.getHeight();
        int view_width = this.getWidth();
        int left = view_width / 2 - 100;
        int top = view_height / 2 - 100;
        int right = view_width / 2 + 100;
        int bottom = view_height / 2 + 100;
        rect.set(left, top, right, bottom);
        canvas.drawRect(rect, paint);
    }
}
