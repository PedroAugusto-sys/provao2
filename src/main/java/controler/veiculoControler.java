package controler;

import model.dao.veiculoDao;
import model.veiculo.veiculo;

import java.util.List;

public class veiculoControler {
   veiculoDao veiculoDao;

    public List<veiculo> listarVeiculos() {

        veiculoDao = new veiculoDao();
        List<veiculo> veiculoList;
        return veiculoList =
                veiculoDao.listarveiculo();
    }
    public boolean salvarVeiculo( veiculo veiculo){
        veiculoDao = new veiculoDao();
        boolean isSalvo = veiculoDao.inserirveiculo(veiculo);
        return isSalvo;
    }
    public boolean editVeiculo( veiculo veiculo){
        veiculoDao = new veiculoDao();
        boolean isSalvo =  veiculoDao.atulaizarVeiculo(veiculo);
        return isSalvo;
    }

    public boolean deletarVeiculo( int id ){
        veiculoDao = new veiculoDao();
        boolean isSalvo = veiculoDao.deletarVeiculo(id);
        return isSalvo;
    }


}
