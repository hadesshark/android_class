package idv.david.broadcastreceiverex;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.TelephonyManager;

public class PhoneReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String incomePhone = "";
        String phoneState = "";
        Bundle bundle = intent.getExtras();
        if (bundle != null) {
            phoneState = bundle.getString(TelephonyManager.EXTRA_STATE);
        }

        if (phoneState.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            incomePhone = bundle.getString(TelephonyManager.EXTRA_INCOMING_NUMBER);
            Intent i = new Intent(context, MainActivity.class);
            Bundle b = new Bundle();
            b.putString("type", "phone");
            b.putString("incomePhone", incomePhone);
            b.putString("phoneState", phoneState);
            i.putExtras(b);
            i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        }
    }
}
