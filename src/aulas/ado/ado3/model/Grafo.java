package aulas.ado.ado3.model;

import java.util.ArrayList;
import java.util.List;

public class Grafo<T> {

    private ArrayList<Vertice<T>> vertices;
    private ArrayList<Aresta<T>> arestas;

    public Grafo() {
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
        fim.adicionarArestaSaida(aresta);
        inicio.adicionarArestaEntrada(aresta);
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
        List marcados = new ArrayList<Vertice<T>>();
        List fila = new ArrayList<Vertice<T>>();
        Vertice<T> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());

        fila.add(atual);

        while (!fila.isEmpty()) {
            Vertice<T> visitado = (Vertice<T>) fila.get(0);
            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public void buscaEmProfundidade() {

        List<Vertice<T>> marcados = new ArrayList<>();
        List<Vertice<T>> pilha = new ArrayList<>();

        Vertice<T> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());

        pilha.add(atual);

        while (!pilha.isEmpty()) {
            Vertice<T> visitado = pilha.get(pilha.size() - 1);
            boolean achouVizinho = false;

            for (int i = 0; i < visitado.getArestasSaida().size(); i++) {
                Vertice<T> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo)) {
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    pilha.add(proximo);
                    achouVizinho = true;
                    break;
                }
            }

            if (!achouVizinho) {
                pilha.remove(pilha.size() - 1);
            }

        }


    }

    private void visitar(Vertice<T> atual, ArrayList<Vertice<T>> marcados) {
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
