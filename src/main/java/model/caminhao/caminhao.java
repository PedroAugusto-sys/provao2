package model.caminhao;

import model.veiculo.veiculo;

public class caminhao extends veiculo {
    private int eixos;


    public int getEixos() {
        return eixos;
    }

    public void setEixos(int eixos) {
        this.eixos = eixos;
    }


    @Override
    public String exibirdados() {
        return "caminhao{" +
                "eixos=" + eixos +
                '}';
    }


}







