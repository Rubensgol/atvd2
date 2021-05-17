package persistencia;

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

public class GravarCSV implements Gravacao {

	@Override
	public boolean gravar(List<Aluno> alunos) {
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
	public List<Aluno> ler() {
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

}
