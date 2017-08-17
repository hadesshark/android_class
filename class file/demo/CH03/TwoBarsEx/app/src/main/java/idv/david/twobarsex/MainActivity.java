package idv.david.twobarsex;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private RelativeLayout relativeLayout;
    private RatingBar rbGrade;
    private SeekBar sbRGB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        relativeLayout = (RelativeLayout) findViewById(R.id.relativeLayout);
        rbGrade = (RatingBar) findViewById(R.id.rbGrade);
        sbRGB = (SeekBar) findViewById(R.id.sbRGB);

        rbGrade.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                String message = getString(R.string.rbresult) + rating + " 分";
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
            }
        });

        sbRGB.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                relativeLayout.setBackgroundColor(Color.rgb(progress, progress, progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, getString(R.string.sbstart), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this, getString(R.string.sbend) + seekBar.getProgress(), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
