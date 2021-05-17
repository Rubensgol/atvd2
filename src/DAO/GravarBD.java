package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DTO.Aluno;
import conexao.*;
import BO.Gravacao;
import BO.DataUtil;

public class GravarBD implements Gravacao {

    private final String NOMEDATABELA = "aluno";

    @Override
    public boolean inserir(List<Aluno> alunos) {

        for (Aluno aluno : alunos) {

            try {
                Connection conn = Conexao.conectar();
                String sql = "INSERT INTO " + NOMEDATABELA
                        + " (cpf,email,matricula,Pessoa_nome,dataNascimento) VALUES (?,?,?,?,?);";
                PreparedStatement ps = conn.prepareStatement(sql);

                ps.setString(1, aluno.getCPF());
                ps.setString(2, aluno.getEmail());
                ps.setString(3, aluno.getMatricula());
                ps.setString(4, aluno.getNome());
                ps.setString(5, DataUtil.DataForStringMySQL(aluno.getDataNascimento()));
                ps.executeUpdate();
                ps.close();
                conn.close();
                
            } catch (Exception e) {
                System.err.println("Erro: " + e.toString());
                e.printStackTrace();
                return false;
            }
        }
        return true;
    }

    @Override
    public List<Aluno> pesquisarTodos() {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + ";";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            List<Aluno> listObj = montarLista(rs);
            return listObj;
        } catch (Exception e) {
            // System.err.println("Erro: " + e.toString());
            // e.printStackTrace();
            return null;
        }
    }

    public List<Aluno> montarLista(ResultSet rs) {
        List<Aluno> listObj = new ArrayList<Aluno>();
        try {
            while (rs.next()) {
                Aluno obj = new Aluno();
                obj.setNome(rs.getString("Pessoa_nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setMatricula(rs.getString("matricula"));
                obj.setDataNascimento(DataUtil.DataMySQLHoraDia(rs.getString("dataNascimento")));
                listObj.add(obj);
            }
            return listObj;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public boolean inserir(Aluno aluno) {

        try {
            Connection conn = Conexao.conectar();
            String sql = "INSERT INTO " + NOMEDATABELA
                    + " (cpf,email,matricula,Pessoa_nome,dataNascimento) VALUES (?,?,?,?,?);";
            PreparedStatement ps = conn.prepareStatement(sql);

            ps.setString(1, aluno.getCPF());
            ps.setString(2, aluno.getEmail());
            ps.setString(3, aluno.getMatricula());
            ps.setString(4, aluno.getNome());
            ps.setString(5, DataUtil.DataForStringMySQL(aluno.getDataNascimento()));
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            System.err.println("Erro: " + e.toString());
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean alterar(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "UPDATE " + NOMEDATABELA + " SET email = ? WHERE matricula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getEmail());
            ps.setString(2, aluno.getMatricula());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            // System.err.println("Erro: " + e.toString());
            // e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean excluir(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "DELETE FROM " + NOMEDATABELA + " WHERE matricula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getMatricula());
            ps.executeUpdate();
            ps.close();
            conn.close();
            return true;
        } catch (Exception e) {
            // System.err.println("Erro: " + e.toString());
            // e.printStackTrace();
            return false;
        }
    }

    @Override
    public Aluno procurarPorMatricula(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE matricula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getMatricula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aluno obj = new Aluno();
                obj.setNome(rs.getString("Pessoa_nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setMatricula(rs.getString("matricula"));
                obj.setDataNascimento(DataUtil.DataMySQLHoraDia(rs.getString("dataNascimento")));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Aluno procurarPoremail(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE email = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getEmail());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Aluno obj = new Aluno();
                obj.setNome(rs.getString("Pessoa_nome"));
                obj.setCPF(rs.getString("cpf"));
                obj.setEmail(rs.getString("email"));
                obj.setMatricula(rs.getString("matricula"));
                obj.setDataNascimento(DataUtil.DataMySQLHoraDia(rs.getString("dataNascimento")));
                ps.close();
                rs.close();
                conn.close();
                return obj;
            } else {
                ps.close();
                rs.close();
                conn.close();
                return null;
            }
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public boolean existe(Aluno aluno) {
        try {
            Connection conn = Conexao.conectar();
            String sql = "SELECT * FROM " + NOMEDATABELA + " WHERE matricula = ?;";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, aluno.getMatricula());
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                ps.close();
                rs.close();
                conn.close();
                return true;
            }
        } catch (Exception e) {
            // System.err.println("Erro: " + e.toString());
            // e.printStackTrace();
            return false;
        }
        return false;
    }
    

}
