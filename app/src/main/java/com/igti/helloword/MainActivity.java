package com.igti.helloword;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        registerBroadcast();

        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), Tela2Activity.class);
                startActivity(intent);
            }
        });
    }

    private void registerBroadcast() {
        BroadcastReceiver br = new BatteryBroadcastReceiver();

        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_LOW);
        filter.addAction(Intent.ACTION_BATTERY_LOW);
        this.registerReceiver(br, filter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("STATE", "Start");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d("STATE", "Restart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("STATE", "Resume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("STATE", "Pause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("STATE", "Stop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("STATE", "Destroy");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}