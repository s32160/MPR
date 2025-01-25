
Public class Konto {
    private int idUser;
    private double saldo;

    public Konto(int idUser, double saldo) {
        this.idUser = idUser;
        this.saldo = saldo;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
}
