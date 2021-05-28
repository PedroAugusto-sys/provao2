package controler;

import model.dao.onibusDao;
import model.onibus.onibus;

import java.util.List;

public class onibusControler {

  onibusDao onibusDao;

    public List<onibus> listarOnibus() {

        onibusDao = new onibusDao();
        List<onibus> onibusList;
        return onibusList = onibusDao.listarOnibus();
    }
    public boolean salvarOnibus(onibus onibus){
        onibusDao = new onibusDao();
        boolean isSalvo = onibusDao.inserirOnibus(onibus);
        return isSalvo;
    }
    public boolean editOnibus(onibus onibus){
        onibusDao = new onibusDao();
        boolean isSalvo =  onibusDao.atulaizarOnibus(onibus);
        return isSalvo;
    }

    public boolean deletarVeiculo( int placa ){
        onibusDao = new onibusDao();
        boolean isSalvo = onibusDao.deletarOnibus(placa);
        return isSalvo;
    }









}
