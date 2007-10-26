package src.br.com.model;

import br.com.annotation.Persistent;

public class Endereco {
        @Persistent
	private String logradouro;
        @Persistent
	private String bairro;
        @Persistent     
	private String estado;
        @Persistent 
        private String cidade;
        @Persistent
	private String cep;

	// M�todos B�sicos
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
        
        public String getCidade(){
            return cidade;
        }
        
        public void setCidade(String cidade){
            this.cidade = cidade;
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
		return "Endere�o: " + logradouro + ", " + bairro + " - " + estado + ", CEP: "+ cep +".";
	}

}