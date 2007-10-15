package src.br.com.model;

public class Servico {

	private String nome;

	private double valor;

	// Construtor
	public Servico(String nome, double valor) {
		this.nome = nome;
		this.valor = valor;
	}

	// Métodos Básicos
	public String getNome() {
		return nome;
	}

	public double getValor() {
		return valor;
	}

}