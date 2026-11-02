package aulas.ado.ado1;

public class Vetor {
    private Object[] elementos;
    private int tamanho;

    public Vetor(int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public Object[] getElementos() {
        return elementos;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void adiciona(Object elemento) throws Exception {
        this.aumentacapacidade();
        if (this.tamanho < this.elementos.length) {
            this.elementos[tamanho] = elemento;
            this.tamanho++;
        } else {
            throw new Exception("Vetor cheio, não é possível adicionar mais elementos.");
        }
    }

    public void aumentacapacidade() {
        if (this.tamanho == elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void removeConteudo(Object elemento, boolean disponivel) throws Exception {
        if (disponivel) {
            if (elemento != null && !elemento.toString().trim().isEmpty()) {
                int posicao = -1;
                for (int i = 0; i < this.elementos.length; i++) {
                    if (this.elementos[i] != null && this.elementos[i].equals(elemento)) {
                        posicao = i;
                        break;
                    }
                }
                if (posicao != -1) {
                    for (int i = posicao; i < this.tamanho - 1; i++) {
                        this.elementos[i] = this.elementos[i + 1];
                    }
                    this.elementos[this.tamanho - 1] = null;
                    this.tamanho--;
                }
            }
        } else {
            throw new Exception("O livro não está disponível.");
        }
    }

    public void remove(int posicao) throws Exception {
        if (posicao >= 0 && posicao < this.tamanho) {
            for (int i = posicao; i < this.tamanho; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.elementos[this.tamanho - 1] = null;
            this.tamanho--;
        } else {
            throw new Exception("Posição inválida.");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < this.tamanho; i++) {
            sb.append(this.elementos[i].toString());
            if (i < this.tamanho - 1) {
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }

}