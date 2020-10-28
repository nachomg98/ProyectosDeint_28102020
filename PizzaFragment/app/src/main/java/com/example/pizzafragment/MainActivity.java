package com.example.pizzafragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.widget.Toast;

import com.example.pizzafragment.model.Pizza;

import java.util.Random;

public class MainActivity extends AppCompatActivity implements ListPizzaFragment.OnItemSelectedListener{
    private static final String TAG = "MainActivity";
    private ListPizzaFragment listPizzaFragment;
    private ViewPizzaFragment viewPizzaFragment;

    private int number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Se ejecuta la primera vez
        if(savedInstanceState==null) {
            //Inicia la transaccionn de un fragment
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            listPizzaFragment = new ListPizzaFragment();
            ft.add(R.id.content, listPizzaFragment, ListPizzaFragment.TAG);
            ft.commit();
            number=new Random().nextInt(101);
        }
        else {
            //Se ha reiniciado la actividad
            number= savedInstanceState.getInt("number");
        }
        Log.d(TAG,"MainActivity -> OnCreate()");

    }

    /**
     * Este metodo corresponde a la inerfaz LisPizzaFragment.OnItemSelectedListener.
     * se ejecuta cuando se pulsa sobre un elemento de la lista.
     * @param pizza selecionada de la lista.
     */
    @Override
    public void onItemSelected(Pizza pizza) {
        //Toast.makeText(this,"Pizza Seleccionada "+pizza.toString(),Toast.LENGTH_SHORT).show();
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        Bundle bundle= new Bundle();
        //ARG_PIZZA es una constante string que se inicializa en el fragment
        //con la cadena a añadir en un bundle
        bundle.putSerializable(ViewPizzaFragment.ARG_PIZZA,pizza);
        viewPizzaFragment=ViewPizzaFragment.newInstance(bundle);
        ft.replace(R.id.content, viewPizzaFragment,viewPizzaFragment.TAG);

        //Añadimos el fragment en la pila que tiene el estado de la Activity. Es decir si estamos en el fragment ViewPizza y
        // le damos atŕas no se destruye el fragment si no que su estado se guarda en la pila de la Activity que lo contiene.
        ft.addToBackStack(null);

        ft.commit();


    }

    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"MainActivity -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"MainActivity -> onResume()");
        Toast.makeText(this,"Número aleatorio: "+number,Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"MainActivity -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"MainActivity -> onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"MainActivity -> onDestroy()");
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("number",number);
        Log.d(TAG,"MainActivity -> onSaveInstanceState");
    }
}
