package com.example.pizzafragment.model;

import java.io.Serializable;

public class Pizza implements Serializable {
    private String name;
    private String descripcion;
    private float price;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Pizza pizza = (Pizza) o;

        return name != null ? name.equals(pizza.name) : pizza.name == null;
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }

    /**
     * Se modifica el metodo to string para que solo muestre el nombre de la pizza en la lista.
     */

    @Override
    public String toString() {
        return "" + name;
    }

    public Pizza(String name, String descripcion, float price) {
        this.name = name;
        this.descripcion = descripcion;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }
}
