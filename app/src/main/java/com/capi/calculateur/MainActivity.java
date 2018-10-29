package com.capi.calculateur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import net.sourceforge.jeval.EvaluationException;
import net.sourceforge.jeval.Evaluator;

public class MainActivity extends AppCompatActivity {
    TextView ecran;
    RadioButton rbEuro,rbDollar,rbLivres,rbBitcoin;
    double euro,livres,dollar,bitcoin;

    boolean finCalcul;
    int choixDevise;
    double tauxPrec=1;
    double valuePrec=1;
    double deg=1;
    double rad=0.017453;
    double gon=1.111111;
    double txEur=1;
    double txUsd=1.184;
    double txGbp=0.88;
    double txBtc=0.0001;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecran = findViewById(R.id.tvResult);
        ecran.setText("0");
        finCalcul = false;
        rbEuro=findViewById(R.id.rbEuro);
        rbDollar=findViewById(R.id.rbdollar);
        rbLivres=findViewById(R.id.rbLivre);
        rbBitcoin=findViewById(R.id.rbBitcoin);
        rbEuro.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txEur=Double.parseDouble(ecran.getText().toString());

                return false;
            }
        });
        rbDollar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txUsd=Double.parseDouble(ecran.getText().toString());
                return false;
            }
        });
        rbLivres.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txGbp=Double.parseDouble(ecran.getText().toString());
                return false;
            }
        });
        rbBitcoin.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                txBtc=Double.parseDouble(ecran.getText().toString());
                return false;
            }
        });

    }


    public void clear(View view) {
       finCalcul=false;
        dollar=0;
        euro=0;
        livres=0;
        bitcoin=0;
        ecran.setText("0");
    }

    public void getValue(View view) {
        if(ecran.getText().toString().equals("0")||finCalcul==true){
            ecran.setText("");
            finCalcul=false;
        }
        Button b = (Button) view;
        ecran.setText(ecran.getText().toString() + b.getText().toString());
    }

    public void result(View view) throws EvaluationException {
        Evaluator eval = new Evaluator();
          ecran.setText( eval.evaluate(ecran.getText().toString()));
          finCalcul=true;




    }

    public void convEuro(View view) {


           convDevise(txEur);

       }

    public void convDollar(View view) {
        convDevise(txUsd);

    }

    public void convLivres(View view) {
        convDevise(txGbp);
    }

    public void convBitcoin(View view) {
     convDevise(txBtc);
    }

    public void convDevise(double taux){

        double conversion = Double.parseDouble(ecran.getText().toString());
        double calcul= conversion/tauxPrec*taux;
        ecran.setText(String.valueOf(calcul));
        tauxPrec=taux;
    }


    public void toDeg(View view) {
        convAngle(deg);
    }

    public void toRad(View view) {
        convAngle(rad);
    }

    public void toGrade(View view) {
        convAngle(gon);
    }

    public void convAngle(double valeur){
        double val= Double.parseDouble(ecran.getText().toString());
        double valFinal=val/valeur*valuePrec;
        ecran.setText(String.valueOf(valFinal));
        valuePrec=valeur;

    }
}





