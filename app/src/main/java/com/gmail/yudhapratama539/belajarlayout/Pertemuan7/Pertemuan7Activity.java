package com.gmail.yudhapratama539.belajarlayout.Pertemuan7;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.gmail.yudhapratama539.belajarlayout.R;

public class Pertemuan7Activity extends AppCompatActivity {
    private TextView textViewBatrai, textViewStatus, textViewHealth, textViewJaringan;
    private ProgressBar progressBar;
    private BroadcastReceiver receiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pertemuan7);

        textViewBatrai=findViewById(R.id.tv_batrai);
        textViewStatus = findViewById(R.id.tv_charging);
        textViewHealth = findViewById(R.id.tv_health);
        textViewJaringan = findViewById(R.id.tv_jaringan);
        progressBar=findViewById(R.id.progress);

        receiver=new BatteryBroadcastReceiver();
    }

    public void playAudio(View view){
        Intent objIntent=new Intent(this, PlayAudio.class);
        startService(objIntent);
    }

    public void stopAudio(View view){
        Intent objIntent=new Intent(this, PlayAudio.class);
        stopService(objIntent);
    }

    @Override
    protected void onStart() {
        registerReceiver(receiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));
        super.onStart();
    }

    @Override
    protected void onStop() {
        unregisterReceiver(receiver);
        super.onStop();
    }

    private class BatteryBroadcastReceiver extends BroadcastReceiver {
        @SuppressLint("SetTextI18n")
        @Override
        public void onReceive(Context context, Intent intent) {
            //charge level
            int level=intent.getIntExtra(BatteryManager.EXTRA_LEVEL,0);

            //is charging
            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING ||
                    status == BatteryManager.BATTERY_STATUS_FULL;

            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;

            //health battrai
            int health = intent.getIntExtra(BatteryManager.EXTRA_HEALTH, -1);
            boolean isGood = health == BatteryManager.BATTERY_HEALTH_GOOD;
            boolean isCold = health == BatteryManager.BATTERY_HEALTH_COLD;
            boolean isDead = health == BatteryManager.BATTERY_HEALTH_DEAD;
            boolean isOverVoltage = health == BatteryManager.BATTERY_HEALTH_OVER_VOLTAGE;
            boolean isOverheat = health == BatteryManager.BATTERY_HEALTH_OVERHEAT;

            //status jaringan seluler
            ConnectivityManager cm =
                    (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);

            NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
            boolean isConnected = activeNetwork != null &&
                    activeNetwork.isConnectedOrConnecting();
            boolean isWiFi = activeNetwork.getType() == ConnectivityManager.TYPE_WIFI;

            Log.d("charging", "" + isCharging + ", " + usbCharge + ", " + acCharge);
            Log.d("health", "" + isGood + ", " + isCold + ", " + isDead + ", " + isOverVoltage + ", " + isOverheat);
            Log.d("jaringan", "" + isConnected +", " + isWiFi);

            if (isCharging)
                textViewStatus.setText("Yes");
            else
                textViewStatus.setText("No");

            if (isGood)
                textViewHealth.setText("Good");
            else if (isCold)
                textViewHealth.setText("Cold");
            else if (isDead)
                textViewHealth.setText("Dead");
            else if (isOverVoltage)
                textViewHealth.setText("Over Voltage");
            else if (isOverheat)
                textViewHealth.setText("Overheat");
            else
                textViewHealth.setText("Unknown");

            if (isConnected) {
                if (isWiFi)
                    textViewJaringan.setText("Connected, WiFi");
                else
                    textViewJaringan.setText("Connected");
            }
            else
                textViewJaringan.setText("Not Connected");

            textViewBatrai.setText("Battrai : "+level);
            progressBar.setProgress(level);
        }
    }
}
