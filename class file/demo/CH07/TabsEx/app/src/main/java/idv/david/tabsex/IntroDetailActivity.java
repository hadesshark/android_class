package idv.david.tabsex;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

public class IntroDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introdetails);

        Intro intro = (Intro) getIntent().getExtras().getSerializable("intro");
        ImageView imageView = (ImageView) findViewById(R.id.imageView);
        TextView tvName = (TextView) findViewById(R.id.tvName);
        TextView tvTitle = (TextView) findViewById(R.id.tvTitle);
        imageView.setImageResource(intro.getImageId());
        tvName.setText(intro.getName());
        tvTitle.setText(intro.getCName());
    }

}
