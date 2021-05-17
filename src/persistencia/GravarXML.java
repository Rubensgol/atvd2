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
	public boolean gravar(List<Aluno> alunos) {
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
	public List<Aluno> ler() {
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
}
