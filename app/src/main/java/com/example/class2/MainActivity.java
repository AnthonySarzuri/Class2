package com.example.class2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView txtMessage;
    private Button btnMostrar;
    private Button btnInvertir;
    private EditText etNombre,etCelular;

    private String Nombre;
    private int celular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializarvistas();
        //parametro de la funcion espera que le mandes tu logica desarrollada que quieres que se aplique al usuaruio que haga click
        btnMostrar.setOnClickListener(this);
        btnInvertir.setOnClickListener(this);
    }

    private void inicializarvistas() {
        //Inicializamos vistas y referenciamos nuestros componentes visuales diseñados con los atributos o variables que hemos creado
        txtMessage=findViewById(R.id.txtMessage);
        btnMostrar=findViewById(R.id.btnMostrar);
        btnInvertir=findViewById(R.id.btnInvertir);
        etNombre=findViewById(R.id.etNombre);
        etCelular=findViewById(R.id.etCelular);
    }
    private void obtenerValores(){
        Nombre=etNombre.getText().toString();
        String celularTexto=etCelular.getText().toString();
        celular=Integer.parseInt(celularTexto);
    }

    private void mostrarTexto(){

        txtMessage.setText("Bienvenido: "+this.Nombre+", tu celular es:  "+celular);
    }

    private void invertirNumero(){
        //invertir numero
        //12345->54321
        int resto=0,invertido=0;
        while(this.celular>0){
            resto=this.celular%10;
            invertido=invertido*10+resto;
            this.celular=this.celular/10;
        }
        txtMessage.setText("Invertido: "+invertido);
    }

    @Override
    public void onClick(View view) {
        //el parametro view es un objeto que recibe lA informacion del componente visual que el usuario a presionado en pantalla si presiona el boton invrtir view es igual a ese boton
        //y de ese boton u otra vista pueden obtener informacion como por ejemplo el atributo que los identifica como alf¿go unico
        obtenerValores();
        switch (view.getId()){
            case R.id.btnMostrar:
                mostrarTexto();
                break;
            case R.id.btnInvertir:
                invertirNumero();
                break;
        }
    }
}