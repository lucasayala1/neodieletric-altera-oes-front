package model;

public class ImpactoIA {
    private String nomeModelo;        
    private double consumoEnergia;     
    private boolean usaEnergiaRenovavel; 
    private String aplicacao;         
    private double eficiencia;         

    public ImpactoIA(String nomeModelo, double consumoEnergia, boolean usaEnergiaRenovavel, String aplicacao) {
        this.nomeModelo = nomeModelo;
        this.consumoEnergia = consumoEnergia;
        this.usaEnergiaRenovavel = usaEnergiaRenovavel;
        this.aplicacao = aplicacao;
        this.eficiencia = 0; 
    }

    public ImpactoIA(String nomeModelo, double consumoEnergia, boolean usaEnergiaRenovavel, String aplicacao, double eficiencia) {
        this.nomeModelo = nomeModelo;
        this.consumoEnergia = consumoEnergia;
        this.usaEnergiaRenovavel = usaEnergiaRenovavel;
        this.aplicacao = aplicacao;
        this.eficiencia = eficiencia; 
    }

 
    public String getNomeModelo() {
        return nomeModelo;
    }

    public void setNomeModelo(String nomeModelo) {
        this.nomeModelo = nomeModelo;
    }

    public double getConsumoEnergia() {
        return consumoEnergia;
    }

    public void setConsumoEnergia(double consumoEnergia) {
        this.consumoEnergia = consumoEnergia;
    }

    public boolean isUsaEnergiaRenovavel() {
        return usaEnergiaRenovavel;
    }

    public void setUsaEnergiaRenovavel(boolean usaEnergiaRenovavel) {
        this.usaEnergiaRenovavel = usaEnergiaRenovavel;
    }

    public String getAplicacao() {
        return aplicacao;
    }

    public void setAplicacao(String aplicacao) {
        this.aplicacao = aplicacao;
    }

    public double getEficiencia() {
        return eficiencia;
    }

  
    public double getEmissaoBase() {
        double fator = usaEnergiaRenovavel ? 0.05 : 0.233; 
        return consumoEnergia * fator;
    }

   
    public double getEmissaoOtimizada() {
        return getEmissaoBase() * (1 - eficiencia / 100);
    }

 
    public void aplicarOtimizacao(double percentual) {
        if (percentual >= 0 && percentual <= 100) {
            this.eficiencia = percentual;
        }
    }

    @Override
    public String toString() {
        return "ImpactoIA{" +
                "nomeModelo='" + nomeModelo + '\'' +
                ", consumoEnergia=" + consumoEnergia +
                ", usaEnergiaRenovavel=" + usaEnergiaRenovavel +
                ", aplicacao='" + aplicacao + '\'' +
                ", eficiencia=" + eficiencia +
                '}';
    }
}
