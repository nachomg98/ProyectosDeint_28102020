package com.example.changemessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.SeekBar;

import com.example.changemessage.ChangeMessageAplication;
import com.example.changemessage.R;
import com.example.changemessage.model.Message;

/**
 * <h1>Función de la clase</h1>
 * <p>Esta clase envia un texto a otra actividad y le indica el tamaño del texto</p>
 * <h2>aprendizaje</h2>
 * <ul>
 *     <li>que es context</li>
 *     <li>que se puede introducir etiquetas HTML dentro de los comentarios javadoc </li>
 *     <li>que es un objeto {@link android.os.Bundle}</li>
 *     <li>El paso de mensajes entre dos activity mediante la clase <a target="_blank" href="https://developer.android.com/reference/android/content/Intent">Intent</a></li>
 * </ul>
 * @author Nacho Moya
 * @version 1.0
 * @see ViewMessageActivity#onCreate(Bundle)
 */

public class SendMessageActivity extends AppCompatActivity {

    private static final String TAG = "SendMessageActivity";
    private Button btSendMessage;
    private EditText edMessage;
    private SeekBar skSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sendmessage);
        btSendMessage=findViewById(R.id.btSendMessage);
        edMessage=findViewById(R.id.edMessage);
        skSize=findViewById(R.id.skSize);
        btSendMessage.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {
                //1. Crear un objeto contenedor o bundle para añadir los datos
                Bundle bundle=new Bundle();
                //bundle.putString("message", edMessage.getText().toString());
                //bundle.putInt("size", skSize.getProgress());
                //1.1 crear objeto message
                Message message= new Message(((ChangeMessageAplication)getApplication()).getUser(),
                        edMessage.getText().toString(), "16/10/2020", skSize.getProgress());
                bundle.putSerializable("message", message);

                //2. Se crea el objeto intent explicito se conoce la activity origen y la Activity destino
                Intent intent =new Intent(SendMessageActivity.this, ViewMessageActivity.class);

                //3. Añadir el objeto Bundle al Intent
                intent.putExtras(bundle);

                //4 Iniciar la activity destino ViewMessage
                startActivity(intent);

            }
        });
        Log.i(TAG, "SendMessage: onCreate()");

    }

    /**
     * Método que se ejecuta cuando se pulsa el btAbout
     * se ha implementado mediante el atributo android:onclick en
     * activity_sendmessage.
     * @param view botón donde se ha realizado click.
     */
    public void showAbout(View view){
        Intent intent= new Intent(this, AboutActivity.class);
        startActivity(intent);
    }
//region Ciclo de vida del activity
    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "SendMessage: onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "SendMessage: onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "SendMessage: onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "SendMessage: onStop()");
    }



    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "SendMessage: onDestroy()");
    }
    //endregion



}
