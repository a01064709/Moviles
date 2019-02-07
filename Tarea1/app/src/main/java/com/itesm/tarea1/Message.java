package com.itesm.tarea1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Message extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        Bundle extras = getIntent().getExtras();
        String msj = extras.getString("mensaje");

        TextView textView = (TextView) findViewById(R.id.textViewMensaje);
        textView.setText(msj);
    }

    public void clickFinish(View view) {
        finish();
    }


}
