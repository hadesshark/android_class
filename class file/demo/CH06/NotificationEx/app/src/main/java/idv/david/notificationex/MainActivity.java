package idv.david.notificationex;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private final static int NOTIFICATION_ID = 100;
    private Button btnSend, btnCancel;
    private NotificationManager notificationManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //在Activity創建同時就取得NotificationManager物件
        notificationManager = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        findViews();
    }

    private void findViews() {
        btnSend = (Button) findViewById(R.id.btnSend);
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //資料放入bundle物件後再放進intent物件
                String title = getString(R.string.title);
                String content = getString(R.string.content);
                Intent intent = new Intent(MainActivity.this, NotiActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("title", title);
                bundle.putString("content", content);
                intent.putExtras(bundle);
                /*
                   Intent指定好要幹嘛後，就去做了，如startActivity(intent);
                   而PendingIntent則是先把某個Intent包好，以後再去執行Intent要幹嘛
                 */
                PendingIntent pendingIntent = PendingIntent.getActivity(MainActivity.this
                        , 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);

                Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);

                Notification notification = new Notification.Builder(MainActivity.this)
                                //狀態列的文字 (Android 5.0以後已不再顯示)
                        .setTicker(getString(R.string.ticker))
                                //訊息面板的標題
                        .setContentTitle(title)
                                //訊息面板的內容文字
                        .setContentText(content)
                                //訊息的圖示
                        .setSmallIcon(R.drawable.ic_secret_notification)
                                //點擊後會自動移除狀態列上的通知訊息
                        .setAutoCancel(true)
                                //等使用者點了之後才會開啟指定的Activity
                        .setContentIntent(pendingIntent)
                                //加入聲音
                        .setSound(soundUri)
                        .setPriority(Notification.PRIORITY_MAX)
                                //加入狀態列下拉後的進一步操作
                        .addAction(R.drawable.ic_secret_notification, "View", pendingIntent)
                        .addAction(0, "Remind", pendingIntent)
                        .build();
                //呼叫notify()送出通知訊息
                notificationManager.notify(NOTIFICATION_ID, notification);


            }
        });

        btnCancel = (Button) findViewById(R.id.btnCancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //呼叫cancel()並給予指定的notification ID即可取消
                notificationManager.cancel(NOTIFICATION_ID);
            }
        });

    }
}
