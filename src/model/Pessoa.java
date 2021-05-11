package model;

public class Pessoa {
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
		builder.append("Pai [nome=");
		builder.append(nome);
		builder.append("]");
		return builder.toString();
	}
	
}
