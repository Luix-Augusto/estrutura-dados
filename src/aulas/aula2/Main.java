package aulas.aula2;

public class Main {
    public static void main(String[] args) throws Exception {
        VetorObjeto vetor = new VetorObjeto(2);

        Contato c1 = new Contato("Claudio","9999-2525","claudio@gmail.com");
        Contato c2 = new Contato("Daniel","9999-7213","daniel@gmail.com");
        Contato c3 = new Contato("Daniel","9999-7213","daniel@gmail.com");

        try{
            vetor.adiciona(c1);
            vetor.adiciona(c2);
            vetor.adiciona(c3);
        }catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Quantidade de elementos no vetor: " + vetor.getTamanho());
        System.out.println("Dados no vetor: " + vetor.toString());
    }
}
