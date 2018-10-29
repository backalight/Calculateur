package com.capi.calculateur;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView ecran;

    double val1;
    double val2;
    boolean finSaisie;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecran = findViewById(R.id.tvResult);
        ecran.setText("0");
        finSaisie = false;
    }


    public void clear(View view) {
        val1 = 0;
        val2 = 0;
        ecran.setText("0");
    }

    public void getValue(View view) {
        if(ecran.getText().toString().equals("0")){
            ecran.setText("");
        }
        Button b = (Button) view;
        ecran.setText(ecran.getText().toString() + b.getText().toString());
    }

    public void result(View view) {
    }

    public void convEuro(View view) {
    }

    public void convDollar(View view) {
    }

    public void convLivres(View view) {
    }

    public void convBitcoin(View view) {
    }
}




