package com.vickywords.submodulesdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class LaunchBroadcastReceiver extends BroadcastReceiver {
    private static final String TAG = LaunchBroadcastReceiver.class.getSimpleName();
    private final String INTENT_ACTION = "com.vickywords.submodulesdemo.receiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d(TAG, "onReceive: " + intent.getAction());
        if (INTENT_ACTION.equals(intent.getAction())) {
            Intent startIntent = new Intent(context, MainActivity.class);

            startIntent.setFlags(
                    Intent.FLAG_ACTIVITY_REORDER_TO_FRONT |
                            Intent.FLAG_ACTIVITY_NEW_TASK |
                            Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED
            );
            context.startActivity(startIntent);
        }
    }
}
