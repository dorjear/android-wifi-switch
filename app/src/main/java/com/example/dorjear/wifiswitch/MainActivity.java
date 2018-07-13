package com.example.dorjear.wifiswitch;

import android.content.Context;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.example.dorjear.swapwifi.R;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    WifiReceiver wifiReceiver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        changeWifi(this,"\"xxbxxbbtpg\"","abcdefgh",true);


    }

    /**
     *
     * @param context
     * @param ssid  带引号的ssid "\"wifi_name\""
     * @param password  wifi 密码
     * @param fuzzyMatch    是否模糊匹配ssid
     */
    private void changeWifi(Context context, String ssid, String password, boolean fuzzyMatch) {
        WifiManager wifiManager = getWifiManager(context);
        List<WifiConfiguration> list = wifiManager.getConfiguredNetworks();
        for (WifiConfiguration wifiConfiguration : list) {
            String wifiSSID = wifiConfiguration.SSID;
            boolean ssidMatch = fuzzyMatch ? wifiSSID.toLowerCase().contains(ssid.toLowerCase()) : wifiSSID.equals(ssid);

            if (ssidMatch) {
                if (!TextUtils.isEmpty(password)) {
                    wifiConfiguration.preSharedKey = "\"" + password + "\"";
                }
                wifiManager.disconnect();
                wifiManager.enableNetwork(wifiConfiguration.networkId, true);
                wifiManager.reconnect();

                break;
            }
        }
    }

    private WifiManager getWifiManager(Context context) {
        WifiManager output = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        return output;
    }

    private void logCurrentWifi(Context context) {
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
        WifiInfo wifiInfo;

        wifiInfo = wifiManager.getConnectionInfo();
        if (wifiInfo.getSupplicantState() == SupplicantState.COMPLETED) {
            String ssid = wifiInfo.getSSID();
            Log.d("SSID1", ssid);
        }
    }
    public void toWifi1(View v){

        logCurrentWifi(this);
        changeWifi(this,"xxboptus",null,true);
        logCurrentWifi(this);
    }

    public void toWifi2(View v){
        logCurrentWifi(this);
        changeWifi(this,"U05-100456",null,true);
        logCurrentWifi(this);
    }

    public void toWifi3(View v){
        logCurrentWifi(this);
        changeWifi(this,"Urvesh","12345678",true);
        logCurrentWifi(this);
    }

    @Override
    public void onResume() {
        super.onResume();
//        IntentFilter intentFilter = new IntentFilter();
//        intentFilter.addAction(WifiManager.SUPPLICANT_CONNECTION_CHANGE_ACTION);
//        LocalBroadcastManager.getInstance(this).registerReceiver(wifiReceiver = new WifiReceiver(), intentFilter);
    }

    @Override
    public void onStop() {
        super.onStop();
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(wifiReceiver);
    }

}
