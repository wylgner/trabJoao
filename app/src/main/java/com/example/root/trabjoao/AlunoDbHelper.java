package com.example.root.trabjoao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.View;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class AlunoDbHelper extends SQLiteOpenHelper {
    private static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE alunos ( " +
                    " nome TEXT" + " ) ";
    private static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS alunos";
    // Incremente DATABASE_VERSION sempre que o esquema do banco de dados for alterado.
    public static final int DATABASE_VERSION = 1; // versão do banco
    public static final String DATABASE_NAME = "aluno.db"; // nome do arquivo
    public AlunoDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(SQL_CREATE_ENTRIES);
    }
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(SQL_DELETE_ENTRIES);
        onCreate(db);
    }
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        onUpgrade(db, oldVersion, newVersion);
    }
    List<Aluno> getAllAlunos(){
        List<Aluno> listaAlunos = new ArrayList<Aluno>();
        String selectQuery = "SELECT * FROM alunos";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery,null);
        //percorrer resultado adicionando na lista
        if(c.moveToFirst()){
            do{
                Aluno aluno =
                        new Aluno(
                                c.getInt(c.getColumnIndex("id")),
                                c.getString(c.getColumnIndex("nome")));
                listaAlunos.add(aluno);
            } while (c.moveToNext());
        }
        return listaAlunos;

    }

}