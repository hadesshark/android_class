package idv.david.tabsex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class NewsDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newsdetails);

        News news = (News) getIntent().getExtras().getSerializable("news");
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        TextView tvDate = (TextView) findViewById(R.id.tvDate);
        TextView tvDetail = (TextView) findViewById(R.id.tvDetail);
        tvTitle.setText(news.getTitle());
        tvDate.setText(news.getDate());
        tvDetail.setText(news.getDetail());
    }
}
