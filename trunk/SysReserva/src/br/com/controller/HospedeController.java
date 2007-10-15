package src.br.com.controller;

import java.util.List;

import src.br.com.jdbc.dao.HospedeDao;
import src.br.com.model.Endereco;
import src.br.com.model.Hospede;

public class HospedeController {

	private HospedeDao hospedeDao;

	public HospedeController() {
		hospedeDao = new HospedeDao();
	}

	public void salvarHospede(Hospede hospede){
		hospedeDao.save(hospede);
	}
}
