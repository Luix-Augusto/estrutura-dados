package aulas.ado.ado2;

public class Fila {
    private Object[] vetor;
    private int tamanhoVetor;


    private int contadorPrioritariosSeguidos;

    public Fila() {
        this.vetor = new Object[5];
        this.tamanhoVetor = 0;
        this.contadorPrioritariosSeguidos = 0;
    }


    public void adiciona(Object elemento) {
        this.aumentaCapacidade();
        this.vetor[this.tamanhoVetor] = elemento;
        this.tamanhoVetor++;
    }

    public void aumentaCapacidade() {
        if (this.tamanhoVetor == vetor.length) {
            Object[] elementosNovos = new Object[this.vetor.length * 2];
            for (int i = 0; i < this.vetor.length; i++) {
                elementosNovos[i] = this.vetor[i];
            }
            this.vetor = elementosNovos;
        }
    }

    public void enfileira(Object elemento) {
        adiciona(elemento);
    }

    public Object espiar() {
        if (estaVazia()) {
            return null;
        }
        return vetor[0];
    }

    public Boolean estaVazia() {
        return this.tamanhoVetor == 0;
    }

    // ---------- Métodos novos ----------

    public int tamanho() {
        return this.tamanhoVetor;
    }


    private Object removeIndice(int indice) {
        if (indice < 0 || indice >= tamanhoVetor) {
            return null;
        }
        Object removido = vetor[indice];
        for (int i = indice; i < tamanhoVetor - 1; i++) {
            vetor[i] = vetor[i + 1];
        }
        vetor[tamanhoVetor - 1] = null;
        tamanhoVetor--;
        return removido;
    }

    public Object desenfileira() {
        return removeIndice(0);
    }

    private int indiceProximoPorTipo(TipoPaciente tipo) {
        for (int i = 0; i < tamanhoVetor; i++) {
            Paciente p = (Paciente) vetor[i];
            if (p.getTipo() == tipo) {
                return i;
            }
        }
        return -1;
    }

    public boolean existePrioritario() {
        return indiceProximoPorTipo(TipoPaciente.PRIORITARIO) != -1;
    }

    public boolean existeNormal() {
        return indiceProximoPorTipo(TipoPaciente.NORMAL) != -1;
    }


    public int compararPrioridade(Paciente p1, Paciente p2) {
        if (p1.getTipo() == p2.getTipo()) {
            return p1.getSenha() - p2.getSenha();
        }
        return (p1.getTipo() == TipoPaciente.PRIORITARIO) ? -1 : 1;
    }


    private int indiceProximoAtendimento() {
        if (estaVazia()) {
            return -1;
        }

        boolean temPrioritario = existePrioritario();
        boolean temNormal = existeNormal();

        if (!temPrioritario) {
            return indiceProximoPorTipo(TipoPaciente.NORMAL);
        }
        if (contadorPrioritariosSeguidos >= 3 && temNormal) {
            return indiceProximoPorTipo(TipoPaciente.NORMAL);
        }
        return indiceProximoPorTipo(TipoPaciente.PRIORITARIO);
    }

    public Paciente espiarProximoAtendimento() {
        int indice = indiceProximoAtendimento();
        if (indice == -1) {
            return null;
        }
        return (Paciente) vetor[indice];
    }

    public Paciente chamarProximo() {
        int indice = indiceProximoAtendimento();
        if (indice == -1) {
            return null;
        }

        Paciente escolhido = (Paciente) vetor[indice];
        if (escolhido.getTipo() == TipoPaciente.PRIORITARIO) {
            contadorPrioritariosSeguidos++;
        } else {
            contadorPrioritariosSeguidos = 0;
        }

        return (Paciente) removeIndice(indice);
    }

    public Object[] listarTodos() {
        Object[] copia = new Object[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            copia[i] = vetor[i];
        }
        return copia;
    }
}