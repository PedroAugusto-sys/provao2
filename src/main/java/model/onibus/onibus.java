package model.onibus;

import model.veiculo.veiculo;

public class onibus extends veiculo {

    private int assentos;



    public int getAssentos() {
        return assentos;
    }

    public void setAssentos(int assentos) {
        this.assentos = assentos;
    }




    @Override
    public String exibirdados() {
        System.out.println("Eixos: " + assentos);
        System.out.println("Placa: "+ super.getPlaca());
        System.out.println("Assentos: " + getAssentos());


        return null;
    }





}
