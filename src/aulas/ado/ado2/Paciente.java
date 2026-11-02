package aulas.ado.ado2;

public class Paciente {

    private static int proximaSenhaNormal = 1;
    private static int proximaSenhaPrioritaria = 1;

    private String nome;
    private int senha;
    private TipoPaciente tipo;

    public Paciente(String nome, TipoPaciente tipo) {
        this.nome = nome;
        this.tipo = tipo;
        if (tipo == TipoPaciente.PRIORITARIO) {
            this.senha = proximaSenhaPrioritaria++;
        } else {
            this.senha = proximaSenhaNormal++;
        }
    }

    public String getNome() {
        return nome;
    }

    public int getSenha() {
        return senha;
    }

    public TipoPaciente getTipo() {
        return tipo;
    }

    public String getSenhaFormatada() {
        String prefixo = (tipo == TipoPaciente.PRIORITARIO) ? "P" : "N";
        return prefixo + String.format("%03d", senha);
    }

    @Override
    public String toString() {
        String tipoDescricao = (tipo == TipoPaciente.PRIORITARIO) ? "Prioritário" : "Normal";
        return "Senha " + getSenhaFormatada() + " - " + nome + " (" + tipoDescricao + ")";
    }
}