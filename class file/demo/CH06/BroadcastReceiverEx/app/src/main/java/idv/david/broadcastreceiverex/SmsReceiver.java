package idv.david.broadcastreceiverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

import java.text.DateFormat;
import java.util.Date;

public class SmsReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String smsContent = "";
        String sender = "";
        Date date = null;
        Bundle bundle = intent.getExtras();

        if (bundle != null) {
            Object[] pdus = (Object[]) bundle.get("pdus");
            SmsMessage[] smsMessages = new SmsMessage[pdus.length];
            for (int i = 0; i < smsMessages.length; i++) {
                if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    String format = bundle.getString("format");
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i], format);
                } else {
                    smsMessages[i] = SmsMessage.createFromPdu((byte[]) pdus[i]);
                }
                smsContent += smsMessages[i].getDisplayMessageBody();
            }
            sender = smsMessages[0].getDisplayOriginatingAddress();
            date = new Date(smsMessages[0].getTimestampMillis());
        }

        Intent i = new Intent(context, MainActivity.class);
        Bundle b = new Bundle();
        b.putString("type", "sms");
        b.putString("sender", sender);
        b.putString("smsContent", smsContent);
        //將Date物件轉成String資料類型
        DateFormat df = DateFormat.getInstance();
        String strDate = df.format(date);
        b.putString("date", strDate);
        i.putExtras(b);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);

    }
}
