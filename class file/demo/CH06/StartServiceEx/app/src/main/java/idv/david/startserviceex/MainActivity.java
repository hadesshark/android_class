package idv.david.startserviceex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnStart, btnStop;
    private MyReceiver myReceiver;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        resetLayout(false);
        registerMyReceiver();
    }

    private void findViews() {
        btnStart = (Button) findViewById(R.id.btnStart);
        btnStop = (Button) findViewById(R.id.btnStop);
    }

    private class MyReceiver extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            showToast("Service starting");
        }
    }

    private void registerMyReceiver() {
        IntentFilter filter = new IntentFilter(MainService.ACTION_SERVICE_START);
        myReceiver = new MyReceiver();
        registerReceiver(myReceiver, filter);
    }

    public void onStartClick(View view) {
        Intent intent = new Intent(this, MainService.class);
        startService(intent);
        resetLayout(true);
    }

    public void onStopClick(View view) {
        Intent intent = new Intent(this, MainService.class);
        stopService(intent);
        resetLayout(false);
    }

    private void resetLayout(boolean isActive) {
        if (isActive) {
            btnStart.setVisibility(View.GONE);
            btnStop.setVisibility(View.VISIBLE);
        } else {
            btnStart.setVisibility(View.VISIBLE);
            btnStop.setVisibility(View.GONE);
        }
    }


    public void onDestroy() {
        try {
            unregisterReceiver(myReceiver);
        } catch (IllegalArgumentException e) {
            showToast("No BroadcastReceiver any more!!");
        }
        super.onDestroy();
    }

    private void showToast(String text) {
        Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT)
                .show();
    }

}
