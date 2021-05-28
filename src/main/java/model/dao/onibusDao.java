package model.dao;

import model.caminhao.caminhao;
import model.dao.util.ConnectionFactory;
import model.onibus.onibus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class onibusDao {
    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public onibusDao(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }


    public boolean inserirOnibus(onibus onibus){
        boolean isSalvo = false;
        String query = "insert into onibus (assentos)"
                + "values(?)";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, onibus.getAssentos());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao inserir Onibus "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }


    public List<onibus> listarOnibus(){
        ArrayList onibusList = new ArrayList();
        ResultSet set;

        try{
            statement = con.createStatement();
            set = statement.executeQuery("select * from onibus:");
            while(set.next()){
                caminhao caminhao = new caminhao();
                caminhao.setEixos(set.getInt("eixos"));

                onibusList.add(caminhao);

            }
        }catch (Exception e){
            System.err.println("erro ao listar onibus: "+ e.getMessage());
        }

        return onibusList;
    }


    public boolean atulaizarOnibus(onibus onibus){
        boolean isSalvo = false;
        String query = "update onibus set eixos = ?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, onibus.getAssentos());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao atualizar Onibus "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }


    public boolean deletarOnibus(int assentos){
        boolean isSalvo = false;
        String query = "delete from onibus where eixos =?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, assentos);

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao deletar Onibus "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }







}
