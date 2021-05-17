package DTO;

import com.opencsv.bean.CsvBindByPosition;

public class Pessoa {
	@CsvBindByPosition(position = 4)
	private String nome;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("[nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
	
}
