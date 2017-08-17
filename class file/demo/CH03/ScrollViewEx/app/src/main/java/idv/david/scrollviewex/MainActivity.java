package idv.david.scrollviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvCount;
    private ScrollView scrollView;
    private LinearLayout linearLayout;
    private int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        tvCount.setText(Integer.toString(count));
    }

    private void findViews() {
        tvCount = (TextView) findViewById(R.id.tvCount);
        scrollView = (ScrollView) findViewById(R.id.scrollView);
        linearLayout = (LinearLayout) findViewById(R.id.linearLayout);
    }

    public void onAddClick(View view) {
        count++;
        tvCount.setText(Integer.toString(count));
        //藉由程式碼動態產生TextView，this指的是MainActivity這個物件
        TextView textView = new TextView(this);
        textView.setText(Integer.toString(count));
        linearLayout.addView(textView);

        //開啟執行緒，若scrollView填滿螢幕則聚焦在最下方
        scrollView.post(new Runnable() {
            @Override
            public void run() {
                scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
    }
}
