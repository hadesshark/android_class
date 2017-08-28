package helloandroid.homework5_1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private final static int NOTIFICATION_ID = 100;
    private Button btn_submit, btn_cannel;
    private TextView tv_show_string;
    private EditText et_input;
    private NotificationManager notificationManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        findViews();
    }

    private void findViews() {
        btn_submit = (Button) findViewById(R.id.btn_submit);
        btn_cannel = (Button) findViewById(R.id.btn_cannel);
        et_input = (EditText) findViewById(R.id.et_input);
        tv_show_string = (TextView) findViewById(R.id.tv_getString);

        btn_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!et_input.getText().toString().matches("")) {
                    String str = et_input.getText().toString();
                    System.out.println(str);
                    new GetText().execute(str,str,str);
                }
            }
        });

        btn_cannel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input.setText(null);
                tv_show_string.setText("get String");
            }
        });
    }

    private void createNotification() {
        //資料放入bundle物件後再放進intent物件
        String content = et_input.getText().toString();
        Intent intent = new Intent(MainActivity.this, NotiActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("content", content);
        intent.putExtras(bundle);

        /*
           Intent指定好要幹嘛後，就去做了，如startActivity(intent);
           而PendingIntent則是先把某個Intent包好，以後再去執行Intent要幹嘛
         */
        PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this
                , 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.drawable.ic_secret_notification);
        String str_title = getString(R.string.tv_title);
        String str_content = getString(R.string.tv_content);

        Notification notification = new Notification.Builder(MainActivity.this)
                //訊息的圖示
                .setSmallIcon(R.drawable.ic_secret_notification)
                .setLargeIcon(bmp)
                .setContentTitle(str_title)
                //訊息面板的內容文字
                .setContentText(str_content)
                //訊息的圖示
                .setWhen(System.currentTimeMillis())
                //點擊後會自動移除狀態列上的通知訊息
                .setAutoCancel(true)
                //等使用者點了之後才會開啟指定的Activity
                .setContentIntent(pendingIntent)
                //加入聲音
                .setSound(soundUri)
                .setPriority(Notification.PRIORITY_MAX)
                .build();
        //呼叫notify()送出通知訊息
        notificationManager.notify(NOTIFICATION_ID, notification);
    }

    private class GetText extends AsyncTask<String, Void, String> {

        private String str;

        @Override
        protected String doInBackground(String... str) {
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            this.str = str[0];
            createNotification();
            return null;
        }

        @Override
        protected void onProgressUpdate(Void... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            tv_show_string.setText(this.str);
        }
    }
}
