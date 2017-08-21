package helloandroid.homework3_1;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by hadesshark on 2017/8/20.
 */

public class CircleView extends View{
    private Paint paint = new Paint();
    private Canvas canvas = new Canvas();

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
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
        canvas.drawCircle(view_height / 2, view_width / 2, 200f, paint);
    }
}
