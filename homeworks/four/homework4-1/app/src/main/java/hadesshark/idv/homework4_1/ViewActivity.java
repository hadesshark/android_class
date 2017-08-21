package hadesshark.idv.homework4_1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by 201 on 2017/8/21.
 */

public class ViewActivity extends AppCompatActivity {
    TextView textView;
    Button back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tatal_view);
        findViews();
        showResult();
    }

    private void findViews() {
        textView = (TextView) findViewById(R.id.textView);
        back = (Button) findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewActivity.this.finish();
            }
        });
    }

    private void showResult() {
        Bundle bundle = this.getIntent().getExtras();

        double d_tall = bundle.getDouble("d_tall");
        double d_weidth = bundle.getDouble("d_weidth");

        double d_result = d_weidth / (d_tall * d_tall);
        String str = new String();
        System.out.println(d_result);
        if (d_result < 18.5) {
            str = "過瘦";
        }else if(18.5 <= d_result && d_result < 24) {
            str = "正常";
        }else{
            str = "過胖";
        }

        textView.setText("計算出來的 BMI 為" + String.format("%.2f", d_result) + "\n" + str);
    }
}
