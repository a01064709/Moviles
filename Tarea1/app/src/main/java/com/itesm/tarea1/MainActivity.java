package com.itesm.tarea1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sePulsa (View view) {
        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
    }

    public void lanzarMensaje(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String msj = editText.getText().toString();


        Intent i = new Intent(this, Message.class);
        i.putExtra("mensaje",msj);

        startActivity(i);
    }
}
