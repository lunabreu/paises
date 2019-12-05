package com.ibmr.baseapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import com.ibmr.baseapp.models.Pais;
import com.ibmr.baseapp.utils.RecyclerViewAdapter;
import com.ibmr.baseapp.utils.RecyclerViewOnItemTouchListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pais> pais = new ArrayList<Pais>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        this.insertData();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        recyclerView.setAdapter(new RecyclerViewAdapter(pais));

        recyclerView.addOnItemTouchListener(
                new RecyclerViewOnItemTouchListener(
                        getApplicationContext(),
                        recyclerView,
                        new RecyclerViewOnItemTouchListener.OnItemClickListener() {

                            @Override
                            public void onItemClick(View view, int position) {
                                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                                intent.putExtra("nome", pais.get(position).getName());
                                intent.putExtra("imagem", pais.get(position).getImagem());


                                startActivity(intent);
                            }

                            @Override
                            public void onLongItemClick(View view, int position) {

                            }

                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                            }
                        }
                )
        );
    }



    public void insertData() {
       pais.add(new Pais("Canadá" , R.drawable.aaaaaaa) );
        pais.add(new Pais("Aruba" , R.drawable.bb));
        pais.add(new Pais("Curação", R.drawable.cc));
        pais.add(new Pais("Espanha", R.drawable.dd));
        pais.add(new Pais("França", R.drawable.ee));


    }
}
