package persistencia;

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

import DTO.Aluno;

public class GravarJSON implements Gravacao{
	@Override
	public boolean gravar(List<Aluno> alunos) {
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
	public List<Aluno> ler() {
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


}
