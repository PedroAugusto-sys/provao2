package model.veiculo;

public abstract class veiculo implements veiculoInterface {

    private String placa;
    private int ano;




    public int getPlaca() {
        return Integer.parseInt(placa);
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public veiculo() {
    }

    @Override
    public String exibirDados() {
        return "veiculo{" +
                "placa='" + placa + '\'' +
                ", ano=" + ano +
                '}';
    }

    public abstract String exibirdados();
}
