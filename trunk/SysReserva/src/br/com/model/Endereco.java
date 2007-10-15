package src.br.com.model;

public class Endereco {

	private String logradouro;

	private String bairro;

	private String estado;

	private String cep;

	// Métodos Básicos
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro){
		this.logradouro = logradouro;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro){
		this.bairro = bairro;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado){
		this.estado = estado;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep){
		this.cep = cep;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Endereço: " + logradouro + ", " + bairro + " - " + estado + ", CEP: "+ cep +".";
	}

}