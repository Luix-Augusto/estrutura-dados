package aulas.aula1;

import java.util.Arrays;

public class Vetor {

    private String[] elementos;
    private int tamanho; // determina o tamanho atual do vetor

    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
    }
    //Método menos eficiente, pois percorre todo o vetor para encontrar a primeira posição nula
    /*public void adiciona(String elemento) {
        for (int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) {
                this.elementos[i] = elemento;
                this.tamanho++;
                break;
            } ;
        }
    }*/
/*
    public void adiciona(String elemento) throws Exception {
        this.aumentaCapacidade();
        //com o método de aumentar a capacidade, não é mais necessário verificar se o vetor está cheio, pois ele aumenta automaticamente quando necessário
        if (this.tamanho < this.elementos.length) {
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor cheio" +
                    ", não é possível adicionar mais elementos.");
        }


    }*/

    public void adiciona(String elemento){
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    public void adiciona(int posicao, String elemento) {

    }

    public void remove(int posicao) throws Exception {
        if (posicao >= 0 && posicao < this.tamanho){
            for (int i = posicao; i < this.tamanho -1; i++){
                this.elementos[i] = this.elementos[i + 1];
            }
            this.elementos[this.tamanho -1] = null;
            this.tamanho--;
        }else {
            throw new Exception("Posição inválida");
        }

    }

    public String busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < this.tamanho) {
            return this.elementos[posicao];
        } else {
            throw new Exception("Posição inválida");
        }

    }

    public int busca(String elemento) {
        for (int i = 0; i < this.tamanho; i++) {
            if (this.elementos[i].equalsIgnoreCase(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean adicionaInicio(int posicao, String elemento) throws Exception {
//        Se a info for valida, ajusta as infos no
//        vetor e insere a informação na posição indicada e ajusta o tamanho
        this.aumentaCapacidade();
        if (posicao >= 0 && posicao < this.tamanho) {

            for (int i = this.tamanho - 1; i > posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        }
        //Se a posição for invalida, envia uma mensagem amigavel ao usuario
        else {
            throw new Exception("Posição inválida");
        }
        return true;
    }

    public int tamanho() {
        return this.tamanho;
    }

    public void aumentaCapacidade(){
//        Cria um vetor com o dobro da capacidade do vetor atual, e copia os elementos do vetor atual para o novo vetor
        if (this.tamanho == this.elementos.length){
            String [] elementosNovos =  new String[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public String toString() {
        //A classe arrays tem diversos métodos para manipular vetores
//    return Arrays.toString(this.elementos);

        //StringBuilder permite manipular dados de forma mais eficiente, pois não cria um novo objeto a cada concatenação

        StringBuilder s = new StringBuilder();
        s.append("[");
        //pega o primeiro valor do vetor até o penultimo valor, para não colocar a vírgula no final
        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        //pega o ultimo valor do vetor, para não colocar a vírgula no final
        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }
        s.append("]");
        return s.toString();
    }
}



