package idv.david.buttonex;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnOne, btnCustom;
    private ImageButton imgBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
    }

    private void findViews() {
        btnOne = (Button) findViewById(R.id.btnOne);
        //寫法一：匿名類別
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //按鈕按下後執行的內容
                String text = ((Button) view).getText().toString();
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT)
                        .show();
            }
        });

        btnCustom = (Button) findViewById(R.id.btnCustom);
        btnCustom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, getString(R.string.btncustom), Toast.LENGTH_SHORT)
                        .show();
            }
        });

        // 配合寫法三註冊監聽器
        imgBtn = (ImageButton) findViewById(R.id.imgBtn);
        MyClickListener listener = new MyClickListener();
        imgBtn.setOnClickListener(listener);

    }

    //寫法二：xml定義onClick屬性
    //自訂onClick方法格式必須是public void XXX(View view) {}
    public void onButtonClick(View view) {
        String text = ((Button) view).getText().toString();
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT)
                .show();
    }

    //寫法三：新增類別並實作View.OnClickListener
    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            Toast.makeText(MainActivity.this, getString(R.string.imgbtn), Toast.LENGTH_SHORT)
                    .show();
        }
    }

}
