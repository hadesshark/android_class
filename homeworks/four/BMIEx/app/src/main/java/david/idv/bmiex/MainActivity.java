package david.idv.bmiex;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText etHeight, etWeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        etHeight = (EditText) findViewById(R.id.etHeight);
        etWeight = (EditText)findViewById(R.id.etWeight);
    }

    public void onSubmitClick(View view) {
        String heightStr = etHeight.getText().toString();
        String weightStr = etWeight.getText().toString();

        if (heightStr.isEmpty() || weightStr.isEmpty()) {
            Toast.makeText(this, getString(R.string.msg_empty_err), Toast.LENGTH_SHORT).show();
            return;
        }

        try {
            double height = Double.parseDouble(heightStr) / 100;
            double weight = Double.parseDouble(weightStr);

            Intent intent = new Intent(this, ResultActivity.class);
            Bundle bundle = new Bundle();
            bundle.putDouble("height", height);
            bundle.putDouble("weight", weight);
            intent.putExtras(bundle);

            startActivity(intent);

        } catch (NumberFormatException ne) {
            Toast.makeText(this, getString(R.string.msg_data_err), Toast.LENGTH_SHORT).show();
            return;
        }


    }

    public void onCancelClick(View view) {
        etHeight.setText("");
        etWeight.setText(null);
    }
}
