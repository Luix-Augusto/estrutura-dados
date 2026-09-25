package aulas.aula2;

public class VetorObjeto {
    private Object[] elementos;
    private int tamanho;

    public VetorObjeto(int capacidade){
        //Quano
        // o objeto é instanciado, o vetor é criado com a capacidade informada e o tamanho inicial é 0
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona(Object elemento) throws Exception {
        this.aumentaCapacidade();
        if (this.tamanho < this.elementos.length){
            this.elementos[this.tamanho] = elemento;
            this.tamanho++;
        }else {
            throw new Exception("Vetor cheio, não é possível adicionar mais elementos.");
        }
    }

    public void aumentaCapacidade(){
        if (this.tamanho == this.elementos.length){
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for(int i = 0; i < this.elementos.length; i++){
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }






    public int getTamanho() {
        return tamanho;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for(int i = 0; i < this.tamanho; i++){
            sb.append(this.elementos[i].toString());
            if(i < this.tamanho - 1){
                sb.append(", ");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
