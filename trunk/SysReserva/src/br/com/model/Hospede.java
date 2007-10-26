package src.br.com.model;
import br.com.annotation.GoDepper;
import br.com.annotation.Persistent;
import java.util.Date;

public class Hospede extends Entidade {
  @GoDepper
  private Endereco endereco;
  @Persistent
  private String foneResidencial;
  @Persistent
  private String foneContato;
  @Persistent
  private Date dataNascimento;

  public Hospede(int id){
      super.setId(id);
      this.endereco = new Endereco();
  }

  public Hospede () {
      super();
      this.endereco = new Endereco();
  }

  public Endereco getEndereco() {
    return endereco;
  }

  public void setEndereco (Endereco endereco) {
    this.endereco = endereco;
  }

  public String getFoneResidencial() {
    return foneResidencial;
  }

  public void setFoneResidencial(String foneResidencial) {
	  this.foneResidencial = foneResidencial;
  }

  public String getFoneContato() {
    return foneContato;
  }

  public void setFoneContato(String foneContato) {
	  this.foneContato = foneContato;
  }

  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento (Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }

@Override
public String toString() {
	return "Código: "+ super.getId() + " Nome: "+ super.getNome() + ".\n" +
	       endereco.toString() + "\n" +
	       "Fone resid�ncial/contato: " + foneResidencial + " / "+ foneContato;
}
}