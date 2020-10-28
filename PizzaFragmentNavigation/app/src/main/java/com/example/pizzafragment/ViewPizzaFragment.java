package com.example.pizzafragment;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pizzafragment.model.Pizza;

import org.w3c.dom.Text;

import java.util.Random;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ViewPizzaFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ViewPizzaFragment extends Fragment {

    public static final String ARG_PIZZA = "pizza";
    public static final String TAG = "ViewPizzaFragment";
    private TextView tvName;
    private TextView tvDescription;

    private int number;

    public ViewPizzaFragment() {
        // Required empty public constructor
    }

    /**
     * usamos este metodo factoria para crear una instancia de este
     * fragment nosotros como parametro un objeto bundle.
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param bundle contiene los argumentos del fragment
     * @return una instancia del fragmento ViewPizzaFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ViewPizzaFragment newInstance(Bundle bundle) {
        ViewPizzaFragment fragment = new ViewPizzaFragment();
        if (bundle !=null)
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        Log.d(TAG,"ViewPizzaFragment -> onAttach()");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRetainInstance(true);
        Log.d(TAG,"ViewPizzaFragment -> onCreate()");
        number= new Random().nextInt(101);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tvName=view.findViewById(R.id.tvName);
        tvDescription=view.findViewById(R.id.tvDescription);
        // Se recoge los argumentos , es decir , el objeto Bundle
        Pizza pizza=(Pizza)(getArguments().getSerializable(ARG_PIZZA));
        tvName.setText(pizza.getName());
        tvDescription.setText(pizza.getDescripcion());

        Toast.makeText(getActivity(),"Número aleatorio: "+number,Toast.LENGTH_SHORT).show();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Log.d(TAG,"ViewPizzaFragment -> onCreateView()");
        return inflater.inflate(R.layout.fragment_view_pizza, container, false);

    }
    @Override
    public void onStart() {
        super.onStart();
        Log.d(TAG,"ViewPizzaFragment -> onStart()");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG,"ViewPizzaFragment -> onResume()");
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(TAG,"ViewPizzaFragment -> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG,"ViewPizzaFragment -> onStop()");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.d(TAG,"ViewPizzaFragment -> onDetach()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG,"ListPizzaFragment -> onDestroy()");
    }
}
