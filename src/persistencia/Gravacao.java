package persistencia;

import java.util.List;

import DTO.Aluno;

public interface Gravacao {
	public boolean gravar(List<Aluno> alunos);
	public List<Aluno> ler();

}
