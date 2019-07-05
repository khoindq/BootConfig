package com.example.khoi.bootconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    public void settingPermission() {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (!Settings.System.canWrite(getApplicationContext())) {
                Intent intent = new Intent(Settings.ACTION_MANAGE_WRITE_SETTINGS, Uri.parse("package:" + getPackageName()));
                startActivityForResult(intent, 200);

            }
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //  settingPermission();
        //Set up the adb connect  process
//        try {
//            Thread.sleep(1000);
//
//            Runtime.getRuntime().exec(new String[] {
//                    "sh", "-c", "setprop service.adb.tcp.port 5555"
//            });
//            Runtime.getRuntime().exec(new String[] {
//                    "sh", "-c", "stop adbd"
//            });
//            Runtime.getRuntime().exec(new String[] {
//                    "sh", "-c", "start adbd"
//            });
//        } catch (IOException e) {
//            // Log.d(TAG,"Can not erase memory");
//            e.printStackTrace();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

    }




}
