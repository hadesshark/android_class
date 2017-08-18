package idv.david.broadcastreceiverex;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "BroadcateReceiverEx";
    private static final int MY_REQUEST_CODE = 1;
    private TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvResult = (TextView) findViewById(R.id.tvResult);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // 裝置為API 23(Android 6.0)以上有效
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.RECEIVE_SMS) != PackageManager.PERMISSION_GRANTED
                || (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED)) {
            // 要求RECEIVE_SMS與READ_PHONE_STATE權限
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECEIVE_SMS, Manifest.permission.READ_PHONE_STATE},
                    MY_REQUEST_CODE);
        } else {
            receiveMyBroadcast();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        if (requestCode == MY_REQUEST_CODE) {
            if (verifyPermissions(grantResults))
                Log.e(TAG, "Permissions were granted!");
        }
    }

    private void receiveMyBroadcast() {
        Bundle bundle = this.getIntent().getExtras();
        if (bundle == null) {
            return;
        }
        String type = bundle.getString("type");
        switch (type) {
            case "sms":
                String sender = bundle.getString("sender");
                String smsContent = bundle.getString("smsContent");
                String date = bundle.getString("date");
                tvResult.setText("Sender： " + sender + "\n" +
                        "SMS_Content： " + smsContent + "\n" +
                        "Date： " + date);
                break;
            case "phone":
                String incomingPhone = bundle.getString("incomePhone");
                String phoneState = bundle.getString("phoneState");
                tvResult.setText("Incoming Number： " + incomingPhone + "\n" +
                        "Phone State： " + phoneState);
                break;
        }
    }

    // Utility
    public static boolean verifyPermissions(int[] grantResults) {
        // 長度小於1代表沒有任何得到結果，視為權限要求失敗
        if(grantResults.length < 1){
            return false;
        }
        // 將每個結果取出比對
        for (int result : grantResults) {
            if (result != PackageManager.PERMISSION_GRANTED) {
                return false;
            }
        }
        return true;
    }


}
