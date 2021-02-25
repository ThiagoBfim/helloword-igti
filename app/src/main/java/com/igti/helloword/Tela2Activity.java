package com.igti.helloword;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class Tela2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tela2_activity);
        Toolbar toolbar = findViewById(R.id.toolbar);
        ImageView imageView = findViewById(R.id.imageView2);
        setSupportActionBar(toolbar);

        TextView textView = findViewById(R.id.textView3);
        textView.setText(getMembersName());

        findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        Picasso.get()
                .load("https://merriam-webster.com/assets/mw/images/gallery/gal-wap-slideshow-slide/new-scrabble-words-2018-beatdown-5657-7691acd0ad774ceb507062ab70f8a346@1x.jpg")
                .resize(250,250).noFade().into(imageView);
    }

    private String getMembersName() {
        ArrayList<String> members = getIntent().getStringArrayListExtra("GROUP_MEMBERS");
        StringBuffer membersString = new StringBuffer();
        for (String name : members) {
            membersString.append(name + "\n");
        }
        return membersString.toString();
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