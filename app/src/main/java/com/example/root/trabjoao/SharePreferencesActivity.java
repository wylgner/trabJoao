package com.example.root.trabjoao;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;

public class SharePreferencesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share_preferences);
        SharedPreferences pref = getSharedPreferences("IFTM", MODE_PRIVATE);
        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        int radiobOpc = pref.getInt("radiob",R.id.radio1);
        rg.check(radiobOpc);
        rg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //Verifica qual RB foi selecionado
                ConstraintLayout ll = (ConstraintLayout)  findViewById(R.id.share);
                if(checkedId == R.id.radio0) {
                    ll.setBackgroundColor(Color.WHITE);
                } else if(checkedId == R.id.radio1) {

                    ll.setBackgroundColor(Color.BLUE);
                } else if(checkedId == R.id.radio2) {

                    ll.setBackgroundColor(Color.YELLOW);
                }
            }

        });




        Boolean marcado = pref.getBoolean("nomeParametroBoolean",false);




        String nomeOpc = pref.getString("nome","");
        Boolean checkOpc = pref.getBoolean("check",true);
        final int seekbOpc = pref.getInt("seekb",25);




        EditText txt1 = (EditText) findViewById(R.id.editText1);
        txt1.setText(nomeOpc);

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        cb1.setChecked(checkOpc);

        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar1);
        sb1.setProgress(seekbOpc);





    }




    public void salvar(View v) {
        SharedPreferences pref = getSharedPreferences("IFTM", 0);
        SharedPreferences.Editor editor = pref.edit();

        EditText txt1 = (EditText) findViewById(R.id.editText1);
        String nomeopc = txt1.getText().toString();
        editor.putString("nome", nomeopc);

        CheckBox cb1 = (CheckBox) findViewById(R.id.checkBox1);
        Boolean checkopc = cb1.isChecked();
        editor.putBoolean("check", checkopc);

        SeekBar sb1 = (SeekBar) findViewById(R.id.seekBar1);
        int seekbopc = sb1.getProgress();
        editor.putInt("seekb", seekbopc);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
        int radiobopc = rg.getCheckedRadioButtonId();
        editor.putInt("radiob", radiobopc);

        editor.putInt("radiob", radiobopc);
        editor.commit();

        AlertDialog.Builder alertaMsg = new AlertDialog.Builder(this);
        alertaMsg.setTitle("Salvar Configurações");
        alertaMsg.setMessage("Operação Realizada com Sucesso!");
        alertaMsg.setIcon(R.drawable.ok);
        alertaMsg.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertaMsg.show();
        notificar(v);


    }
    public void notificar(View v){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification).setContentTitle("Preferências salvas!")
                .setContentText("Suas preferências foram salvas com sucesso")
                .setDefaults(Notification.DEFAULT_SOUND).setDefaults(Notification.DEFAULT_VIBRATE);
        Intent resultIntent = new Intent(this, MainActivity.class);
        PendingIntent resultPendingIntent = PendingIntent.getActivity(this, 0,
                resultIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        int nNotificationId = 001;
        NotificationManager mNotifyMgr = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.notify(nNotificationId, mBuilder.build());
    }

    public void cancelar(View v){
        int nNotificationId = 001;
        NotificationManager mNotifyMgr =
                (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        mNotifyMgr.cancel(nNotificationId);
    }

}
