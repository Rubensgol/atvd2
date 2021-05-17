package DAO;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import BO.Gravacao;
import DTO.Aluno;


public class GravarJSON implements Gravacao{
	@Override
	public boolean inserir(List<Aluno> alunos) {
		GsonBuilder builder = new GsonBuilder();
	    Gson gson = builder.create();
	    FileWriter writer;
		try {
			writer = new FileWriter("alunos.json");
			writer.write(gson.toJson(alunos));
			writer.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    return true;
		
	}

	@Override
	public List<Aluno> pesquisarTodos() {
		BufferedReader bufferedReader;
		try {
			bufferedReader = new BufferedReader(new FileReader("alunos.json"));
			  Type listType = new TypeToken<ArrayList<Aluno>>(){}.getType();

			    List<Aluno> lista = new ArrayList<Aluno>();
			   
			    return lista = new Gson().fromJson(bufferedReader, listType);
			
		} catch (FileNotFoundException e) {
			return null;

		}

		  

	}

	@Override
	public boolean inserir(Aluno aluno) {
		List<Aluno> lista =pesquisarTodos();
		if(lista.add(aluno))
			return true;
		return false;
	}

	@Override
	public boolean alterar(Aluno aluno) {
		List<Aluno> alunos = pesquisarTodos();
		for (Aluno aluno2 : alunos) {
			if (aluno2.getCPF().equals(aluno.getCPF())) {
				aluno2 = aluno;
				break;
			}

		}
		if (inserir(alunos)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean excluir(Aluno aluno) {
		List<Aluno> alunos = pesquisarTodos();
		for (Aluno aluno2 : alunos) {
			if (aluno2.getCPF().equals(aluno.getCPF())) {
				alunos.remove(aluno2);
				break;
			}

		}
		if (inserir(alunos)) {
			return true;
		}
		return false;
	}

	@Override
	public Aluno procurarPorMatricula(Aluno aluno) {
		List<Aluno> alunos = pesquisarTodos();
		for (Aluno aluno2 : alunos) {
			if (aluno2.getMatricula().equals(aluno.getMatricula())) {
				return aluno2;
			}
		}
		return null;
	}

	@Override
	public Aluno procurarPoremail(Aluno aluno) {
		List<Aluno> alunos = pesquisarTodos();
		for (Aluno aluno2 : alunos) {
			if (aluno2.getEmail().equals(aluno.getEmail())) {
				return aluno2;
			}
		}
		return null;
	}

	@Override
	public boolean existe(Aluno aluno) {
		List<Aluno> alunos = pesquisarTodos();
		for (Aluno aluno2 : alunos) {
			if (aluno2.getMatricula().equals(aluno.getMatricula())) {
				return true;
			}
		}
		return false;
	}


}
