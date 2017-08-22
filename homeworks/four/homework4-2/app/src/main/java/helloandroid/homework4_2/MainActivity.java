package helloandroid.homework4_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final int btn_to_result = 0;
    private Button btn_finish_exercise;
    private Button btn_face_bmi;
    private TextView tv_bmi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        btn_finish_exercise = (Button) findViewById(R.id.btn_finish_exercise);
        btn_finish_exercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btn_face_bmi = (Button) findViewById(R.id.btn_fack_bmi);
        btn_face_bmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                startActivityForResult(intent, btn_to_result);
            }
        });
        tv_bmi = (TextView) findViewById(R.id.tv_BMI);
        tv_bmi.setText("BMI值為：\n結果為：");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode != btn_to_result) {
            return;
        }

        switch (resultCode) {
            case RESULT_OK:
                Bundle bundle = data.getExtras();
                String result = bundle.getString("result");
                tv_bmi.setText(result);
                break;
            case RESULT_CANCELED:
                tv_bmi.setText("BMI值為：\n結果為：");
                break;
        }
    }
}
