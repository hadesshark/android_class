package idv.david.imageex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageButton ibClick;
    private ImageView ivTed;
    private boolean isClicked = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        ibClick = (ImageButton) findViewById(R.id.ibClick);
        ivTed = (ImageView) findViewById(R.id.ivTed);

        ibClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (isClicked) {
                    ivTed.setImageResource(R.drawable.ted);
                    isClicked = false;
                } else {
                    ivTed.setImageResource(R.drawable.ted2);
                    isClicked = true;
                }
            }
        });
    }
}
