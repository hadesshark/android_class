package hadesshark.idv.homework4_1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText tall, weidth;
    Button btn_submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        tall = (EditText) findViewById(R.id.tall);
        weidth = (EditText) findViewById(R.id.weidth);
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ViewActivity.class);

                Bundle bundle = new Bundle();

                // 傳送基本資料並對使用者輸入資料做例外處理
                try {
                    String s_tall = tall.getText().toString();
                    String s_width = weidth.getText().toString();

                    double d_tall = Double.parseDouble(s_tall);
                    double d_width = Double.parseDouble(s_width);

                    double d_result = d_width / (d_tall * d_tall);
                    System.out.println("123" + Double.toString(d_result));

                    if (s_tall.isEmpty() || s_width.isEmpty()) {
                        throw new Exception();
                    }
                    bundle.putDouble("d_tall", d_tall);
                    bundle.putDouble("d_weidth", d_width);
                } catch (Exception e) {
                    Toast.makeText(MainActivity.this, "發生錯誤", Toast.LENGTH_SHORT).show();
                    return;
                }

                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

}
