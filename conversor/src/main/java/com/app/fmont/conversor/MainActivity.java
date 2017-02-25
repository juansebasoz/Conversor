package com.app.fmont.conversor;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

import Logica.Conversor;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private EditText txtNumero;
    private Spinner spnOpciones_1;
    private Spinner spnOpciones_2;
    private TextView txtResultado;
    private Button btnN0, btnN1, btnN2, btnN3, btnN4, btnN5, btnN6, btnN7,
                   btnN8, btnN9, btnA, btnB, btnC, btnD, btnE, btnF, btnDel,
                   btnAC;

    private int opcion, opcion1, opcion2, aux;
    private Conversor conversor = new Conversor();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtNumero = (EditText) findViewById(R.id.txtNumero);
        txtNumero.setInputType(InputType.TYPE_NULL);

        spnOpciones_1 = (Spinner) findViewById(R.id.spnOpciones_1);
        List lista = new ArrayList();
        lista.add("Binario");
        lista.add("Octal");
        lista.add("Decimal");
        lista.add("Hexadecimal");
        ArrayAdapter adaptador = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lista);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpciones_1.setAdapter(adaptador);

        spnOpciones_1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                aux = opcion1;
                String auxiliar = txtNumero.getText().toString();
               opcion1 = spnOpciones_1.getSelectedItemPosition();
                if(opcion1 == 0){
                    binario();
                    txtNumero.setText(conversor.opciones(auxiliar,opciones(aux,3)));
                }else if(opcion1 == 1){
                    octal();
                    txtNumero.setText(conversor.opciones(auxiliar,opciones(aux,2)));
                }else if(opcion1 == 2){
                    decimal();
                    txtNumero.setText(conversor.opciones(auxiliar,opciones(aux,1)));
                }else if(opcion1 == 3){
                    hexadecimal();
                    txtNumero.setText(conversor.opciones(auxiliar,opciones(aux,0)));
                }
                opcion = opciones(opcion1,opcion2);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spnOpciones_2 = (Spinner) findViewById(R.id.spnOpciones_2);
        List lista1 = new ArrayList();
        lista1.add("Hexadecimal");
        lista1.add("Decimal");
        lista1.add("Octal");
        lista1.add("Binario");
        ArrayAdapter adaptador1 = new ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, lista1);
        adaptador1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnOpciones_2.setAdapter(adaptador1);

        spnOpciones_2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                opcion2 = spnOpciones_2.getSelectedItemPosition();
                opcion = opciones(opcion1,opcion2);
                convertir();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        txtResultado.setTextIsSelectable(true);

        btnN0 = (Button) findViewById(R.id.btnN0);
        btnN0.setOnClickListener(this);
        btnN1 = (Button) findViewById(R.id.btnN1);
        btnN1.setOnClickListener(this);
        btnN2 = (Button) findViewById(R.id.btnN2);
        btnN2.setOnClickListener(this);
        btnN3 = (Button) findViewById(R.id.btnN3);
        btnN3.setOnClickListener(this);
        btnN4 = (Button) findViewById(R.id.btnN4);
        btnN4.setOnClickListener(this);
        btnN5 = (Button) findViewById(R.id.btnN5);
        btnN5.setOnClickListener(this);
        btnN6 = (Button) findViewById(R.id.btnN6);
        btnN6.setOnClickListener(this);
        btnN7 = (Button) findViewById(R.id.btnN7);
        btnN7.setOnClickListener(this);
        btnN8 = (Button) findViewById(R.id.btnN8);
        btnN8.setOnClickListener(this);
        btnN9 = (Button) findViewById(R.id.btnN9);
        btnN9.setOnClickListener(this);

        btnA = (Button) findViewById(R.id.btnA);
        btnA.setOnClickListener(this);
        btnB = (Button) findViewById(R.id.btnB);
        btnB.setOnClickListener(this);
        btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(this);
        btnD = (Button) findViewById(R.id.btnD);
        btnD.setOnClickListener(this);
        btnE = (Button) findViewById(R.id.btnE);
        btnE.setOnClickListener(this);
        btnF = (Button) findViewById(R.id.btnF);
        btnF.setOnClickListener(this);

        btnAC = (Button) findViewById(R.id.btnAC);
        btnAC.setOnClickListener(this);
        btnDel = (Button) findViewById(R.id.btnDel);
        btnDel.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){

////////////////////////////////////////////////////////////
            case R.id.btnN0:
                txtNumero.append("0");
                convertir();
                break;
            case R.id.btnN1:
                txtNumero.append("1");
                convertir();
                break;
            case R.id.btnN2:
                txtNumero.append("2");
                convertir();
                break;
            case R.id.btnN3:
                txtNumero.append("3");
                convertir();
                break;
            case R.id.btnN4:
                txtNumero.append("4");
                convertir();
                break;
            case R.id.btnN5:
                txtNumero.append("5");
                convertir();
                break;
            case R.id.btnN6:
                txtNumero.append("6");
                convertir();
                break;
            case R.id.btnN7:
                txtNumero.append("7");
                convertir();
                break;
            case R.id.btnN8:
                txtNumero.append("8");
                convertir();
                break;
            case R.id.btnN9:
                txtNumero.append("9");
                convertir();
                break;
////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
            case R.id.btnA:
                txtNumero.append("A");
                convertir();
                break;
            case R.id.btnB:
                txtNumero.append("B");
                convertir();
                break;
            case R.id.btnC:
                txtNumero.append("C");
                convertir();
                break;
            case R.id.btnD:
                txtNumero.append("D");
                convertir();
                break;
            case R.id.btnE:
                txtNumero.append("E");
                convertir();
                break;
            case R.id.btnF:
                txtNumero.append("F");
                convertir();
                break;
////////////////////////////////////////////////////////////

////////////////////////////////////////////////////////////
            case R.id.btnDel:
                int tam = txtNumero.length();
                if(tam != 0) {
                    String texto = txtNumero.getText().toString().substring(0, tam - 1);
                    txtNumero.setText(texto);
                    if(tam >= 2)
                    convertir();
                    else if(tam <= 1)
                        txtResultado.setText("");
                }
                break;

            case R.id.btnAC:
                txtNumero.setText("");
                txtResultado.setText("");
                break;
////////////////////////////////////////////////////////////
        }
        }

    private void binario(){
        letras(false);

        btnN2.setEnabled(false);
        btnN3.setEnabled(false);
        btnN4.setEnabled(false);
        btnN5.setEnabled(false);
        btnN6.setEnabled(false);
        btnN7.setEnabled(false);
        btnN8.setEnabled(false);
        btnN9.setEnabled(false);
    }

    private void octal(){
        letras(false);

        btnN2.setEnabled(true);
        btnN3.setEnabled(true);
        btnN4.setEnabled(true);
        btnN5.setEnabled(true);
        btnN6.setEnabled(true);
        btnN7.setEnabled(true);
        btnN8.setEnabled(false);
        btnN9.setEnabled(false);
    }

    private void decimal(){
        letras(false);

        btnN2.setEnabled(true);
        btnN3.setEnabled(true);
        btnN4.setEnabled(true);
        btnN5.setEnabled(true);
        btnN6.setEnabled(true);
        btnN7.setEnabled(true);
        btnN8.setEnabled(true);
        btnN9.setEnabled(true);
    }

    private void hexadecimal(){
        letras(true);

        btnN2.setEnabled(true);
        btnN3.setEnabled(true);
        btnN4.setEnabled(true);
        btnN5.setEnabled(true);
        btnN6.setEnabled(true);
        btnN7.setEnabled(true);
        btnN8.setEnabled(true);
        btnN9.setEnabled(true);
    }

    private void letras(boolean estado){
        btnA.setEnabled(estado);
        btnB.setEnabled(estado);
        btnC.setEnabled(estado);
        btnD.setEnabled(estado);
        btnE.setEnabled(estado);
        btnF.setEnabled(estado);
    }

    private int opciones(int opcion1, int opcion2) {

        ///Binario/////////////////////////////////
        if(opcion1 == 0 && opcion2 == 0) {
            return 1;
        }else if(opcion1 == 0 && opcion2 == 1) {
            return 2;
        }else if(opcion1 == 0 && opcion2 == 2) {
            return 3;
        }
        /////////////////////////////////////////

        ///Octal/////////////////////////////////
        if(opcion1 == 1 && opcion2 == 0){
            return 4;
        }else if(opcion1 == 1 && opcion2 == 1){
            return 5;
        }else if(opcion1 == 1 && opcion2 == 3){
            return 6;
        }
        /////////////////////////////////////////

        ///Decimal///////////////////////////////
        if(opcion1 == 2 && opcion2 == 0){
            return 7;
        }else if(opcion1 == 2 && opcion2 == 2){
            return 8;
        }else if(opcion1 == 2 && opcion2 == 3){
            return 9;
        }
        /////////////////////////////////////////

        ///Hexadecimal///////////////////////////
        if(opcion1 == 3 && opcion2 == 1){
            return 10;
        }else if(opcion1 == 3 && opcion2 == 2){
            return 11;
        }else if(opcion1 == 3 && opcion2 == 3){
            return 12;
        }
        /////////////////////////////////////////

        /////Casos que no se cumplen/////////////
        if(opcion1 == 0 && opcion2 == 3) {
            return -1;
        }else if(opcion1 == 1 && opcion2 == 2) {
            return -1;
        }else if(opcion1 == 2 && opcion2 == 1) {
            return -1;
        }else if(opcion1 == 3 && opcion2 == 0) {
            return -1;
        }
        /////////////////////////////////////////

        return 0;
    }

    private void convertir(){
        if(opcion1 == 0  && txtNumero.length() < 64){
            txtResultado.setText(conversor.opciones(txtNumero.getText().toString(), opcion));
        }else if(opcion1 == 1 && txtNumero.length() < 21){
            txtResultado.setText(conversor.opciones(txtNumero.getText().toString(), opcion));
        }else if(opcion1 == 2 && txtNumero.length() < 19){
            txtResultado.setText(conversor.opciones(txtNumero.getText().toString(), opcion));
        }else if(opcion1 == 3 && txtNumero.length() < 16){
            txtResultado.setText(conversor.opciones(txtNumero.getText().toString(), opcion));
        }else {
            Toast.makeText(MainActivity.this,"Rebaso el Limite Maximo",Toast.LENGTH_SHORT).show();
        }
        if(opcion == -1)
            txtResultado.setText(txtNumero.getText());
    }

}