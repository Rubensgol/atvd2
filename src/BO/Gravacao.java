package BO;

import java.util.List;

import DTO.Aluno;

public interface Gravacao {
	public boolean inserir(List<Aluno> alunos);
	public List<Aluno> pesquisarTodos();
	public boolean inserir(Aluno aluno);
	public boolean alterar(Aluno aluno);
	public boolean excluir(Aluno aluno);
	public Aluno procurarPorMatricula(Aluno aluno);
	public Aluno procurarPoremail(Aluno aluno);
	public boolean existe(Aluno aluno);
}
