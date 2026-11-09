package aulas.ado.ado3.model;

import java.util.ArrayList;

public class Vertice<T> {
    private T dado;

    private ArrayList<Aresta<T>> arestasEntrada;
    private ArrayList<Aresta<T>> arestasSaida;

    public Vertice(T dado) {
        this.dado = dado;
        this.arestasEntrada = new ArrayList<>();
        this.arestasSaida = new ArrayList<>();
    }
}
