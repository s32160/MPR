package org.example;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class KontoStorage {
    private List<Konto> kontoList;


    public KontoStorage() {
        this.kontoList = new ArrayList<>();
    }

    public void addKonto(Konto konto) {
        kontoList.add(konto);
    }

    public List<Konto> getKontoList() {
        return kontoList;
    }

}