package src.br.com.model;

import java.util.Date;

public class Temporada {

	private String nome;

	private Date inicio;

	private Date fim;

	private int taxa;

	private char tipo;

	public Temporada(String nome, Date inicio, Date fim, int taxa, char tipo) {
		this.nome = nome;
		this.inicio = inicio;
		this.fim = fim;
		this.taxa = taxa;
		this.tipo = tipo;
	}

	/**
	 * @return the fim
	 */
	public Date getFim() {
		return fim;
	}

	/**
	 * @return the inicio
	 */
	public Date getInicio() {
		return inicio;
	}

	/**
	 * @return the nome
	 */
	public String getNome() {
		return nome;
	}

}
