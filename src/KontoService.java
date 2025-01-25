package org.example;

import org.springframework.stereotype.Service;

@Service
public class KontoService {
    private final KontoStorage kontoStorage;

    public KontoService(KontoStorage kontoStorage) {
        this.kontoStorage = kontoStorage;
    }


    public Status Wpl(int idUser, double saldo, double przelewy) {
        double wynik = saldo - przelewy;
        {
            if (wynik < 0) {
                return Status.DECLINED;
            } else {
                return Status.ACCEPTED;
            }
        }
    }


    public Status Wyp(int idUser, double saldo, double przelewy) {
        double dodatek = saldo + przelewy;
        return Status.ACCEPTED;
    }

    public void Bank(int idUser, double saldo, double przelewy) {
        System.out.println("Numer klienta" + idUser + "Saldo: " + saldo);
    }
}
