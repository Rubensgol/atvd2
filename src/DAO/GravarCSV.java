package DAO;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

import DTO.Aluno;
import BO.Gravacao;

public class GravarCSV implements Gravacao {

	@Override
	public boolean inserir(List<Aluno> alunos) {
		Writer writer;

		try {
			writer = Files.newBufferedWriter(Paths.get("alunos.csv"));
			StatefulBeanToCsv<Aluno> beanToCsv = new StatefulBeanToCsvBuilder(writer).build();
			beanToCsv.write(alunos);
			writer.flush();
			writer.close();
			return true;
		} catch (CsvDataTypeMismatchException | CsvRequiredFieldEmptyException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;
	}

	@Override
	public List<Aluno> pesquisarTodos() {
		Reader reader;
		try {
			reader = Files.newBufferedReader(Paths.get("alunos.csv"));
			CsvToBean<Aluno> csvToBean = new CsvToBeanBuilder(reader).withType(Aluno.class).build();

			List<Aluno> alunos = csvToBean.parse();
			return alunos;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
