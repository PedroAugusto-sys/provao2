package model.dao;

import model.dao.util.ConnectionFactory;
import model.veiculo.veiculo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class veiculoDao {

    Connection con;
    private Statement statement;
    private PreparedStatement preparedStatement;

    public veiculoDao(){
        ConnectionFactory connectionFactory = new ConnectionFactory();
        con = connectionFactory.getConnection();
    }


    public boolean inserirveiculo(veiculo veiculo){
        boolean isSalvo = false;
        String query = "insert into veiculo (placa,ano)"
                + "values(?,?)";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, veiculo.getAno());
            preparedStatement.setInt(2, veiculo.getPlaca());
            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao inserir veiculo "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }


    public List<veiculo> listarveiculo(){
        List<veiculo> veiculos = new ArrayList();
        ResultSet set;

        try{
            statement = con.createStatement();
            set = statement.executeQuery("select * from veiculos:");
            while(set.next()){
                veiculo veiculo = new veiculo() {
                    @Override
                    public String exibirdados() {
                        return null;
                    }
                };
                veiculo.setPlaca(set.getString("placa"));



                veiculos.add(veiculo);

            }
        }catch (Exception e){
            System.err.println("erro ao listar veículos: "+ e.getMessage());
        }

        return veiculos;
    }


    public boolean atulaizarVeiculo(veiculo veiculo){
        boolean isSalvo = false;
        String query = "update veiculos set placa = ?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, veiculo.getPlaca());

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao atualizar veiculos "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }


    public boolean deletarVeiculo(int placa){
        boolean isSalvo = false;
        String query = "delete from veiculos where placa =?";
        try {
            con.setAutoCommit(false);
            preparedStatement = con.prepareStatement(query);
            preparedStatement.setInt(1, placa);

            preparedStatement.executeUpdate();
            con.commit();
            isSalvo = true;
        }catch (Exception e){
            System.err.println("Erro ao deletar veiculo "+ e.getMessage());
            isSalvo = false;
        }

        return isSalvo;
    }












}
