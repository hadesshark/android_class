package helloandroid.homework4_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.text.NumberFormat;

/**
 * Created by hadesshark on 2017/8/22.
 */

public class ResultActivity extends AppCompatActivity{

    private Button btn_ok, btn_clear, btn_back;
    private EditText et_height, et_weight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        findViews();
    }

    private void findViews() {
        btn_ok = (Button) findViewById(R.id.btn_ok);
        btn_clear = (Button) findViewById(R.id.btn_clear);
        btn_back = (Button) findViewById(R.id.btn_back);

        et_height = (EditText) findViewById(R.id.et_height);
        et_weight = (EditText) findViewById(R.id.et_weight);

        btn_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str_height = et_height.getText().toString();
                String str_weight = et_weight.getText().toString();

                double d_height = Double.parseDouble(str_height);
                double d_weight = Double.parseDouble(str_weight);

                double d_result = d_weight / Math.pow(d_height, 2);

                String result = "";
                if (d_result < 18.5) {
                    result = "過瘦";
                } else if (d_result >= 24) {
                    result = "過胖";
                } else {
                    result = "正常";
                }

                NumberFormat nf = NumberFormat.getInstance();
                nf.setMaximumFractionDigits(2);
                String bmiStr = nf.format(d_result);
                StringBuilder sb  = new StringBuilder();
                sb.append("BMI: ").append(bmiStr).append("\n").append("結果: ").append(result);

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("result", sb.toString());
                intent.putExtras(bundle);
                setResult(RESULT_OK, intent);
                finish();
            }
        });

        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str = "BMI: \n結果為：";

                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString("result", str);
                intent.putExtras(bundle);
                setResult(RESULT_CANCELED, intent);
                finish();
            }
        });

        btn_clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_height.setText("");
                et_weight.setText("");
            }
        });
    }
}
