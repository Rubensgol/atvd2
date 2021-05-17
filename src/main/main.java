package main;

import persistencia.Gravacao;
import persistencia.GravarBD;
import persistencia.GravarCSV;
import persistencia.GravarJSON;
import persistencia.GravarXML;
import persistencia.Persistencia;

import java.util.ArrayList;

import DTO.Aluno;
import Util.DataUtil;

public class main {

	public static void main(String[] args) {

		ArrayList<Aluno> alunos = new ArrayList<Aluno>();
		// Aluno aluno = new Aluno();
		// aluno.setNome("Rubens Silva Lima");
		// aluno.setCPF("12593099755");
		// aluno.setDataNascimento(DataUtil.StrTodate("16/02/1997"));
		// aluno.setEmail("rubenssilva905@gmail.com");
		// aluno.setMatricula("2017001212");
		// alunos.add(aluno);

		// aluno = new Aluno();
		// aluno.setNome("Aramis Silva Lima");
		// aluno.setCPF("9309923293");
		// aluno.setDataNascimento(DataUtil.StrTodate("15/8/1998"));
		// aluno.setEmail("aralis.silva@hotmail.com");
		// aluno.setMatricula("2017001332");
		// alunos.add(aluno);

		Gravacao gravar = new GravarBD();
		Persistencia pers = new Persistencia(gravar);
		alunos=(ArrayList<Aluno>) pers.ler();
		System.out.println("parouu");
	
	}

}
