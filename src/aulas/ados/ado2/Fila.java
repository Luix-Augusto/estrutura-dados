package aulas.ados.ado2;

public class Fila {
    private Object[] vetor;
    private int tamanhoVetor;

    // conta quantos atendimentos PRIORITARIOS seguidos já foram feitos,
    // usado na regra "a cada 3 preferenciais, 1 normal"
    private int contadorPrioritariosSeguidos;

    public Fila() {
        this.vetor = new Object[5];
        this.tamanhoVetor = 0;
        this.contadorPrioritariosSeguidos = 0;
    }

    // ---------- Métodos originais ----------

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

    /**
     * Remove o elemento de um índice específico do vetor, deslocando os
     * elementos seguintes uma posição para a esquerda (evita usar Stack/Queue/ArrayList).
     */
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

    /** Remove o primeiro elemento da fila (ordem física / FIFO puro). */
    public Object desenfileira() {
        return removeIndice(0);
    }

    /** Retorna o índice do primeiro paciente de um determinado tipo (ordem de chegada). */
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

    /**
     * Compara dois pacientes quanto à prioridade de atendimento.
     * Retorna valor negativo se p1 deve ser atendido antes de p2, positivo se
     * p2 deve ser atendido antes de p1, e a diferença de senha em caso de empate
     * de tipo (quem chegou primeiro tem prioridade).
     */
    public int compararPrioridade(Paciente p1, Paciente p2) {
        if (p1.getTipo() == p2.getTipo()) {
            return p1.getSenha() - p2.getSenha();
        }
        return (p1.getTipo() == TipoPaciente.PRIORITARIO) ? -1 : 1;
    }

    /**
     * Define, de acordo com a regra de negócio, o índice do próximo paciente
     * a ser atendido, SEM removê-lo da fila:
     * - Se não há preferenciais esperando, segue o atendimento normal.
     * - Se já foram feitos 3 atendimentos preferenciais seguidos e existe
     *   normal esperando, chama o normal (e zera o contador).
     * - Caso contrário, chama o próximo preferencial.
     */
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

    /** Mostra quem seria o próximo chamado, sem remover da fila. */
    public Paciente espiarProximoAtendimento() {
        int indice = indiceProximoAtendimento();
        if (indice == -1) {
            return null;
        }
        return (Paciente) vetor[indice];
    }

    /** Chama (remove) o próximo paciente, respeitando a regra de negócio 3:1. */
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

    /** Retorna uma cópia de todos os elementos atualmente na fila, em ordem de chegada. */
    public Object[] listarTodos() {
        Object[] copia = new Object[tamanhoVetor];
        for (int i = 0; i < tamanhoVetor; i++) {
            copia[i] = vetor[i];
        }
        return copia;
    }
}