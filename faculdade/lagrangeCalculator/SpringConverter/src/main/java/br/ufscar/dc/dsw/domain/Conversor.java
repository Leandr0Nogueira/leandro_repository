package br.ufscar.dc.dsw.domain;
public class Conversor {
    private int cels;
    private double fahr;

    public Conversor(int cels, double fahr) {
        this.cels = cels;
        this.fahr = fahr;
    }

    public int getCels() {
        return cels;
    }

    public void setCels(int cels) {
        this.cels = cels;
    }

    public double getFahr() {
        return fahr;
    }

    public void setFahr(int fahr) {
        this.fahr = fahr;
    }
}
