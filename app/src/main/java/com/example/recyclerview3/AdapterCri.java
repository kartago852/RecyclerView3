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

    ArrayList<String> listadatos;
    private DatabaseReference mDatabase;

    public AdapterCri(ArrayList<String> listadatos) {
        this.listadatos = listadatos;
    }



    @Override
    public Viewholder onCreateViewHolder( ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.fragment_cri,null,false);
        return new Viewholder(view);
    }

    @Override
    public void onBindViewHolder( AdapterCri.Viewholder viewholder, int position) {
        viewholder.asignarDatos(listadatos.get(position));
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

            mbtningresarcriterios.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    String item = mDatabase.child( "Criterio N°" + x++).getKey();
                    String item2 = mDatabase.push().getKey();
                    String criterio = mformcriterio.getText().toString();
                    //mDatabase.child( "Criterios" ).child( "Criterio N°"+ x++ ).child( "texto" ).setValue( criterio );

                    mDatabase.child( "Criterios" ).child( item  ).child( "texto" ).setValue( criterio );
                    mbtningresarcriterios.setEnabled( false );
                    mformcriterio.setEnabled( false );
                }
            } );

        }

        public void asignarDatos(String s){
            mbtningresarcriterios.setText(s);
            mformcriterio.setText(s);
        }
    }
}
