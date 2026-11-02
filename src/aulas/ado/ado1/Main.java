package aulas.ado.ado1;

public class Main {

    public static void main(String[] args) throws Exception {

        Livro livro1 = new Livro("Dom Quixote", "Miguel de Cervantes", true);
        Livro livro2 = new Livro("1984", "George Orwell", true);
        Livro livro3 = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry", false);

        Vetor vetor = new Vetor(2);
        vetor.adiciona(livro1);
        vetor.adiciona(livro2);
        vetor.adiciona(livro3);

        System.out.println("Livros: " + vetor);
        System.out.println("Quantidade de livros: " + vetor.getTamanho());

//        vetor.removeConteudo(livro3, livro3.isDisponivel());
        System.out.println("Quantidade de livros: " + vetor.getTamanho());

        Livro livro4 = new Livro("O Senhor dos Anéis", "J.R.R. Tolkien", false);
        Livro livro5 = new Livro("A Hora da Estrela", "Clarice Lispector", false);

        vetor.adiciona(livro4);
        vetor.adiciona(livro5);

        System.out.println("Livros: " + vetor);

        System.out.println("Quantidade de livros: " + vetor.getTamanho());

        vetor.remove(1);
//        vetor.removeConteudo(livro5, livro5.isDisponivel());

        System.out.println("Livros: " + vetor);
        System.out.println("Quantidade de livros: " + vetor.getTamanho());





    }
}
