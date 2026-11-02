package aulas.ado.ado3;

import java.util.ArrayList;

public class Servidor {

    private String hostName;

    private int capacidadeMaxCpus;

    private int memoriaRam;

    private List<Cpu> poolCpus;

    public Servidor(String hostName, int capacidadeMaxCpus, int memoriaRam) {
        this.hostName = hostName;
        this.capacidadeMaxCpus = capacidadeMaxCpus;
        this.memoriaRam = memoriaRam;
        this.poolCpus = new ArrayList<>();
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public int getCapacidadeMaxCpus() {
        return capacidadeMaxCpus;
    }

    public void setCapacidadeMaxCpus(int capacidadeMaxCpus) {
        this.capacidadeMaxCpus = capacidadeMaxCpus;
    }

    public int getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(int memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public List<Cpu> getPoolCpus() {
        return poolCpus;
    }

    public void setPoolCpus(List<Cpu> poolCpus) {
        this.poolCpus = poolCpus;
    }

    @Override
    public String toString() {
        return "Servidor: " +
                "hostName - " + hostName +
                ", capacidade máxima de conexões - " + capacidadeMaxCpus +
                ", armazenamento - =" + memoriaRam +
                ", CPUs - " + poolCpus;
    }


}
