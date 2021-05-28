package model.dao;

import model.caminhao.caminhao;
import model.dao.util.ConnectionFactory;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class caminhaoDao {
    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public caminhaoDao(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }


    public boolean inserirCaminhao(caminhao caminhao){
        boolean isSalvo = false;
        String query = "insert into caminhao (eixos)"
                + "values(?)";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, caminhao.getEixos());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao inserir Caminhão "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }


    public List<caminhao> listarCaminhao(){
        List<caminhao> caminhoes = new ArrayList();
        ResultSet set;

        try{
            statement = con.createStatement();
            set = statement.executeQuery("select * from caminhao:");
            while(set.next()){
                caminhao caminhao = new caminhao();
                caminhao.setEixos(set.getInt("eixos"));

                caminhoes.add(caminhao);

            }
        }catch (Exception e){
            System.err.println("erro ao listar caminhões:"+ e.getMessage());
        }

        return caminhoes;
    }


    public boolean atulaizarCaminhao(caminhao caminhao){
        boolean isSalvo = false;
        String query = "update caminhao set eixos = ?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, caminhao.getEixos());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao atualizar caminhão "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }


    public boolean deletarCaminhao(int eixos){
        boolean isSalvo = false;
        String query = "delete from caminhao where eixos =?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, eixos);

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao deletar Caminhão "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }






}
