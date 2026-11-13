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
        Integer opcao = -1;

        // Exibir o menu e ler a opção do usuário
        //Isso é um text block
        String menu = """
                1 - Listar CPUs
                2 - Adicionar CPU
                3 - Remover CPU
                4 - Busca em largura
                5 - Busca em profundidade
                6 - Sair""";

        while (opcao != 6) {

            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> listarCpus(servidor);
                case 2 -> adicionarCpu(cpu, servidor);
                case 3 -> removerCpu(cpu, servidor);
                case 4 -> buscaEmLargura();
                case 5 -> buscaEmProfundidade();
                default -> System.out.println("Opção inválida!");
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

    public void criarServidores(){

        Cpu cpu1  = new Cpu("WebSphere-HML-01", 4,  2400, false);
        Cpu cpu2  = new Cpu("WebSphere-PRD-02", 8,  3000, true);
        Cpu cpu3  = new Cpu("WebSphere-HML-03", 4,  2600, false);
        Cpu cpu4  = new Cpu("WebSphere-PRD-04", 8,  3200, true);
        Cpu cpu5  = new Cpu("WebSphere-HML-05", 6,  2400, false);
        Cpu cpu6  = new Cpu("WebSphere-PRD-06", 12, 3000, true);
        Cpu cpu7  = new Cpu("WebSphere-HML-07", 4,  2800, false);
        Cpu cpu8  = new Cpu("WebSphere-PRD-08", 8,  3400, true);
        Cpu cpu9  = new Cpu("WebSphere-HML-09", 6,  2600, false);
        Cpu cpu10 = new Cpu("WebSphere-PRD-10", 12, 3200, true);
        Cpu cpu11 = new Cpu("WebSphere-HML-11", 4,  2400, false);
        Cpu cpu12 = new Cpu("WebSphere-PRD-12", 16, 3000, true);
        Cpu cpu13 = new Cpu("WebSphere-HML-13", 6,  2800, false);
        Cpu cpu14 = new Cpu("WebSphere-PRD-14", 8,  3400, true);
        Cpu cpu15 = new Cpu("WebSphere-HML-15", 4,  2600, false);
        Cpu cpu16 = new Cpu("WebSphere-PRD-16", 12, 3200, true);
        Cpu cpu17 = new Cpu("WebSphere-HML-17", 6,  2400, false);
        Cpu cpu18 = new Cpu("WebSphere-PRD-18", 16, 3000, true);
        Cpu cpu19 = new Cpu("WebSphere-HML-19", 4,  2800, false);
        Cpu cpu20 = new Cpu("WebSphere-PRD-20", 8,  3400, true);
        Cpu cpu21 = new Cpu("WebSphere-HML-21", 6,  2600, false);
        Cpu cpu22 = new Cpu("WebSphere-PRD-22", 12, 3200, true);
        Cpu cpu23 = new Cpu("WebSphere-HML-23", 4,  2400, false);
        Cpu cpu24 = new Cpu("WebSphere-PRD-24", 16, 3000, true);
        Cpu cpu25 = new Cpu("WebSphere-HML-25", 6,  2800, false);
        Cpu cpu26 = new Cpu("WebSphere-PRD-26", 8,  3400, true);
        Cpu cpu27 = new Cpu("WebSphere-HML-27", 4,  2600, false);
        Cpu cpu28 = new Cpu("WebSphere-PRD-28", 12, 3200, true);
        Cpu cpu29 = new Cpu("WebSphere-HML-29", 6,  2400, false);
        Cpu cpu30 = new Cpu("WebSphere-PRD-30", 16, 3000, true);


        Servidor servidor1 = new Servidor("Servi0101-prd", 16,  true);
        servidor1.adicionaCpu(cpu2);
        servidor1.adicionaCpu(cpu4);
        servidor1.adicionaCpu(cpu6);

        Servidor servidor2 = new Servidor("Servi0102-prd", 16,  true);
        servidor2.adicionaCpu(cpu8);
        servidor2.adicionaCpu(cpu10);
        servidor2.adicionaCpu(cpu12);

        Servidor servidor3 = new Servidor("Servi0103-prd", 16,  true);
        servidor3.adicionaCpu(cpu14);
        servidor3.adicionaCpu(cpu16);
        servidor3.adicionaCpu(cpu18);

        Servidor servidor4 = new Servidor("Servi0104-prd", 16,  true);
        servidor4.adicionaCpu(cpu20);
        servidor4.adicionaCpu(cpu22);
        servidor4.adicionaCpu(cpu24);

        Servidor servidor5 = new Servidor("Servi0105-prd", 16,  true);
        servidor5.adicionaCpu(cpu26);
        servidor5.adicionaCpu(cpu28);
        servidor5.adicionaCpu(cpu30);

        Servidor servidor6 = new Servidor("Servi0106-hml", 16,  false);
        servidor6.adicionaCpu(cpu1);
        servidor6.adicionaCpu(cpu3);
        servidor6.adicionaCpu(cpu5);

        Servidor servidor7 = new Servidor("Servi0107-hml", 16,  false);
        servidor7.adicionaCpu(cpu7);
        servidor7.adicionaCpu(cpu9);
        servidor7.adicionaCpu(cpu11);

        Servidor servidor8 = new Servidor("Servi0108-hml", 16,  false);
        servidor8.adicionaCpu(cpu13);
        servidor8.adicionaCpu(cpu15);
        servidor8.adicionaCpu(cpu17);

        Servidor servidor9 = new Servidor("Servi0109-hml", 16,  false);
        servidor9.adicionaCpu(cpu19);
        servidor9.adicionaCpu(cpu21);
        servidor9.adicionaCpu(cpu23);

        Servidor servidor10 = new Servidor("Servi01010-hml", 16,  false);
        servidor10.adicionaCpu(cpu25);
        servidor10.adicionaCpu(cpu27);
        servidor10.adicionaCpu(cpu29);

        Servidor servidor11 = new Servidor("Servi01011-hml", 16,  false);
        Servidor servidor12 = new Servidor("Servi01012-hml", 16,  false);
        Servidor servidor13 = new Servidor("Servi01013-hml", 16,  false);

    }


}
