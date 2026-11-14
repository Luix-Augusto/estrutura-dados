package aulas.ado.ado3.principal;

import aulas.ado.ado3.model.Cpu;
import aulas.ado.ado3.model.Grafo;
import aulas.ado.ado3.model.Servidor;

import javax.swing.undo.AbstractUndoableEdit;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutionException;

public class Menu {

    //declaracao generia
    private Servidor servidor;

    Grafo<Servidor> grafo = new Grafo<Servidor>();

    /*
     * instanciando para usar os servidores
     *  especificos em multiplos métodos*/
    private Servidor servidor1;
    private Servidor servidor2;
    private Servidor servidor3;
    private Servidor servidor4;
    private Servidor servidor5;
    private Servidor servidor6;
    private Servidor servidor7;
    private Servidor servidor8;
    private Servidor servidor9;
    private Servidor servidor10;
    private Servidor servidor11;
    private Servidor servidor12;
    private Servidor servidor13;
    private Servidor servidor14;
    private Servidor servidor15;
    private Servidor servidor16;
    private Servidor servidor17;
    private Servidor servidor18;
    private Servidor servidor19;
    private Servidor servidor20;
    private Servidor servidor21;
    private Servidor servidor22;
    private Servidor servidor23;
    private Servidor servidor24;
    private Servidor servidor25;
    private Servidor servidor26;
    private Servidor servidor27;
    private Servidor servidor28;
    private Servidor servidor29;
    private Servidor servidor30;
    List<Servidor> servidores = new ArrayList<>();

    private Cpu cpu;


    Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        Integer opcao = -1;

        String dica = """
                ***********************\n
                ORDEM RECOMENDADA: \n
                1 - Criar Servidores
                4 - Criar Grafo\n
                Em seguida, você pode realizar buscas em largura ou profundidade.
                ***********************\n""";

        // Exibir o menu e ler a opção do usuário
        //Isso é um text block
        String menu = """
                1 - Criar servidores
                2 - Criar grafo
                3 - Busca em largura
                4 - Busca em profundidade
                5 - Listar CPUs de um servidor
                6 - Remover CPU de um servidor
                7 - Adicionar CPU a um servidor
                8 - Sair""";

