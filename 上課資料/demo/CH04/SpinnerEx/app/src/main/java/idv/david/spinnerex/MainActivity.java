package idv.david.spinnerex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tvResult;
    private Spinner spPlace, spTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews() {
        tvResult = (TextView) findViewById(R.id.tvResult);
        spPlace = (Spinner) findViewById(R.id.spPlace);
        // 在執行setOnItemSelectedListener()之前先呼叫setSelection(position, animate)
        // 可避免一開始就執行OnItemSelectedListener.onItemSelected()
        spPlace.setSelection(0, true);
        spPlace.setOnItemSelectedListener(listener);

        // 直接由程式碼動態產生Spinner做法
        spTeam = (Spinner) findViewById(R.id.spTeam);
        String[] teams = {"紐約洋基", "巴爾的摩金鶯", "洛杉磯道奇"};
        // ArrayAdapter用來管理整個選項的內容與樣式，android.R.layout.simple_spinner_item為內建預設樣式
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this, android.R.layout.simple_spinner_item, teams);
        // android.R.layout.simple_spinner_dropdown_item為內建下拉選單樣式
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spTeam.setAdapter(adapter);
        spTeam.setSelection(0, true);
        spTeam.setOnItemSelectedListener(listener);
    }

    Spinner.OnItemSelectedListener listener = new Spinner.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
            tvResult.setText(parent.getItemAtPosition(position).toString());
        }

        @Override
        public void onNothingSelected(AdapterView<?> parent) {
            // Nothing to do here...
        }
    };

}
