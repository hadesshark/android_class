package helloandroid.homework3_1;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    CircleView circleView;
    ShapeView shapeView;
    Paint paint = new Paint();
    int select_flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu, menu);
        return true;
    }

    private void findView() {
        circleView = (CircleView) findViewById(R.id.circle_view);
        shapeView = (ShapeView) findViewById(R.id.shape_view);
        circleView.setVisibility(View.GONE);
        shapeView.setVisibility(View.GONE);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.circle:
                circleView.setVisibility(View.VISIBLE);
                shapeView.setVisibility(View.GONE);

                circleView.invalidate();
                select_flag = 0;
                break;
            case R.id.square:
                circleView.setVisibility(View.GONE);
                shapeView.setVisibility(View.VISIBLE);

                shapeView.invalidate();
                select_flag = 1;
                break;
            case R.id.red:
                paint.setColor(Color.RED);
                if (select_flag == 0) {
                    circleView.setPaint(paint);
                    circleView.invalidate();
                }
                else {
                    shapeView.setPaint(paint);
                    shapeView.invalidate();
                }
                break;
            case R.id.blue:
                paint.setColor(Color.BLUE);
                if (select_flag == 0) {
                    circleView.setPaint(paint);
                    circleView.invalidate();
                }
                else {
                    shapeView.setPaint(paint);
                    shapeView.invalidate();
                }
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
