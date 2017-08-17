package helloandroid.homework2_1;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {
    private ImageView background_color;
    private RelativeLayout relative_layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findView();
    }

    private void findView() {
        background_color = (ImageView) findViewById(R.id.background_color);
        relative_layout = (RelativeLayout) findViewById(R.id.relative_layout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.content_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.wallpaper_a:
                background_color.setBackgroundResource(R.drawable.a);
                background_color.setVisibility(View.VISIBLE);
                break;

            case R.id.wallpaper_b:
                background_color.setBackgroundResource(R.drawable.b);
                background_color.setVisibility(View.VISIBLE);
                break;

            case R.id.wallpaper_c:
                background_color.setBackgroundResource(R.drawable.c);
                background_color.setVisibility(View.VISIBLE);
                break;

            case R.id.yellow:
                background_color.setVisibility(View.GONE);
                relative_layout.setBackgroundColor(Color.YELLOW);
                break;

            case R.id.blue:
                background_color.setVisibility(View.GONE);
                relative_layout.setBackgroundColor(Color.BLUE);
                break;

            case R.id.red:
                background_color.setVisibility(View.GONE);
                relative_layout.setBackgroundColor(Color.RED);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return true;
    }
}
