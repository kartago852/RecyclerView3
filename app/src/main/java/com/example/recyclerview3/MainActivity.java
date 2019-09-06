package com.example.recyclerview3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<String> listadatos;
    Button mbtncrearcriterios;
    int i=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );
        //
        mbtncrearcriterios = findViewById( R.id.mBtnCrearCriterios );
        recyclerView = findViewById( R.id.recycler_view );

        LinearLayoutManager llm = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));


        // Lineas divisorias
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,llm.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);
        listadatos = new ArrayList<String>();


        mbtncrearcriterios.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    mCrearCriterio();

            }
        } );


    }

        public void mCrearCriterio(){

            listadatos.add(""+i++);
            AdapterCri adapter = new AdapterCri(listadatos);
            recyclerView.setAdapter(adapter);
        }
}
