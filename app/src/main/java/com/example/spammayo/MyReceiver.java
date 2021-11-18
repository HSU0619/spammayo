package com.example.spammayo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle bundle = intent.getExtras();
        SmsMessage meg = parseMeg(bundle);
    }

    private SmsMessage parseMeg(Bundle bundle) {
        Object obj = (Object)bundle.get("pdus");
        SmsMessage meg = null;

        if(obj != null) {
            if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                String format = bundle.getString("format");
                meg = SmsMessage.createFromPdu((byte[]) obj, format);
            } else {
                meg = SmsMessage.createFromPdu((byte[]) obj);
            }
        }

        return meg;
    }

}