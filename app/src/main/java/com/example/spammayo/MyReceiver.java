package com.example.spammayo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.telephony.SmsMessage;
import android.util.Log;

public class MyReceiver extends BroadcastReceiver {

    private static final String SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED";
    private static final String TAG = "SmsReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {

        if(intent.getAction().equals(SMS_RECEIVED)) {
            Log.d(TAG, "onReceiver() 호출");
            Bundle bundle = intent.getExtras();
            SmsMessage meg = parseMeg(bundle);

            if(meg != null) {
                String contents = meg.getMessageBody().toString();

                Log.d(TAG, "contents" + contents);
            }

        }

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