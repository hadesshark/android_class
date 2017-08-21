package david.idv.bmiex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * Created by 201t on 2017/8/21.
 */

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        tvResult = (TextView) findViewById(R.id.tvResult);
        showResult();
    }

    private void showResult() {
        NumberFormat nf = NumberFormat.getInstance();
        nf.setMaximumFractionDigits(2);
        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();
        double height = bundle.getDouble("height");
        double weight = bundle.getDouble("weight");

        double bmi = weight / Math.pow(height, 2);
        String result = "";
        if (bmi < 18.5) {
            result = "過瘦";
        } else if (bmi >= 24) {
            result = "過胖";
        } else {
            result = "正常";
        }

        String bmiStr = nf.format(bmi);
        StringBuilder sb  = new StringBuilder();
        sb.append("BMI: ").append(bmiStr).append("\n").append("結果: ").append(result);

        tvResult.append("\n" + sb.toString());

    }

    public void onBackClick(View view) {
        this.finish();
    }
}
