package idv.david.compositebuttonex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {
    private RadioGroup rgBrand;
    private TextView tvResult;
    private Switch switchPower;
    private CheckBox cbJapan, cbGermany, cbFrance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        rgBrand = (RadioGroup) findViewById(R.id.rgBrand);
        cbJapan = (CheckBox) findViewById(R.id.cbJapan);
        cbGermany = (CheckBox) findViewById(R.id.cbGermany);
        cbFrance = (CheckBox) findViewById(R.id.cbFrance);
        tvResult = (TextView) findViewById(R.id.tvResult);
        switchPower = (Switch) findViewById(R.id.switchPower);

        rgBrand.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int id) {
                RadioButton rb = (RadioButton) radioGroup.findViewById(id);
                tvResult.setText(rb.getText().toString());
            }
        });

        switchPower.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                Switch sw = (Switch) compoundButton;
                String s = sw.getText().toString();
                String swResult = "";
                if (sw.isChecked()) {
                    swResult += s + " " + sw.getTextOn().toString();
                } else {
                    swResult += s + " " + sw.getTextOff().toString();
                }
                tvResult.setText(swResult);
            }
        });
    }

    public void onToggleButtonClick(View v) {
        ToggleButton tb = (ToggleButton) v;
        String tbResult = tb.getText().toString();
        tvResult.setText(tbResult);
    }

    public void onBtnSubmitClick(View v) {
        String cbResult = "";
        if (cbJapan.isChecked())
            cbResult += cbJapan.getText().toString() + " ";
        if (cbGermany.isChecked())
            cbResult += cbGermany.getText().toString() + " ";
        if (cbFrance.isChecked())
            cbResult += cbFrance.getText().toString() + " ";
        tvResult.setText(cbResult);
    }
}
