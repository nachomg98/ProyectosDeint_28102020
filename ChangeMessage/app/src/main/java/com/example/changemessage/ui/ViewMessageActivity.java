package com.example.changemessage.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

import com.example.changemessage.R;
import com.example.changemessage.model.Message;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;


public class ViewMessageActivity extends AppCompatActivity {

    private static final String TAG = "ViewMessageActivity";
    private TextView tvMessage;

    /**
     * Este metodo Crea el activity y es un metodo callback
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //se inicializa la interfaz
        setContentView(R.layout.activity_view_message);
        //TODO Inicializar los widgets
        Logger.addLogAdapter(new AndroidLogAdapter());
        Logger.i(TAG, "ViewMessageActivity: onCreate()");
        tvMessage=findViewById(R.id.tvMessage);

        //1. recoger el intent
        Intent intent=getIntent();
        //2.recoger el objeto
        Bundle bundle=intent.getExtras();
        Message message = (Message)bundle.getSerializable("message");
        //3. actualizar vista

        tvMessage.setText(message.getMessage());
        tvMessage.setTextSize(message.getSize());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Logger.i(TAG, "ViewMessageActivity: onDestroy()");
    }
}