package BO;

import java.util.List;

import DTO.Aluno;

public class Persistencia {

private Gravacao gravacao;
	
	public Persistencia(Gravacao gravacao) {
		this.gravacao = gravacao;
	}
	
	public boolean inserir(List<Aluno> alunos) {
		return gravacao.inserir(alunos);
		
	}
	public List<Aluno> lerTodos(){
		return gravacao.pesquisarTodos();
	}
	public boolean isenrir(Aluno aluno){
		return gravacao.inserir(aluno);
	}
	public boolean alterar(Aluno aluno){
		return gravacao.alterar(aluno);
	}
	public boolean excluir(Aluno aluno){
		return gravacao.excluir(aluno);
	}
	public Aluno procuraMatricula(Aluno aluno){
		return gravacao.procurarPorMatricula(aluno);
	}
	public Aluno procuraEmail(Aluno aluno){
		return gravacao.procurarPoremail(aluno);
	}
	public boolean existe(Aluno aluno){
		return gravacao.existe(aluno);
	}
}
