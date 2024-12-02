package com.example.calcgorjeta;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import java.util.Objects;


public class FragMesas extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.fragment_frag_mesas, container, false);

        //SharedPreferences sp = FragMesas.this.requireActivity().getSharedPreferences("comanda", Context.MODE_PRIVATE);


        ImageButton b1, bm;

        b1 = vw.findViewById(R.id.bttM1);

        b1.setOnClickListener(
                v -> {
                    Intent i = new Intent((FragMesas.this).getContext(), PagComanda.class);
                    i.putExtra("mesa",1);
                    startActivity(i);
                }
        );

        bm = vw.findViewById(R.id.abre_menum);

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((PagPrincipal) requireActivity()).abreMenu();
            }
        });

        return vw;
    }
}