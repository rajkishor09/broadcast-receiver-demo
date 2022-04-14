package com.vickywords.mainapp;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void launchModule(View view) {
        Log.d(TAG, "launchModule: Click event");
        String permission = "com.vickywords.common.launchpermission";
        String actionName = "com.vickywords.submodulesdemo.receiver";
        try {
            final Intent intent = new Intent();
            intent.setAction(actionName);
            intent.putExtra("Key", "Value");
            intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
            intent.setComponent(
                    new ComponentName("com.vickywords.submodulesdemo", "com.vickywords.submodulesdemo.LaunchBroadcastReceiver"));
            sendBroadcast(intent, permission);
        } catch (Exception e) {
            e.printStackTrace();
            // not found, ignore this command
            Log.d(TAG, "Package: " + actionName + " was not found on this device.");
        }
    }

    public void launchPackage(View view){
        String packageName = "com.vickywords.submodulesdemo";
        String activityName = "com.vickywords.submodulesdemo.MainActivity";

        Intent intent = new Intent( Intent.ACTION_MAIN );
        intent.setClassName( packageName, activityName);
        getApplicationContext().startActivity( intent );
    }
}