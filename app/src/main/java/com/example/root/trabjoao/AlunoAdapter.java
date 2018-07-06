package com.example.root.trabjoao;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;



public class AlunoAdapter extends BaseAdapter{

    List<Aluno> dados;
    LayoutInflater mInflater;
    AlunoAdapter(List<Aluno> alunos, Context context){
        dados = alunos;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return dados.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView == null){
            convertView = mInflater.inflate(R.layout.item_aluno, null);
        }
        Aluno a = dados.get(position);
        final TextView txtId = (TextView) convertView.findViewById(R.id.txt1);
        final TextView txtNome = (TextView) convertView.findViewById(R.id.txt2);
        txtId.setText(String.valueOf(a.getId()));
        txtNome.setText(String.valueOf(a.getNome()));
        return convertView;
    }
}