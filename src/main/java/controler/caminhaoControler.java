package controler;

import model.caminhao.caminhao;
import model.dao.caminhaoDao;

import java.util.List;

public class caminhaoControler {



    caminhaoDao caminhaoDao;
    public List<caminhao> listarCaminhoes() {

        caminhaoDao = new caminhaoDao();
        List<caminhao> listarCaminhoes;
        return listarCaminhoes = caminhaoDao.listarCaminhao();
    }
    public boolean salvarCaminhao( caminhao caminhao ){
        caminhaoDao = new caminhaoDao();
        boolean isSalvo = caminhaoDao.inserirCaminhao(caminhao);
        return isSalvo;
    }
    public boolean editCaminhao( caminhao caminhao){
        caminhaoDao = new caminhaoDao();
        boolean isSalvo =  caminhaoDao.atulaizarCaminhao(caminhao);
        return isSalvo;
    }

    public boolean deletarCaminhao( int eixos ){
        caminhaoDao = new caminhaoDao();
        boolean isSalvo = caminhaoDao.deletarCaminhao(eixos);
        return isSalvo;
    }





}