        while (opcao != 8) {
            System.out.println(dica);
            System.out.println(menu);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1 -> criarServidores();
                case 2 -> criarGrafos();
                case 3 -> buscaEmLargura();
                case 4 -> buscaEmProfundidade();
                case 5 -> {
                    scanner.nextLine();
                    System.out.println("Informe o servidor que deseja listar as CPUs:");
                    String hostName = scanner.nextLine();
                    listarCpus(hostName);
                }
                case 6 -> {
                    scanner.nextLine();
                    System.out.println("Informe o servidor que deseja remover a CPU:");
                    String hostName = scanner.nextLine();
                    System.out.println("Informe o modelo da CPU que deseja remover:");
                    String modeloCpu = scanner.nextLine();
                    removerCpu(hostName, modeloCpu);
                }
                case 7 -> {
                    scanner.nextLine();
                    System.out.println("Informe o servidor para ser inserido");
                    String hostName = scanner.nextLine();
                    adicionarCpu(hostName);
                }
                case 8 -> {
                    System.out.println("Saindo do programa...");
                    break;
                }
                default -> System.out.println("Opção inválida!");
            }
        }


    }

    public void listarCpus(String hostname) {
        try {

            servidores.add(servidor1);
            servidores.add(servidor2);
            servidores.add(servidor3);
            servidores.add(servidor4);
            servidores.add(servidor5);
            servidores.add(servidor6);
            servidores.add(servidor7);
            servidores.add(servidor8);
            servidores.add(servidor9);
            servidores.add(servidor10);
            servidores.add(servidor11);
            servidores.add(servidor12);
            servidores.add(servidor13);
            for (Servidor s : servidores) {
                if (hostname.equalsIgnoreCase(s.getHostName())) {
                    System.out.println(s.getPoolCpus());
                    return;
                }
            }
            System.out.println("Não encontrado");
        } catch (Exception e) {
            System.out.println("ERRO\n - Tente novamente.");
            ;
        }
    }

    public void adicionarCpu(String servidor) {
        try {

            String hostProcurado = servidor;

            //stream API
            Servidor hostAchado = servidores.stream()
                    .filter(s -> s.getHostName() != null && s.getHostName().equalsIgnoreCase(hostProcurado))
                    .findFirst()
                    .orElse(null);

            if (hostAchado != null) {
                System.out.println("Informe o nome da sua CPU, será criada uma com configurações default em ambiente de homologação,");
                String nomeCpu = scanner.nextLine();
                Cpu cpuUsuario = new Cpu(nomeCpu, 16, 5, false);
                hostAchado.adicionaCpu(cpuUsuario);
                System.out.println("CPU criada e adicionada ao servidor informado");
            }
        } catch (Exception e) {
            System.out.println("ERRO - tente novamente");

        }
    }

    public void removerCpu(String hostname, String cpu) {
        try {

            List<Servidor> servidores = new ArrayList<>();
            servidores.add(servidor1);
            servidores.add(servidor2);
            servidores.add(servidor3);
            servidores.add(servidor4);
            servidores.add(servidor5);
            servidores.add(servidor6);
            servidores.add(servidor7);
            servidores.add(servidor8);
            servidores.add(servidor9);
            servidores.add(servidor10);
            servidores.add(servidor11);
            servidores.add(servidor12);
            servidores.add(servidor13);

            for (Servidor s : servidores) {
                if (s != null && hostname.equalsIgnoreCase(s.getHostName())) {

                    Cpu alvo = null;
                    for (Cpu c : s.getPoolCpus()) {
                        if (c.getModelo().equalsIgnoreCase(cpu)) {
                            alvo = c;
                            break;
                        }
                    }

                    if (alvo != null) {
                        s.getPoolCpus().remove(alvo);
                        alvo.setServidor(null);
                        System.out.println("CPU " + alvo.getModelo() + " removida de " + s.getHostName());
                    } else {
                        System.out.println("CPU " + cpu + " não encontrada em " + s.getHostName());
                    }
                    return; // achou o servidor: encerra o método
                }
            }


            System.out.println("Servidor não encontrado");
        } catch (Exception e) {
            System.out.println("ERRO - Tente novamente");
        }
    }

    public void buscaEmLargura() {
        try {
            grafo.buscaEmLargura();
        } catch (Exception e) {
            System.out.println("ERRO - Tente novamente");
            ;
        }

    }

    public void buscaEmProfundidade() {
        try {
            grafo.buscaEmProfundidade();
        } catch (Exception e) {
            System.out.println("ERRO - Tente novamente");
        }
    }

    public void criarServidores() {
        try {


            Cpu cpu1 = new Cpu("WebSphere-HML-01", 4, 2400, false);
            Cpu cpu2 = new Cpu("WebSphere-PRD-02", 8, 3000, true);
            Cpu cpu3 = new Cpu("WebSphere-HML-03", 4, 2600, false);
            Cpu cpu4 = new Cpu("WebSphere-PRD-04", 8, 3200, true);
            Cpu cpu5 = new Cpu("WebSphere-HML-05", 6, 2400, false);
            Cpu cpu6 = new Cpu("WebSphere-PRD-06", 12, 3000, true);
            Cpu cpu7 = new Cpu("WebSphere-HML-07", 4, 2800, false);
            Cpu cpu8 = new Cpu("WebSphere-PRD-08", 8, 3400, true);
            Cpu cpu9 = new Cpu("WebSphere-HML-09", 6, 2600, false);
            Cpu cpu10 = new Cpu("WebSphere-PRD-10", 12, 3200, true);
            Cpu cpu11 = new Cpu("WebSphere-HML-11", 4, 2400, false);
            Cpu cpu12 = new Cpu("WebSphere-PRD-12", 16, 3000, true);
            Cpu cpu13 = new Cpu("WebSphere-HML-13", 6, 2800, false);
            Cpu cpu14 = new Cpu("WebSphere-PRD-14", 8, 3400, true);
            Cpu cpu15 = new Cpu("WebSphere-HML-15", 4, 2600, false);
            Cpu cpu16 = new Cpu("WebSphere-PRD-16", 12, 3200, true);
            Cpu cpu17 = new Cpu("WebSphere-HML-17", 6, 2400, false);
            Cpu cpu18 = new Cpu("WebSphere-PRD-18", 16, 3000, true);
            Cpu cpu19 = new Cpu("WebSphere-HML-19", 4, 2800, false);
            Cpu cpu20 = new Cpu("WebSphere-PRD-20", 8, 3400, true);
            Cpu cpu21 = new Cpu("WebSphere-HML-21", 6, 2600, false);
            Cpu cpu22 = new Cpu("WebSphere-PRD-22", 12, 3200, true);
            Cpu cpu23 = new Cpu("WebSphere-HML-23", 4, 2400, false);
            Cpu cpu24 = new Cpu("WebSphere-PRD-24", 16, 3000, true);
            Cpu cpu25 = new Cpu("WebSphere-HML-25", 6, 2800, false);
            Cpu cpu26 = new Cpu("WebSphere-PRD-26", 8, 3400, true);
            Cpu cpu27 = new Cpu("WebSphere-HML-27", 4, 2600, false);
            Cpu cpu28 = new Cpu("WebSphere-PRD-28", 12, 3200, true);
            Cpu cpu29 = new Cpu("WebSphere-HML-29", 6, 2400, false);
            Cpu cpu30 = new Cpu("WebSphere-PRD-30", 16, 3000, true);


            servidor1 = new Servidor("Servi0101-prd", 16, true);
            servidor1.adicionaCpu(cpu2);
            servidor1.adicionaCpu(cpu4);
            servidor1.adicionaCpu(cpu6);
            cpu2.setServidor(servidor1);
            cpu4.setServidor(servidor1);
            cpu6.setServidor(servidor1);

            servidor1 = new Servidor("Servi0101-prd", 16, true);
            servidor1.adicionaCpu(cpu2);
            servidor1.adicionaCpu(cpu4);
            servidor1.adicionaCpu(cpu6);
            cpu2.setServidor(servidor1);
            cpu4.setServidor(servidor1);
            cpu6.setServidor(servidor1);

            servidor2 = new Servidor("Servi0102-prd", 16, true);
            servidor2.adicionaCpu(cpu8);
            servidor2.adicionaCpu(cpu10);
            servidor2.adicionaCpu(cpu12);
            cpu8.setServidor(servidor2);
            cpu10.setServidor(servidor2);
            cpu12.setServidor(servidor2);

            servidor3 = new Servidor("Servi0103-prd", 16, true);
            servidor3.adicionaCpu(cpu14);
            servidor3.adicionaCpu(cpu16);
            servidor3.adicionaCpu(cpu18);
            cpu14.setServidor(servidor3);
            cpu16.setServidor(servidor3);
            cpu18.setServidor(servidor3);

            servidor4 = new Servidor("Servi0104-prd", 16, true);
            servidor4.adicionaCpu(cpu20);
            servidor4.adicionaCpu(cpu22);
            servidor4.adicionaCpu(cpu24);
            cpu20.setServidor(servidor4);
            cpu22.setServidor(servidor4);
            cpu24.setServidor(servidor4);

            servidor5 = new Servidor("Servi0105-prd", 16, true);
            servidor5.adicionaCpu(cpu26);
            servidor5.adicionaCpu(cpu28);
            servidor5.adicionaCpu(cpu30);
            cpu26.setServidor(servidor5);
            cpu28.setServidor(servidor5);
            cpu30.setServidor(servidor5);

            servidor6 = new Servidor("Servi0106-hml", 16, false);
            servidor6.adicionaCpu(cpu1);
            servidor6.adicionaCpu(cpu3);
            servidor6.adicionaCpu(cpu5);
            cpu1.setServidor(servidor6);
            cpu3.setServidor(servidor6);
            cpu5.setServidor(servidor6);

            servidor7 = new Servidor("Servi0107-hml", 16, false);
            servidor7.adicionaCpu(cpu7);
            servidor7.adicionaCpu(cpu9);
            servidor7.adicionaCpu(cpu11);
            cpu7.setServidor(servidor7);
            cpu9.setServidor(servidor7);
            cpu11.setServidor(servidor7);

            servidor8 = new Servidor("Servi0108-hml", 16, false);
            servidor8.adicionaCpu(cpu13);
            servidor8.adicionaCpu(cpu15);
            servidor8.adicionaCpu(cpu17);
            cpu13.setServidor(servidor8);
            cpu15.setServidor(servidor8);
            cpu17.setServidor(servidor8);

            servidor9 = new Servidor("Servi0109-hml", 16, false);
            servidor9.adicionaCpu(cpu19);
            servidor9.adicionaCpu(cpu21);
            servidor9.adicionaCpu(cpu23);
            cpu19.setServidor(servidor9);
            cpu21.setServidor(servidor9);
            cpu23.setServidor(servidor9);

            servidor10 = new Servidor("Servi01010-hml", 16, false);
            servidor10.adicionaCpu(cpu25);
            servidor10.adicionaCpu(cpu27);
            servidor10.adicionaCpu(cpu29);
            cpu25.setServidor(servidor10);
            cpu27.setServidor(servidor10);
            cpu29.setServidor(servidor10);

            servidor11 = new Servidor("Servi01011-hml", 16, false);
            servidor12 = new Servidor("Servi01012-hml", 16, false);
            servidor13 = new Servidor("Servi01013-hml", 16, false);

            System.out.println("Servidores e CPUs criados com sucesso!");

        } catch (Exception e) {
            System.out.println("ERRO - Tente novamente");
        }
    }

    public void criarGrafos() {

        try {

            grafo.adicionarVertice(servidor1);
            grafo.adicionarVertice(servidor2);
            grafo.adicionarVertice(servidor3);
            grafo.adicionarVertice(servidor4);
            grafo.adicionarVertice(servidor5);
            grafo.adicionarVertice(servidor6);
            grafo.adicionarVertice(servidor7);
            grafo.adicionarVertice(servidor8);
            grafo.adicionarVertice(servidor9);
            grafo.adicionarVertice(servidor10);
            grafo.adicionarVertice(servidor11);
            grafo.adicionarVertice(servidor12);
            grafo.adicionarVertice(servidor13);


            grafo.adicionarAresta(12, servidor1, servidor4);
            grafo.adicionarAresta(4, servidor4, servidor2);
            grafo.adicionarAresta(1, servidor2, servidor3);
            grafo.adicionarAresta(8, servidor3, servidor5);
            grafo.adicionarAresta(16, servidor5, servidor6);
            grafo.adicionarAresta(5, servidor6, servidor7);
            grafo.adicionarAresta(6, servidor7, servidor8);
            grafo.adicionarAresta(4, servidor8, servidor9);
            grafo.adicionarAresta(6, servidor9, servidor10);
            grafo.adicionarAresta(1, servidor10, servidor11);
            grafo.adicionarAresta(0, servidor11, servidor12);
            grafo.adicionarAresta(1, servidor12, servidor13);

            System.out.println("Grafo criado com sucesso!");
        } catch (Exception e) {
            System.out.println("ERRO - Tente novamente");
        }

    }


}
