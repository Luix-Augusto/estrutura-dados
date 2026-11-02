package aulas.ado.ado3;

public class Cpu {

    private String modelo;

    private Integer nucleos;

    private Integer frequencia;

    private Servidor servidor;

    public Cpu(String modelo, Integer nucleos, Integer frequencia, Servidor servidor) {
        this.modelo = modelo;
        this.nucleos = nucleos;
        this.frequencia = frequencia;
        this.servidor = servidor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getNucleos() {
        return nucleos;
    }

    public void setNucleos(Integer nucleos) {
        this.nucleos = nucleos;
    }

    public Integer getFrequencia() {
        return frequencia;
    }

    public void setFrequencia(Integer frequencia) {
        this.frequencia = frequencia;
    }

    public Servidor getServidor() {
        return servidor;
    }

    public void setServidor(Servidor servidor) {
        this.servidor = servidor;
    }

    @Override
    public String toString() {
        return "CPU: " +
                "modelo - " + modelo +
                ", nucleos - " + nucleos +
                ", frequencia - " + frequencia +
                ", servidor - " + servidor;
    }
}
