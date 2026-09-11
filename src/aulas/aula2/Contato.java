package aulas.aula2;

public class Contato {
    private String nome;
    private String telefone;
    private String email;

    public Contato() {
    }

    public Contato(String email, String telefone, String nome) {
        this.email = email;
        this.telefone = telefone;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Contato:" +
                "nome =" + nome +
                ", telefone = " + telefone +
                ", email = " + email;
    }
}
