package idv.david.autocompletetextviewex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private AutoCompleteTextView acCountry, acInput;
    private Button btnAddText, btnClearText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    public void findViews() {
        acCountry = (AutoCompleteTextView) findViewById(R.id.acCountry);
        // getResources()會得到Resource物件，再透過getStringArray方法取得字串陣列
        String[] countries = getResources().getStringArray(R.array.countries_array);
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.list_text, countries);
        acCountry.setAdapter(adapter);
        acCountry.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String country = parent.getItemAtPosition(position).toString();
                Toast.makeText(MainActivity.this, country, Toast.LENGTH_SHORT).show();
            }
        });

        acInput = (AutoCompleteTextView) findViewById(R.id.acInput);
        final ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_dropdown_item_1line);
        acInput.setAdapter(adapter2);
        btnAddText = (Button) findViewById(R.id.btnAddText);
        btnAddText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = acInput.getText().toString();
                adapter2.add(s);
                acInput.setText("");
            }
        });

        btnClearText = (Button) findViewById(R.id.btnClearText);
        btnClearText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                adapter2.clear();
            }
        });

    }
}
