package com.example.root.trabjoao;

import android.app.Activity;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void startCadastroActivity(View view) {

        Intent secondActivity = new Intent(this, ActivityCadastro.class);
        startActivity(secondActivity);
    }
    public void startSharedActivity(View view) {

        Intent secondActivity = new Intent(this, SharePreferencesActivity.class);
        startActivity(secondActivity);
    }
    public void startSobreActivity(View view) {

        Intent secondActivity = new Intent(this, SobreActivity.class);
        startActivity(secondActivity);
    }
    public void startWebViewActivity(View view) {

        Intent secondActivity = new Intent(this, WebViewActivity.class);
        startActivity(secondActivity);
    }
    public void startListarActivity(View view) {

        Intent secondActivity = new Intent(this, ListViewActivity.class);
        startActivity(secondActivity);
    }




}
