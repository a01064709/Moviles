package com.itesm.tarea1;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.app.NotificationBuilderWithBuilderAccessor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void sePulsaToast (View view) {
        Toast.makeText(this, "Pulsado", Toast.LENGTH_SHORT).show();
    }

    Context context;

    public void sePulsaAlert (View view) {

        context = getApplicationContext();
        AlertDialog.Builder DialogConf = new AlertDialog.Builder(this);

        DialogConf.setTitle("Confirmation Dialog");
        DialogConf.setMessage("This is the Text of the Dialog");
        DialogConf.setIcon(R.mipmap.ic_launcher);

        final EditText TextInput = new EditText(context);
        TextInput.setTextColor(Color.BLUE);
        DialogConf.setView(TextInput);

        DialogConf.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "You answer yes", Toast.LENGTH_LONG).show();
                    }
                });

        DialogConf.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "You answer NO", Toast.LENGTH_LONG).show();
                    }
                });

        DialogConf.setNeutralButton("Close",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(context, "You closed the dialog", Toast.LENGTH_LONG).show();
                    }
                });

        AlertDialog MyDialog = DialogConf.create();
        MyDialog.show();

        //Bar Notification

        int NOTIF_ID = 1234;

        Notification.Builder NotiBuilder = new Notification.Builder(this);
        NotiBuilder.setSmallIcon(R.mipmap.ic_launcher);
        NotiBuilder.setContentTitle("Important Notification");
        NotiBuilder.setContentText("This is the detail of the notification");

        Intent notificationIntent = new Intent(context, MainActivity.class);
        notificationIntent.putExtra("myData", "This string comes from the previous activiry");
        PendingIntent contentIntent = PendingIntent.getActivity(context, 0, notificationIntent, 0);

        NotiBuilder.setContentIntent(contentIntent);

        NotificationManager MyNotification = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        MyNotification.notify(NOTIF_ID, NotiBuilder.build());
    }

    public void lanzarMensaje(View view) {
        EditText editText = (EditText) findViewById(R.id.editText);
        String msj = editText.getText().toString();


        Intent i = new Intent(this, Message.class);
        i.putExtra("mensaje",msj);

        startActivity(i);
    }
}
