package com.example.pizzafragment.repository;

import com.example.pizzafragment.model.Pizza;

import java.util.ArrayList;

public class PizzaRepository {

    private PizzaRepository() {
    }


    private static ArrayList<Pizza> list;
    //estructura que inicializa los campos static o de clase
    //ya que no se puede inicializar en un objeto
    //static es comun a todos los objetos de la clase.
    static{
        list=new ArrayList<>();
        list.add(new Pizza("vegetariana", "cebolla,pimiento,queso parmesano",12.56F));
        list.add(new Pizza("4 estaciones", "cebolla,jamon york, pimiento,queso parmesano",11.56F));
        list.add(new Pizza("americana", "carne,pimiento,queso parmesano",13.56F));
    }


    /*
     * metodo que dada una posicion devuelve una lista de pizza
     * */
    public static ArrayList<Pizza> getList() {
        return list;
    }
    /*
    * metodo que dada una posicion devuelve una pizza
    * */
    public static Pizza getPizza (int position){
        return list.get(position);
    }
}
