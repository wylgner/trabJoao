package com.example.root.trabjoao;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);
        AlunoDbHelper mDbHelper = new AlunoDbHelper(getApplicationContext());
        //   Aluno a = new Aluno("Wylgner");
        //  mDbHelper.inserirAluno(a);
        List<Aluno> listaAlunos = mDbHelper.getAllAlunos();
        AlunoAdapter adapter = new AlunoAdapter(listaAlunos,getApplicationContext());
        ListView lv = (ListView) findViewById(R.id.listViewAlunos);
        lv.setAdapter(adapter);
    }


    public void listar(View v){
        AlunoDbHelper mDbHelper = new AlunoDbHelper(getApplicationContext());
        TextView edtnome = (TextView) findViewById(R.id.txt1);
        edtnome.setText("");
        int id=0;
        String nome="";
        SQLiteDatabase db = mDbHelper.getWritableDatabase();
        Cursor myCursor = db.rawQuery("SELECT id,nome FROM alunos", null);
        for( int i=0; i < myCursor.getCount(); i++){
            myCursor.moveToPosition(i);
            id=myCursor.getInt(myCursor.getColumnIndex("id"));
            nome=myCursor.getString(myCursor.getColumnIndex("nome"));
            // executar alguma acao com o registro
            edtnome.setText(edtnome.getText().toString() + "\n" + String.valueOf(id) +
                    "-" + nome);
        }// fim do for
        myCursor.close();
        db.close();
    }//


}
