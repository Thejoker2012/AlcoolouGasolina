package br.com.unisys.domain;

import java.io.Serializable;

public class Combustivel implements Serializable {

    Float valorDoAlcool;
    Float valorDaGasolina;

    public Combustivel(){

    }

    public Float getValorDoAlcool() {
        return valorDoAlcool;
    }

    public void setValorDoAlcool(Float valorDoAlcool) {
        this.valorDoAlcool = valorDoAlcool;
    }

    public Float getValorDaGasolina() {
        return valorDaGasolina;
    }

    public void setValorDaGasolina(Float valorDaGasolina) {
        this.valorDaGasolina = valorDaGasolina;
    }

}
