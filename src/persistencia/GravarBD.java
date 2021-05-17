package persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import DTO.Aluno;
import Util.Conexao;
import Util.DataUtil;

public class GravarBD implements Gravacao {

    @Override
    public boolean gravar(List<Aluno> alunos) {
        final String NOMEDATABELA = "aluno";

        for (Aluno aluno : alunos) {

            try {
                Connection conn = Conexao.conectar();
                String sql = "INSERT INTO " + NOMEDATABELA + " (cpf,email,matricula,Pessoa_nome,dataNascimento) VALUES (?,?,?,?,?);";
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
        return false;
    }

    @Override
    public List<Aluno> ler() {
        // TODO Auto-generated method stub
        return null;
    }

}
