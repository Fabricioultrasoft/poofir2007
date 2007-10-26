package src.br.com.model;

import java.util.Date;

public class Reserva {

	private Date inicio;
	private Date fim;
	private Apartamento apartamento;
	private Hospede hospede;

	public Reserva(Date inicio, Date fim, Apartamento apartamento, Hospede hospede) {
		this.inicio = inicio;
		this.fim = fim;
		this.apartamento = apartamento;
		this.hospede = hospede;
	}





}
