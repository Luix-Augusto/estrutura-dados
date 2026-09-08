package aulas.aula1;

public class Main {
    public static void main(String[] args) throws Exception {

        Vetor vetor = new Vetor(5);

/*
        vetor.adiciona("Elemento 1");
        vetor.adiciona("Elemento 2");

        System.out.println("Quantidade de elementos no vetor: " + vetor.tamanho());

        System.out.println("Dados no vetor: " + vetor);

        System.out.println("Dado na segunda posição: " + vetor.busca(1));

        System.out.println("Posição do elemento 'Elemento 2': " + vetor.busca("Elemento 2"));

        vetor.adicionaInicio(0, "Elemento 0");
*/
        vetor.adiciona("Elemento 1");
        vetor.adiciona("Elemento 2");
        vetor.adiciona("Elemento 3");
        vetor.adiciona("Elemento 4");
        vetor.adiciona("Elemento 5");
        vetor.adiciona("Elemento 6");
        vetor.adiciona("Elemento 7");

        System.out.println("Quantidade de elementos no vetor: " + vetor.tamanho());
        System.out.println("Dados no vetor: " + vetor);

        vetor.remove(2);

        System.out.println("Quantidade de elementos no vetor: " + vetor.tamanho());
        System.out.println("Dados no vetor: " + vetor);






    }
}
