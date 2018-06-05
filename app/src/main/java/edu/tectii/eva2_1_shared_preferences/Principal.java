package edu.tectii.eva2_1_shared_preferences;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class Principal extends AppCompatActivity {
    EditText nombre, apellido, edad;

    SharedPreferences spMisDatos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        nombre = findViewById(R.id.nombre);
        apellido = findViewById(R.id.apellido);
        edad = findViewById(R.id.edad);
        //LEER NUESTRO SHAREPREFERENCE Y ACTUALIZAR LA INTERFAZ
        //Se guarda un archivo que se va a llamr mis_datos onde estarán almacenados los sahred preferences
        spMisDatos = getSharedPreferences("mis_datos", Activity.MODE_PRIVATE);
        //Directo sobre los edit text se asigna el valor de los sahrepreferences
        nombre.setText(spMisDatos.getString("NOMBRE","default name"));
        apellido.setText(spMisDatos.getString("APELLIDO","default last name"));
        edad.setText("" + spMisDatos.getInt("EDAD",0));
    }

    @Override
    protected void onPause() {
        super.onPause();
        //AQUÍ VAMOS AGUARDAR LOS DATOS
        String sNom, sApe;
        int iEdad;
        sNom = nombre.getText().toString();
        sApe = apellido.getText().toString();
        iEdad = Integer.parseInt(edad.getText().toString());


        SharedPreferences.Editor speGuardarDatos = spMisDatos.edit();
        speGuardarDatos.putString("NOMBRE", sNom);
        speGuardarDatos.putString("APELLIDO", sApe);
        speGuardarDatos.putInt("EDAD", iEdad);
    }
}
