package src.br.com.model;

public abstract class Apartamento {

	private int numero;
	private Diaria diaria;
	private int taxa;
	private char status;
	private int qtdCamas;

	public Apartamento(int numero, int qtdCamas) {
		this.numero = numero;
		this.qtdCamas = qtdCamas;
	}





}
