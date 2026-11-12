package aulas.ado.ado3.principal;

import aulas.ado.ado3.model.Cpu;
import aulas.ado.ado3.model.Servidor;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.Scanner;

public class Menu {
    private Servidor servidor;

    private Cpu cpu;

    Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        Integer opcao;

        // Exibir o menu e ler a opção do usuário
        //Isso é um text block
        String menu = """
                1 - Listar CPUs
                2 - Adicionar CPU
                3 - Remover CPU
                4 - Busca em largura
                5 - Busca em profundidade
                6 - Sair""";

        System.out.println(menu);
        opcao = scanner.nextInt();

        while (opcao != 6) {

            switch (opcao) {
                case 1 -> listarCpus(Servidor servidor);
                case 2 -> adicionarCpu(Cpu cpu, Servidor servidor);
                case 3 -> removerCpu(Cpu cpu, Servidor servidor);
                case 4 -> buscaEmLargura();
                case 5 -> buscaEmProfundidade();
                default:
                    System.out.println("Opção inválida!");
            }
        }


    }

    public void listarCpus(Servidor servidor) {
        servidor.getPoolCpus().forEach(System.out::println);
    }

    public void adicionarCpu(Cpu cpu, Servidor servidor) {
        /*Quando é utilizado o + para concatenar Strings,
        o Java cria um novo objeto String a cada concatenação,
        o que pode ser ineficiente em termos de desempenho,
         especialmente em loops ou quando há muitas concatenações.
          O StringBuilder é uma classe projetada para criar e manipular Strings de forma mais eficiente,
           permitindo a modificação do conteúdo sem criar novos objetos String a cada operação*/

        String mensagem = "CPU adicionada com sucesso: ";

        int tamanhoInicial = mensagem.length() + cpu.getModelo().length() + 2;

        StringBuilder sb = new StringBuilder();

        sb.append(cpu.getModelo()).append("\n").append(mensagem);

        System.out.println(sb);

        servidor.adicionaCpu(cpu);

    }

    public void removerCpu(Cpu cpu, Servidor servidor){
        servidor.getPoolCpus().remove(cpu);
        System.out.println("CPU removida com sucesso: " + cpu.getModelo());
    }

    public void buscaEmLargura(){

    }

    public void buscaEmProfundidade(){

    }


}
