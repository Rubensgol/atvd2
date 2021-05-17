package DTO;

import java.util.Date;

import com.opencsv.bean.CsvBindByPosition;
import com.opencsv.bean.CsvDate;

public class Aluno extends Pessoa {
	@CsvBindByPosition(position = 3)
	private String matricula;
	
	@CsvBindByPosition(position = 2)
	private String CPF;
	
	@CsvDate(value = "yyyy-MM-dd")
	@CsvBindByPosition(position = 0)
	private Date dataNascimento;
	
	@CsvBindByPosition(position = 1)
	private String email;
	public String getMatricula() {
		return matricula;
	}
	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}
	public String getCPF() {
		return CPF;
	}
	public void setCPF(String cPF) {
		CPF = cPF;
	}
	public Date getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Aluno [matricula=");
		builder.append(matricula);
		builder.append(", CPF=");
		builder.append(CPF);
		builder.append(", dataNascimento=");
		builder.append(dataNascimento);
		builder.append(", email=");
		builder.append(email);
		builder.append(", getNome()=");
		builder.append(getNome());
		builder.append("]");
		return builder.toString();
	}
	
		
}
