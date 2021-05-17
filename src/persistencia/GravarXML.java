package persistencia;

import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import DTO.Aluno;

public class GravarXML implements Gravacao{
	@Override
	public boolean inserir(List<Aluno> alunos) {
		try{
			FileOutputStream fos = new FileOutputStream("alunos.xml", true);
			BufferedOutputStream buff = new BufferedOutputStream(fos);
			XMLEncoder xml = new XMLEncoder(buff);
			xml.writeObject(alunos);
			xml.close();
			
			return true;
		}catch (IOException e) {
				return false;
			}
	}

	@Override
	public List<Aluno> pesquisarTodos() {
		try {
			List<Aluno> lista = new ArrayList<Aluno>();
			FileInputStream fis = new FileInputStream("alunos.xml");
			BufferedInputStream buff = new BufferedInputStream(fis);
			XMLDecoder xml = new XMLDecoder(buff);
			lista = (List<Aluno>) xml.readObject();
			xml.close();
		    	return lista;
		    } catch(IOException e) {
		    	System.err.printf("Erro na Abertura do Arquivo: %s. \n", e.getMessage());
		    	return null;
		    }
	}
	@Override
	public boolean inserir(Aluno aluno) {
		List<Aluno> alunos = pesquisarTodos();
		alunos.add(aluno);
		if (inserir(alunos))
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
