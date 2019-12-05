package com.ibmr.baseapp.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.ibmr.baseapp.R;
import com.ibmr.baseapp.models.Pais;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewHolder> {

    private List<Pais> pais;

    public RecyclerViewAdapter(List<Pais> list) {
        this.pais = list;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View listItem = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.recyclerview_adapter_item, parent, false);

        return new RecyclerViewHolder(listItem);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, int position) {
        Pais d = pais.get(position);

        holder.nome.setText(d.getName());
        holder.imagem.setImageResource(d.getImagem());
    }

    @Override
    public int getItemCount() {
        return pais.size();
    }
}
