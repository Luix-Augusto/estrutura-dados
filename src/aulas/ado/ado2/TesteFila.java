package aulas.ado.ado2;

import java.util.Scanner;

public class TesteFila {

    public static void main(String[] args) {
        Fila fila = new Fila();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            exibirMenu();
            opcao = lerOpcao(scanner);

            switch (opcao) {
                case 1:
                    solicitarSenha(scanner, fila);
                    break;
                case 2:
                    listarSenhas(fila);
                    break;
                case 3:
                    espiarFila(fila);
                    break;
                case 4:
                    chamarProximo(fila);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema. Até logo!");
                    break;
                default:
                    System.out.println("Opção inválida! Tente novamente.");
            }
            System.out.println();
        } while (opcao != 0);

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("===== LABORATÓRIO - CONTROLE DE FILA DE ATENDIMENTO =====");
        System.out.println("1 - Solicitar senha (Normal ou Prioridade)");
        System.out.println("2 - Listar todas as senhas");
        System.out.println("3 - Espiar a fila (próximo a ser chamado)");
        System.out.println("4 - Chamar próximo paciente (remove da fila)");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");
    }

    private static int lerOpcao(Scanner scanner) {
        try {
            return Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    private static void solicitarSenha(Scanner scanner, Fila fila) {
        System.out.print("Nome do paciente: ");
        String nome = scanner.nextLine().trim();

        System.out.println("Tipo de atendimento:");
        System.out.println("1 - Normal");
        System.out.println("2 - Prioridade");
        System.out.print("Escolha: ");
        int tipoOpcao = lerOpcao(scanner);

        TipoPaciente tipo = (tipoOpcao == 2) ? TipoPaciente.PRIORITARIO : TipoPaciente.NORMAL;

        Paciente paciente = new Paciente(nome, tipo);
        fila.enfileira(paciente);

        System.out.println("Senha gerada: " + paciente.getSenhaFormatada());
    }

    private static void listarSenhas(Fila fila) {
        if (fila.estaVazia()) {
            System.out.println("Não há senhas na fila.");
            return;
        }
        System.out.println("----- Senhas na fila (ordem de chegada) -----");
        Object[] todos = fila.listarTodos();
        for (int i = 0; i < todos.length; i++) {
            System.out.println((i + 1) + ". " + todos[i]);
        }
    }

    private static void espiarFila(Fila fila) {
        Paciente proximo = fila.espiarProximoAtendimento();
        if (proximo == null) {
            System.out.println("A fila está vazia.");
        } else {
            System.out.println("Próximo a ser chamado: " + proximo);
        }
    }

    private static void chamarProximo(Fila fila) {
        Paciente chamado = fila.chamarProximo();
        if (chamado == null) {
            System.out.println("Não há pacientes para chamar.");
        } else {
            System.out.println("Chamando: " + chamado);
        }
    }
}