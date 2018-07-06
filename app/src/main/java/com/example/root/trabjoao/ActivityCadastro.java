package com.example.root.trabjoao;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityCadastro extends AppCompatActivity {
    private SQLiteDatabase database;
    private AlunoDbHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
        helper = new AlunoDbHelper(this);
        database = helper.getWritableDatabase();
    }




    public void notificar(View v){
        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.notification).setContentTitle("Usuário pronto!")
                .setContentText("Seu usuário já está pronto em listar")
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
    public void adicionar(View v){
        notificar(v);
        AlunoDbHelper mDbHelper = new AlunoDbHelper(getApplicationContext());
        //obter o bd em modo de escrita
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        EditText edtnome = (EditText) findViewById(R.id.edtNome);
        String nome = edtnome.getText().toString();

        ContentValues values = new ContentValues();
        values.put("nome", nome);
        long newRowId = db.insert("alunos", null, values);
        AlertDialog.Builder alertaMsg = new AlertDialog.Builder(this);
        alertaMsg.setTitle("Salvar Configurações");
        alertaMsg.setMessage("Cadastro Realizado com Sucesso!");
        alertaMsg.setIcon(R.drawable.ok);
        alertaMsg.setNeutralButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        alertaMsg.show();

    }
}
