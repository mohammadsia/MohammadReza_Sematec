package sematec.mohammad.com.mohammadreza_sematec;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class S08_BroadCast extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        Intent i = new Intent(context, S08.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(i);
    }
}
