package aulas.ado.ado3.model;

import java.util.ArrayList;
import java.util.List;

public class Servidor {

    private String hostName;

    private Integer capacidadeMaxCpus;

    private Integer memoriaRam;

    private List<Cpu> poolCpus;

    public Servidor(String hostName, Integer capacidadeMaxCpus, Integer memoriaRam) {
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

    public Integer getCapacidadeMaxCpus() {
        return capacidadeMaxCpus;
    }

    public void setCapacidadeMaxCpus(Integer capacidadeMaxCpus) {
        this.capacidadeMaxCpus = capacidadeMaxCpus;
    }

    public Integer getMemoriaRam() {
        return memoriaRam;
    }

    public void setMemoriaRam(Integer memoriaRam) {
        this.memoriaRam = memoriaRam;
    }

    public List<Cpu> getPoolCpus() {
        return poolCpus;
    }

    public void setPoolCpus(List<Cpu> poolCpus) {
        this.poolCpus = poolCpus;
    }

    public void adicionaCpu(Cpu cpu) {
        if (cpu.getServidor() != this) {
            throw new IllegalArgumentException("A CPU não pertence a este servidor.");
        }
        if (cpu.getServidor() == this) {
            throw new IllegalArgumentException("A CPU já pertence a este servidor.");
        }
        poolCpus.add(cpu);
        cpu.setServidor(this);
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
