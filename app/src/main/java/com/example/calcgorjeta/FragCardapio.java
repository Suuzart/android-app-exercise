package com.example.calcgorjeta;

import android.app.Dialog;
import android.os.Bundle;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Objects;


public class FragCardapio extends Fragment {

    ImageButton btt_p1, btt_p2, btt_p3, btt_p4, btt_p5, btt_p6, btt_p7, bm;

    Dialog prato_pop;
    TextView p_nome, p_desc;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View vw = inflater.inflate(R.layout.fragment_frag_cardapio, container, false);

        bm = vw.findViewById(R.id.abre_menuc);

        bm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((PagPrincipal) requireActivity()).abreMenu();
            }
        });

        prato_pop = new Dialog((FragCardapio.this).requireContext());
        prato_pop.setContentView(R.layout.prato_popup);
        Objects.requireNonNull(prato_pop.getWindow()).setLayout(600, ViewGroup.LayoutParams.WRAP_CONTENT);
        prato_pop.getWindow().setBackgroundDrawable(ContextCompat.getDrawable((FragCardapio.this).requireContext(),R.drawable.pr_pop_bg));
        prato_pop.setCancelable(true);

        p_nome = prato_pop.findViewById(R.id.pNome);
        p_desc = prato_pop.findViewById(R.id.pDesc);

        //Prato 1
        btt_p1 = vw.findViewById(R.id.bttC1);

        btt_p1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Criançada");
                p_desc.setText("100G de Blend bovino, pão de brioche, queijo prato e maionese caseira da casa");
                prato_pop.show();
            }
        });

        //Prato 2
        btt_p2 = vw.findViewById(R.id.bttC2);

        btt_p2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Arrasa dieta");
                p_desc.setText("160g de Blend bovino, linguiça calabresa, tomate frito, Bacon, queijo prato, maionese de alho, pão australiano tostado na manteiga");
                prato_pop.show();
            }
        });

        //Prato 3
        btt_p3 = vw.findViewById(R.id.bttC3);

        btt_p3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Porcalhão");
                p_desc.setText("160 G de blend suíno, queijo provolone, crispy de couve, pão brioche tostado na manteiga e molho barbecue.");
                prato_pop.show();
            }
        });

        //Prato 4
        btt_p4 = vw.findViewById(R.id.bttC4);

        btt_p4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Fritas");
                p_desc.setText("Batatas fritas sequinhas");
                prato_pop.show();
            }
        });

        //Prato 5
        btt_p5 = vw.findViewById(R.id.bttC5);

        btt_p5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Fritas da casa");
                p_desc.setText("Batatas fritas com cheddar cremoso e bacon crispy");
                prato_pop.show();
            }
        });

        //Prato 6
        btt_p6 = vw.findViewById(R.id.bttC6);

        btt_p6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Suco de polpa   400ml");
                p_desc.setText("Disponível hoje nos sabores: Abacaxi, Melancia, Morango e Laranja");
                prato_pop.show();
            }
        });

        //Prato 7
        btt_p7 = vw.findViewById(R.id.bttC7);

        btt_p7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                p_nome.setText("Refrigerante   350ml");
                p_desc.setText("Disponíveis: coca-cola, pepsi, sprite e fanta laranja");
                prato_pop.show();
            }
        });
        return vw;

    }

}