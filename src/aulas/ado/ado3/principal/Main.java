package aulas.ado.ado3.principal;

public class Main {
    public static void main(String[] args) {
        /*
        Aqui é a classe principal
        Meio que esta sendo utilizando
         o principio de responsabilidade unica,
          pois a classe Main tem apenas a responsabilidade
           de iniciar o programa e chamar o menu.
        * */

        Menu menu = new Menu();

        menu.exibirMenu();
    }
}

