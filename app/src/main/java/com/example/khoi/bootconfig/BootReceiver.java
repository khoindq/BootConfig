package com.example.khoi.bootconfig;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.khoi.bootconfig.MainActivity;

import java.io.File;
import java.io.IOException;

public class BootReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        if (!Intent.ACTION_BOOT_COMPLETED.equals(intent.getAction())) return;

//        WifiApManager  wifiApManager = new WifiApManager(context);
//        if (wifiApManager.getWifiApState()==WIFI_AP_STATE.WIFI_AP_STATE_DISABLED) {
//            Log.d("here", "Wifi state  " + wifiApManager.getWifiApState()+ " . Enable AP now");
//             //wifiApManager.showWritePermissionSettings(true);
//
//            wifiApManager.setWifiApEnabled(null,true);
//        }
//        else
//        {
//            Log.d("here", "Wifi state  " + wifiApManager.getWifiApState()+ " . Do nothing");
//        }
//

        //Set up the adb connect  process
        try {
            Thread.sleep(1000);

            Runtime.getRuntime().exec(new String[] {
                    "sh", "-c", "setprop service.adb.tcp.port 5555"
            });
            Runtime.getRuntime().exec(new String[] {
                    "sh", "-c", "stop adbd"
            });
            Runtime.getRuntime().exec(new String[] {
                    "sh", "-c", "start adbd"
            });
        } catch (IOException e) {
           // Log.d(TAG,"Can not erase memory");
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


//        Intent intent = new Intent(Intent.ACTION_MAIN);
//        intent.addCategory(Intent.CATEGORY_HOME);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//        startActivity(intent);
    }




    /** Ensure readable and executable file if user forgot to do so. */
    @SuppressWarnings("ResultOfMethodCallIgnored")
    private static void ensureFileReadableAndExecutable(File file) {
        if (!file.canRead()) file.setReadable(true);
        if (!file.canExecute()) file.setExecutable(true);
    }


}
