package aulas.ado.ado3.model;

import java.util.ArrayList;

public class Grafo<T> {

    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo(ArrayList<Vertice<T>> vertices, ArrayList<Aresta<T>> arestas) {
        this.vertices = new ArrayList<>();
        this.arestas = new ArrayList<>();
    }

    public void adicionarVertice(T dado) {
        Vertice<T> novoVertice = new Vertice<T>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Integer peso, T dadoInicio, T dadoFim) {
        Vertice<T> inicio = this.getVertice(dadoInicio);
        Vertice<T> fim = this.getVertice(dadoFim);
        Aresta<T> aresta = new Aresta<T>(peso, inicio, fim);
        inicio.adicionarArestaEntrada(aresta);
        fim.adicionarArestaSaida(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<T> getVertice(T dado) {
        Vertice<T> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado)) {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void buscaEmLargura() {


        ArrayList<Vertice<T>> marcados = new ArrayList<>();
        ArrayList<Vertice<T>> fila = new ArrayList<>();



        while (!fila.isEmpty()) {
            Vertice<T> atual = fila.remove(0);

            for (Aresta<T> aresta : atual.getArestasSaida()) {
                Vertice<T> proximo = aresta.getFim();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    fila.add(proximo);
                    System.out.println(proximo.getDado());
                }
            }
            fila.remove(0);
        }
    }

    public void buscaEmProfundidade(){

        visitar(inicio, new ArrayList<Vertice<T>>());
    }

    private void visitar(Vertice<T> atual, ArrayList<Vertice<T>> marcados){
        marcados.add(atual);
        System.out.println(atual.getDado());
        for (Aresta<T> aresta : atual.getArestasSaida()) {
            Vertice<T> proximo = aresta.getFim();
            if (!marcados.contains(proximo)) {
                visitar(proximo, marcados);
            }
        }
    }


}
