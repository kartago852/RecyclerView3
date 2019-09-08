package com.example.recyclerview3;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class AdapterCri extends RecyclerView.Adapter<AdapterCri.Viewholder>{

    ArrayList<Criterios> listadatos;
    private DatabaseReference mDatabase;
    Button mbtningresarcriterios;
    EditText mformcriterio;
    int x=0;

    public AdapterCri(ArrayList<Criterios> listadatos) {
        this.listadatos = listadatos;
    }



    @Override
    public Viewholder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_cri,null,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder(final AdapterCri.Viewholder viewholder, int position) {
        viewholder.mformcriterio.setText( listadatos.get( position ).getTexto() );
        viewholder.mbtningresarcriterios.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDatabase.child( "Criterios" ).child( "Criterios N°"+ x++ ).child( "texto" ).setValue((viewholder.mformcriterio.getText().toString().trim()) );
                viewholder.mformcriterio.setEnabled( false );
                viewholder.mbtningresarcriterios.setEnabled( false );

            }
        } );
    }

    @Override
    public int getItemCount() {
        return listadatos.size();
    }

    class Viewholder extends RecyclerView.ViewHolder{

            Button mbtningresarcriterios;
            EditText mformcriterio;
            int x=0;

        public Viewholder(final View itemView){
            super(itemView);
            mbtningresarcriterios = itemView.findViewById( R.id.mBtnIngresarCriterios );
            mformcriterio = itemView.findViewById( R.id.mformcriterio );

            mDatabase = FirebaseDatabase.getInstance().getReference();



        }

    }
}
