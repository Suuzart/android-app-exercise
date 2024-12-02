package com.example.calcgorjeta;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import java.text.DecimalFormat;
import java.util.Objects;


public class PagComanda extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    Button lan1, lan2, lan3, acom1, acom2, beb1, beb2, gorj, encerrar, r_confirmar, con, can;
    Dialog recibo, sair;
    TextView pedido_final, gorjeta_final, valor_final;

    private int ql1 = 0, ql2 = 0, ql3 = 0, qa1 = 0, qa2 = 0, qb1 = 0, qb2 = 0;
    double acum, mult = 0, gorj_var;
    String multTxt;

    DecimalFormat df = new DecimalFormat("0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page_comanda);

        lan1 = findViewById(R.id.lan1);
        if(ql1 == 0)
            lan1.setVisibility(View.GONE);

        lan1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ql1 == 1){
                    lan1.setVisibility(View.GONE);
                    ql1 = ql1 - 1;
                    alteraText(lan1, getString(R.string.lanche_1), getString(R.string.pl_1), ql1, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(ql1 >= 1){
                    ql1 = ql1 - 1;
                    alteraText(lan1, getString(R.string.lanche_1), getString(R.string.pl_1), ql1, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        lan2 = findViewById(R.id.lan2);
        if(ql2 == 0)
            lan2.setVisibility(View.GONE);

        lan2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ql2 == 1){
                    lan2.setVisibility(View.GONE);
                    ql2 = ql2 - 1;
                    alteraText(lan2, getString(R.string.lanche_2), getString(R.string.pl_2), ql2, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(ql2 >= 1){
                    ql2 = ql2 - 1;
                    alteraText(lan2, getString(R.string.lanche_2), getString(R.string.pl_2), ql2, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        lan3 = findViewById(R.id.lan3);
        if(ql3 == 0)
            lan3.setVisibility(View.GONE);

        lan3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ql3 == 1){
                    lan3.setVisibility(View.GONE);
                    ql3 = ql3 - 1;
                    alteraText(lan3, getString(R.string.lanche_3), getString(R.string.pl_3), ql3, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(ql3 >= 1){
                    ql3 = ql3 - 1;
                    alteraText(lan3, getString(R.string.lanche_3), getString(R.string.pl_3), ql3, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        acom1 = findViewById(R.id.acom1);
        if(qa1 == 0)
            acom1.setVisibility(View.GONE);

        acom1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qa1 == 1){
                    acom1.setVisibility(View.GONE);
                    qa1 = qa1 - 1;
                    alteraText(acom1, getString(R.string.acompanhamento_1), getString(R.string.pa_1), qa1, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(qa1 >= 1){
                    qa1 = qa1 - 1;
                    alteraText(acom1, getString(R.string.acompanhamento_1), getString(R.string.pa_1), qa1, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        acom2 = findViewById(R.id.acom2);
        if(qa2 == 0)
            acom2.setVisibility(View.GONE);

        acom2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qa2 == 1){
                    acom2.setVisibility(View.GONE);
                    qa2 = qa2 - 1;
                    alteraText(acom2, getString(R.string.acompanhamento_2), getString(R.string.pa_2), qa2, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(qa2 >= 1){
                    qa2 = qa2 - 1;
                    alteraText(acom2, getString(R.string.acompanhamento_2), getString(R.string.pa_2), qa2, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        beb1 = findViewById(R.id.beb1);
        if(qb1 == 0)
            beb1.setVisibility(View.GONE);

        beb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qb1 == 1){
                    beb1.setVisibility(View.GONE);
                    qb1 = qb1 - 1;
                    alteraText(beb1, getString(R.string.bebida_1), getString(R.string.pb_1), qb1, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(qb1 >= 1){
                    qb1 = qb1 - 1;
                    alteraText(beb1, getString(R.string.bebida_1), getString(R.string.pb_1), qb1, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        beb2 = findViewById(R.id.beb2);
        if(qb2 == 0)
            beb2.setVisibility(View.GONE);

        beb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(qb2 == 1){
                    beb2.setVisibility(View.GONE);
                    qb2 = qb2 - 1;
                    alteraText(beb2, getString(R.string.bebida_2), getString(R.string.pb_2), qb2, 0);
                    alteraPorc(multTxt,mult);
                }
                else if(qb2 >= 1){
                    qb2 = qb2 - 1;
                    alteraText(beb2, getString(R.string.bebida_2), getString(R.string.pb_2), qb2, 0);
                    alteraPorc(multTxt,mult);
                }
            }
        });

        gorj = findViewById(R.id.Gorj);
        if(mult == 0)
            gorj.setVisibility(View.GONE);

        gorj.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gorj.setVisibility(View.GONE);
                mult = 0;
            }
        });

        TextView numero_m = findViewById(R.id.mNome);

        Bundle extras = getIntent().getExtras();
        if(extras != null) {
            int mesaN = extras.getInt("mesa");
            numero_m.setText("Mesa " + mesaN);
        }

        Button addP = findViewById(R.id.addPedido);
        addP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Popup(view);
            }
        });


        recibo = new Dialog(PagComanda.this);
        recibo.setContentView(R.layout.recibo_popup);
        Objects.requireNonNull(recibo.getWindow()).setLayout(600, ViewGroup.LayoutParams.WRAP_CONTENT);
        recibo.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.rec_pop_bg));
        recibo.setCancelable(true);

        pedido_final = recibo.findViewById(R.id.final_pedido);
        gorjeta_final = recibo.findViewById(R.id.final_gorj);
        valor_final = recibo.findViewById(R.id.a_pagar);

        r_confirmar = recibo.findViewById(R.id.confirmar);

        r_confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(PagComanda.this, "Pagamento confirmado", Toast.LENGTH_SHORT).show();
                recibo.dismiss();
                finish();
            }
        });

        encerrar = findViewById(R.id.bttEncerrar);

        encerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int tem_pedido = ql1 + ql2 + ql3 + qa1 + qa2 + qb1 + qb2;
                if(tem_pedido == 0)
                    finish();
                if (tem_pedido >= 1) {
                    rTexto();
                    recibo.show();
                }
            }
        });

        sair = new Dialog(PagComanda.this);
        sair.setContentView(R.layout.cancela_popup);
        Objects.requireNonNull(sair.getWindow()).setLayout(600, ViewGroup.LayoutParams.WRAP_CONTENT);
        sair.getWindow().setBackgroundDrawable(ContextCompat.getDrawable(this,R.drawable.log_pop_bg));
        sair.setCancelable(false);

        can = sair.findViewById(R.id.cancel_sair);
        con = sair.findViewById(R.id.confirm_sair);

        con.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sair.dismiss();
                finish();
            }
        });

        can.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sair.dismiss();
            }
        });

        OnBackPressedCallback volt = new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                int tem_pedido = ql1 + ql2 + ql3 + qa1 + qa2 + qb1 + qb2;
                if(tem_pedido != 0)
                    sair.show();
                else if(tem_pedido == 0)
                    finish();
            }
        };
        getOnBackPressedDispatcher().addCallback(this, volt);

    }

    public void Popup(View v){
        PopupMenu cardMenu = new PopupMenu(PagComanda.this, v);
        cardMenu.setOnMenuItemClickListener(PagComanda.this);
        cardMenu.inflate(R.menu.card_menu);
        cardMenu.show();
    }

    public void alteraText(Button prato, String nome, String preco, int qt, int mm){

        double pr = Double.parseDouble(preco);

        if(mm == 1){
            acum += pr;
            String txt = nome + "\n"+ qt +"\nR$ " + df.format(pr * qt);
            prato.setText(txt);
            prato.setVisibility(View.VISIBLE);
        }
        else if(mm == 0){
            if(qt >= 0) {
                acum -= pr;
                String txt = nome + "\n" + qt + "\nR$ " + df.format(pr * qt);
                prato.setText(txt);
            }
        }
        if(mm == 2){
            String txt = nome + "\n"+ qt +"\nR$ " + df.format(pr * qt);
            prato.setText(txt);
            prato.setVisibility(View.VISIBLE);
        }
    }

    public void alteraPorc(String numero,double porc){

        if(acum == 0){
            gorj.setVisibility(View.GONE);
        }
        if(mult == 0)
            gorj.setVisibility(View.GONE);
        else {
            gorj_var = acum * porc;
            String txt = "Gorjeta\n" + numero + "%\nTotal R$ " + df.format(gorj_var);
            gorj.setText(txt);
            gorj.setVisibility(View.VISIBLE);
        }
    }

    public void rTexto(){
        String txt = "Valor do pedido:\nR$ " + df.format(acum);
        pedido_final.setText(txt);

        if(gorj_var == 0){
            gorjeta_final.setVisibility(View.GONE);
        }
        else if(gorj_var > 0) {
            txt = "Valor da gorjeta (" + multTxt + "%):\nR$ " + df.format(gorj_var);
            gorjeta_final.setText(txt);
            gorjeta_final.setVisibility(View.VISIBLE);
        }

        txt = "R$ " + df.format(acum + gorj_var);
        valor_final.setText(txt);
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) {
        if (menuItem.getItemId() == R.id.l1){
            Toast.makeText(PagComanda.this, "Criançada", Toast.LENGTH_SHORT).show();
            if(lan1.getVisibility() == View.GONE)
                lan1.setVisibility(View.VISIBLE);

            if(lan1.getVisibility() == View.VISIBLE) {
                ql1++;
                alteraText(lan1, getString(R.string.lanche_1), getString(R.string.pl_1), ql1, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.l2){
            Toast.makeText(PagComanda.this, "Arrasa dieta", Toast.LENGTH_SHORT).show();
            if(lan2.getVisibility() == View.GONE)
                lan2.setVisibility(View.VISIBLE);

            if(lan2.getVisibility() == View.VISIBLE) {
                ql2++;
                alteraText(lan2, getString(R.string.lanche_2), getString(R.string.pl_2), ql2, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.l3){
            Toast.makeText(PagComanda.this, "Porcalhão", Toast.LENGTH_SHORT).show();
            if(lan3.getVisibility() == View.GONE)
                lan3.setVisibility(View.VISIBLE);

            if(lan3.getVisibility() == View.VISIBLE) {
                ql3++;
                alteraText(lan3, getString(R.string.lanche_3), getString(R.string.pl_3), ql3, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.a1){
            Toast.makeText(PagComanda.this, "Fritas", Toast.LENGTH_SHORT).show();
            if(acom1.getVisibility() == View.GONE)
                acom1.setVisibility(View.VISIBLE);

            if(acom1.getVisibility() == View.VISIBLE) {
                qa1++;
                alteraText(acom1, getString(R.string.acompanhamento_1), getString(R.string.pa_1), qa1, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.a2){
            Toast.makeText(PagComanda.this, "Fritas da casa", Toast.LENGTH_SHORT).show();
            if(acom2.getVisibility() == View.GONE)
                acom2.setVisibility(View.VISIBLE);

            if(acom2.getVisibility() == View.VISIBLE) {
                qa2++;
                alteraText(acom2, getString(R.string.acompanhamento_2), getString(R.string.pa_2), qa2, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.b1){
            Toast.makeText(PagComanda.this, "Suco de polpa", Toast.LENGTH_SHORT).show();
            if(beb1.getVisibility() == View.GONE)
                beb1.setVisibility(View.VISIBLE);

            if(beb1.getVisibility() == View.VISIBLE) {
                qb1++;
                alteraText(beb1, getString(R.string.bebida_1), getString(R.string.pb_1), qb1, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.b2){
            Toast.makeText(PagComanda.this, "Refrigerante", Toast.LENGTH_SHORT).show();
            if(beb2.getVisibility() == View.GONE)
                beb2.setVisibility(View.VISIBLE);

            if(beb2.getVisibility() == View.VISIBLE) {
                qb2++;
                alteraText(beb2, getString(R.string.bebida_2), getString(R.string.pb_2), qb2, 1);
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.g1){
            if(gorj.getVisibility() == View.GONE)
                gorj.setVisibility(View.VISIBLE);

            if(gorj.getVisibility() == View.VISIBLE) {
                multTxt = "5";
                mult = 0.05;
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.g2){
            if(gorj.getVisibility() == View.GONE)
                gorj.setVisibility(View.VISIBLE);

            if(gorj.getVisibility() == View.VISIBLE) {
                multTxt = "10";
                mult = 0.10;
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.g3){
            if(gorj.getVisibility() == View.GONE)
                gorj.setVisibility(View.VISIBLE);

            if(gorj.getVisibility() == View.VISIBLE) {
                multTxt = "15";
                mult = 0.15;
                alteraPorc(multTxt,mult);
            }
        }

        else if (menuItem.getItemId() == R.id.g4){
            if(gorj.getVisibility() == View.GONE)
                gorj.setVisibility(View.VISIBLE);

            if(gorj.getVisibility() == View.VISIBLE) {
                multTxt = "20";
                mult = 0.20;
                alteraPorc(multTxt,mult);
            }
        }

        return true;
    }
}
