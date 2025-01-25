package org.example;

public class Operacje {
    private Konto konto;
    private double przelewy;
    private Status status;

    public Operacje(Konto konto, double przelewy, Status status) {
        this.konto = konto;
        this.przelewy = przelewy;
        this.status = status;
    }

    public Konto getKonto() {
        return konto;
    }

    public void setKonto(Konto konto) {
        this.konto = konto;
    }

    public double getPrzelewy() {
        return przelewy;
    }

    public void setPrzelewy(double przelewy) {
        this.przelewy = przelewy;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}