package idv.david.drawcanvasex;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class RectBarView extends View {
    private List<Integer> inputData = new ArrayList<>();
    private Paint paint = new Paint();
    private Rect rect = new Rect();

    public RectBarView(Context context) {
        super(context);
    }

    public RectBarView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // 視情況呼叫super.onDraw(canvas)
        super.onDraw(canvas);
        paint.setStyle(Paint.Style.FILL);
        // 取得這個元件的長與寬
        int viewHeight = this.getHeight();
        int viewWidth = this.getWidth();

        // 畫水平線
        paint.setColor(Color.WHITE);
        paint.setStrokeWidth(1f);
        // 開啟畫圖防鋸齒功能
        paint.setAntiAlias(true);
        canvas.drawLine(0, viewHeight / 2, viewWidth, viewHeight / 2, paint);

        // 亂數產生資料前先清除集合內容一次
        inputData.clear();
        for (int i = 0; i < 20; i++) {
            // 亂數產生-300～300的值
            int randomNumber = (int) (Math.random() * 601);
            randomNumber -= 300;
            inputData.add(randomNumber);
        }

        // 畫線上的點
        paint.setColor(Color.YELLOW);
        // 每個點之間的間隔
        int space = viewWidth / 20;
        for (int i = 0; i < 20; i++) {
            canvas.drawCircle((space + (i * space)), viewHeight / 2, 5f, paint);
        }

        // 畫柱狀圖
        int barHeight = viewHeight / 2;
        for (int i = 0; i < 20; i++) {
            int data = inputData.get(i);
            // 取每個值出來並判斷正或負
            if (data > 0) {
                int left = i * space;
                int right = space + i * space;
                int top = barHeight - data;
                int bottom = barHeight;
                rect.set(left + 6, top, right - 6, bottom);
                paint.setColor(Color.RED);
            } else {
                int left = i * space;
                int right = space + i * space;
                int top = barHeight;
                int bottom = barHeight - data;
                rect.set(left + 6, top, right - 6, bottom);
                paint.setColor(Color.GREEN);
            }
            canvas.drawRect(rect, paint);
        }
    }
}
