package persistencia;

import java.util.List;

import DTO.Aluno;

public class Persistencia {

private Gravacao gravacao;
	
	public Persistencia(Gravacao gravacao) {
		this.gravacao = gravacao;
	}
	
	public boolean gravar(List<Aluno> alunos) {
		return gravacao.gravar(alunos);
		
	}
	public List<Aluno> ler(){
		return gravacao.ler();
	}
}
